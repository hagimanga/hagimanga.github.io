import React, { useEffect, useState } from 'react';
import MangaAccueilItem from './elems/MangaAccueilItem';
import './styles/index.css';

const ListeMangas = () => {
  const [listeMangas, setListeMangas] = useState([]);

  useEffect(() => {
    // Faire une requête au backend pour obtenir la liste des mangas
    fetch('http://localhost:8080/Backend/API?action=getMangas')
      .then(response => response.json())
      .then(data => setListeMangas(data));
  }, []);

  return (
    <div class="gallery">
        {listeMangas.map((manga, index) => (
          <MangaAccueilItem key={manga.id} manga={manga}/>
        ))}
    </div>
    );
};

export default ListeMangas;