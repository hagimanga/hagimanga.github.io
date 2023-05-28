import React from 'react';

const TestItem = ({ test }) => (
  <div className="test">
    <img src="images/img9.jpg" alt={test.nom} />
    <h2>Nom Dynamique Récupéré par API : {test.nom}</h2>
  </div>
);

export default TestItem;