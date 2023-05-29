import React, { useEffect, useState } from 'react';
import MangaItem from './elems/MangaItem';
import './styles/top10.css';

const TopMangas = () => {
  const [topMangas, setTopMangas] = useState([]);

  useEffect(() => {
    // Faire une requête au backend pour obtenir le top 10 des mangas
    fetch('http://localhost:8080/Backend/API?action=getTop10Mangas')
      .then(response => response.json())
      .then(data => setTopMangas(data.slice(0, 10))); // Limiter à 10 mangas
  }, []);

  return (
    <div>
      <h1>Top 10 des mangas</h1>
        <div className="item-container">
        {topMangas.map((manga, index) => (
          <MangaItem key={manga.id} manga={manga} index={index + 1} />
        ))}
        </div>
    </div>
  );
};

export default TopMangas;