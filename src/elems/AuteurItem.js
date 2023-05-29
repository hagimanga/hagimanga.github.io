import React from 'react';
//import { Link } from 'react-router-dom';

const AuteurItem = ({ auteur, index}) => (
  <div className="item">
    {/* <Link to={`/auteur/${auteur.id}`}>
      <img src={auteur.image} alt={auteur.nom} />
    </Link> */}
    <h2>{index} : {auteur.nom}</h2>   
  </div>
);

export default AuteurItem;