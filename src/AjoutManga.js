import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';
import './styles/ajoutManga.css';

const AjoutManga = () => {
  const [auteurs, setAuteurs] = useState([]);
  const [genres, setGenres] = useState([]);
  const [editeurs, setEditeurs] = useState([]);

  const history = useHistory();

  useEffect(() => {
    fetch('http://localhost:8080/Backend/API?action=getAuteurs')
      .then(response => response.json())
      .then(data => setAuteurs(data));

    fetch('http://localhost:8080/Backend/API?action=getGenres')
      .then(response => response.json())
      .then(data => setGenres(data));

    fetch('http://localhost:8080/Backend/API?action=getEditeurs')
      .then(response => response.json())
      .then(data => setEditeurs(data));
  }, []);

  const handleSubmit = (event) => {
    event.preventDefault();
    
    const formData = {
      titreFr: event.target.elements['titreFr'].value,
      titreVO: event.target.elements['titreVO'].value,
      parution: event.target.elements['parution'].value,
      nombreTome: event.target.elements['nombreTome'].value,
      image: event.target.elements['image'].value,
      resume: event.target.elements['resume'].value,
      auteur: event.target.elements['auteur'].value,
      genre: event.target.elements['genre'].value,
      editeur: event.target.elements['editeur'].value
    };

    // Envoyer les données à l'API en utilisant fetch
    fetch('http://localhost:8080/Backend/API?action=addManga', {
      method: 'POST',
      body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
      // Gérer la réponse de l'API, afficher un message de succès ou d'erreur, etc.
      console.log(data);
      // Rediriger vers une autre page
      history.push('/ajout-donnees');
    })
    .catch(error => {
      console.error(error);
      // Afficher un message d'erreur
    });
  };

  return (
    <div>
        <h2>Ajouter un manga</h2>
        <form onSubmit={handleSubmit} id="ajout-manga-form">
            <div className="form-group">
                <label htmlFor="titre-francais">Titre français:</label>
                <input type="text" id="titre-francais" name="titreFr" />
            </div>

            <div className="form-group">
                <label htmlFor="titre-original">Titre original:</label>
                <input type="text" id="titre-original" name="titreVO" />
            </div>

            <div className="form-group">
                <label htmlFor="parution">Date de parution:</label>
                <input type="text" id="parution" name="parution" />
            </div>

            <div className="form-group">
                <label htmlFor="nombre-tome">Nombre de tomes:</label>
                <input type="text" id="nombre-tome" name="nombreTome" />
            </div>

            <div className="form-group">
                <label htmlFor="image">URL de l'image:</label>
                <input type="text" id="image" name="image" />
            </div>

            <div className="form-group">
                <label htmlFor="resume">Résumé:</label>
                <textarea id="resume" name="resume" rows="4"></textarea>
            </div>

            <div className="form-group">
                <label htmlFor="auteur">Auteur:</label>
                <select id="auteur" name="auteur">
                    <option value="">Sélectionner un auteur</option>
                    {auteurs.map(auteur => (
                    <option key={auteur.id} value={auteur.id}>{auteur.nom}</option>
                    ))}
                </select>
            </div>

            <div className="form-group">
                <label htmlFor="genre">Genre:</label>
                <select id="genre" name="genre">
                    <option value="">Sélectionner un genre</option>
                    {genres.map(genre => (
                    <option key={genre.id} value={genre.id}>{genre.nom}</option>
                    ))}
                </select>
            </div>

            <div className="form-group">
                <label htmlFor="editeur">Éditeur:</label>
                <select id="editeur" name="editeur">
                    <option value="">Sélectionner un éditeur</option>
                    {editeurs.map(editeur => (
                    <option key={editeur.id} value={editeur.id}>{editeur.nom}</option>
                    ))}
                </select>
            </div>     

            <div className="form-group">
                <button type="submit">Ajouter le manga !</button>
            </div>        
        </form>
    </div>
  );
};

export default AjoutManga;