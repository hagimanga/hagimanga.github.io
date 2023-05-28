import React, { useEffect, useState } from 'react';
import AuteurItem from './elems/AuteurItem';
import './styles/top10.css';

const TopAuteurs = () => {
  const [topAuteurs, setTopAuteurs] = useState([]);

  useEffect(() => {
    // Faire une requête au backend pour obtenir le top 10 des auteurs
    fetch('http://localhost:8080/Backend/API?action=getTop10Auteurs')
      .then(response => response.json())
      .then(data => setTopAuteurs(data));
  }, []);

  return (
    <div>
      <h1>Top 10 Auteurs</h1>
        <div class="item-container">
        {topAuteurs.map((auteur, index) => (
          <AuteurItem key={auteur.id} auteur={auteur} index={index + 1} />
        ))}
        </div>
    </div>
  );
};

export default TopAuteurs;