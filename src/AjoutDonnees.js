import React from 'react';
import { Link } from 'react-router-dom';
import './styles/ajoutDonnees.css';

const AjoutDonnees = () => {
  return (
    <div className="option-container">
      <h2>Choisissez une option :</h2>
      <ul className="option-list">
        <li><Link to="/ajout-manga">Ajouter un manga</Link></li>
        <li><Link to="/ajout-auteur">Ajouter un auteur</Link></li>
        <li><Link to="/ajout-editeur">Ajouter un éditeur</Link></li>
        <li><Link to="/ajout-genre">Ajouter un genre</Link></li>
      </ul>
    </div>
  );
};

export default AjoutDonnees;