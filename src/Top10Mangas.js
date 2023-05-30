import React, { useEffect, useState } from 'react';
import MangaItem from './elems/MangaItem';
import './styles/top10.css';

const TopMangas = () => {
  const [topMangas, setTopMangas] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/Backend/API?action=getTopMangas')
      .then(response => response.json())
      .then(data => {
        const topMangasWithNotePromises = data.slice(0, 10).map(manga => {
          return fetch(`http://localhost:8080/Backend/API?action=getNote&Id=${manga.id}`)
            .then(response => response.json())
            .then(noteData => {
              const mangaWithNote = { ...manga, note: noteData.note };
              return mangaWithNote;
            });
        });
        Promise.all(topMangasWithNotePromises)
          .then(topMangasWithNote => setTopMangas(topMangasWithNote));
      });
  }, []);

  return (
    <div>
      <h1>Top 10 des mangas</h1>
      <div className="item-container">
        {topMangas.map((manga, index) => (
          <MangaItem key={manga.id} manga={manga} index={index + 1} note={manga.note} />
        ))}
      </div>
    </div>
  );
};

export default TopMangas;