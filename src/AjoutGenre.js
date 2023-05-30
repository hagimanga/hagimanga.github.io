import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';
import './styles/ajoutManga.css';

const AjoutGenre = () => {
    const history = useHistory();

    const handleSubmit = (event) => {
        event.preventDefault();

        const nom = event.target.elements['nom'].value;
        const description = event.target.elements['description'].value;

        // Envoyer les données à l'API en utilisant l'URL avec les bons paramètres
        const url = new URL('http://localhost:8080/Backend/API');
        url.searchParams.append('action', 'addGenre');
        url.searchParams.append('nom', nom);
        url.searchParams.append('description', description);
                
        fetch(url, {
        method: 'POST'
        })
        .then(response => {
        if (!response.ok) {
            throw new Error('Une erreur s\'est produite lors de la requête.');
        }        
        // Traiter la réponse si nécessaire
        console.log(url);
        console.log('La requête a été envoyée avec succès.');
        // Rediriger vers une autre page
        history.push('/ajout-donnees');
        })
        .catch(error => {
        console.error(error);
        });
    };

    return (
        <div>
            <h2>Ajouter un genre</h2>
            <form onSubmit={handleSubmit} id="ajout-genre-form">
                <div className="form-group">
                    <label htmlFor="nom">Nom:</label>
                    <input type="text" id="nom" name="nom" />
                </div>  
                <div className="form-group">
                    <label htmlFor="description">Description:</label>
                    <input type="text" id="description" name="description" />
                </div>           
                <div className="form-group">
                    <button type="submit">Ajouter le genre.</button>
                </div>        
            </form>
        </div>
    );
};

export default AjoutGenre;