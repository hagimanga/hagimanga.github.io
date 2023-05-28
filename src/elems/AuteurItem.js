import React from 'react';
import { Route } from 'react-router-dom';

const AuteurItem = ({ auteur }, {index}) => (
  <div className="item">
    <Route to={`/auteur/${auteur.id}`}>
      <img src={auteur.image} alt={auteur.nom} />
    </Route>
    <h2>{index} : {auteur.nom}</h2>   
  </div>
);

export default AuteurItem;