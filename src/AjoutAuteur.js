import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';
import './styles/ajoutManga.css';

const AjoutAuteur = () => {
    const history = useHistory();

    const handleSubmit = (event) => {
        event.preventDefault();

        const nom = event.target.elements['nom'].value;
        const genre = event.target.elements['genre'].value;
        const nationalite = event.target.elements['nationalite'].value;
        const naissance = event.target.elements['naissance'].value;

        // Envoyer les données à l'API en utilisant l'URL avec les bons paramètres
        const url = new URL('http://localhost:8080/Backend/API');
        url.searchParams.append('action', 'addAuteur');
        url.searchParams.append('nom', nom);
        url.searchParams.append('genre', genre);
        url.searchParams.append('nationalite', nationalite);
        url.searchParams.append('naissance', naissance);

        fetch(url, {
        method: 'GET'
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
        console.log(url);
        console.error(error);
        });
    };

    return (
        <div>
            <h2>Ajouter un auteur</h2>
            <form onSubmit={handleSubmit} id="ajout-editeur-form">
                <div className="form-group">
                    <label htmlFor="nom">Nom:</label>
                    <input type="text" id="nom" name="nom" />
                </div>  
                <div className="form-group">
                    <label htmlFor="nationalite">Nationalité:</label>
                    <input type="text" id="nationalite" name="nationalite" />
                </div>  
                <div className="form-group">
                    <label htmlFor="naissance">Date de naissance (Format: 20 Décembre 1975):</label>
                    <input type="text" id="naissance" name="naissance" />
                </div> 
                <div className="form-group">
                    <label htmlFor="genre">Genre (Masculin/Féminin):</label>
                    <input type="text" id="genre" name="genre" />
                </div>           
                <div className="form-group">
                    <button type="submit">Ajouter l'auteur.</button>
                </div>        
            </form>
        </div>
    );
};

export default AjoutAuteur;