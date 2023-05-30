import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';
import './styles/ajoutManga.css';

const AjoutEditeur = () => {
    const history = useHistory();

    const handleSubmit = (event) => {
        event.preventDefault();

        const nom = event.target.elements['nom'].value;

        // Envoyer les données à l'API en utilisant l'URL avec les bons paramètres
        const url = new URL('http://localhost:8080/Backend/API');
        url.searchParams.append('action', 'addEditeur');
        url.searchParams.append('nom', nom);
                
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
   

//    const formData = {
//     nom: event.target.elements['nom'].value,
//   };

//   console.log(JSON.stringify(formData));   

//   // Envoyer les données à l'API en utilisant fetch
//   fetch('http://localhost:8080/Backend/API?action=addEditeur', {
//     method: 'POST',
//     body: JSON.stringify(formData)
//   })
//   .then(response => response.json())
//   .then(data => {
//     console.log(data);
//     // Rediriger vers une autre page
//     console.log('La requête a été envoyée avec succès. voir avant');
//     history.push('/ajout-donnees');
//   })
//   .catch(error => {
//     console.error(error);
//   });
};

    return (
        <div>
            <h2>Ajouter un éditeur</h2>
            <form onSubmit={handleSubmit} id="ajout-editeur-form">
                <div className="form-group">
                    <label htmlFor="nom">Nom:</label>
                    <input type="text" id="nom" name="nom" />
                </div>           
                <div className="form-group">
                    <button type="submit">Ajouter l'éditeur.</button>
                </div>        
            </form>
        </div>
    );
};

export default AjoutEditeur;