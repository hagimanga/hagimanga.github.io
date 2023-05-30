import React, { useContext, useState } from 'react';
import { Link, useHistory } from 'react-router-dom';
import './styles/connexion.css';

const Inscription = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [registerStatus, setRegisterStatus] = useState('');
    const history = useHistory();

    const currentDate = new Date();
    const formattedDate = currentDate.toISOString();

    const handleRegister = (event) => {
        event.preventDefault();
        // Envoyer les données à l'API en utilisant l'URL avec les bons paramètres
        const url = new URL('http://localhost:8080/Backend/API');
        url.searchParams.append('action', 'addCompteUtilisateur');
        url.searchParams.append('pseudo', username);
        url.searchParams.append('motDePasse', password);
        url.searchParams.append('inscription', "a");

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
        history.push('/connexion');
        })
        .catch(error => {
        setRegisterStatus('Erreur: ce pseudo est déjà utilisé');
        console.log(url);
        console.error(error);
        });
    };
  
    return (
        <div className="container">
        <h2>Inscription</h2>
        <form onSubmit={handleRegister}>
            <input
            type="text"
            placeholder="Nom d'utilisateur"
            required
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            />
            <input
            type="password"
            placeholder="Mot de passe"
            required
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            />
            <input type="submit" value="S'inscrire" />
            <Link to="/connexion">      
                <input type="button" value="Déjà inscrit ? C'est par ici" />
            </Link>
        </form>
        {registerStatus && <p>{registerStatus}</p>}
        </div>
    );
};

export default Inscription;