import React from 'react';
import { Route } from 'react-router-dom';

const MangaAccueilItem = ({ manga }, {index}) => (
    <figure>
        <Route to={`/manga/${manga.id}`}>
            <img src={manga.image} alt={manga.titreFr} />
        </Route>
        <figcaption>{manga.titreFr}</figcaption>
    </figure>
);

export default MangaAccueilItem;