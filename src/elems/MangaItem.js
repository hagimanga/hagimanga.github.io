import React from 'react';
import { Route } from 'react-router-dom';

const MangaItem = ({ manga }, {index}) => (
  <div className="item">
    <Route to={`/manga/${manga.id}`}>
      <img src={manga.image} alt={manga.titreFr} />
    </Route>
    <h2>{index} : {manga.titreFr}</h2>
    <p>Note : {manga.note}/100</p>
  </div>
);

export default MangaItem;