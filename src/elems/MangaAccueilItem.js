import React from 'react';
import { Link } from 'react-router-dom';

const MangaAccueilItem = ({ manga }, {index}) => (
    <figure>
        <Link to={`/manga/${manga.id}`}>
            <img src={manga.image} alt={manga.titreFr} />
        </Link>
        <figcaption>{manga.titreFr}</figcaption>
    </figure>
);

export default MangaAccueilItem;