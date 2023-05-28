import React, { useContext, useState } from 'react';
import { Link } from 'react-router-dom';
import { AuthContext } from './AuthContext';
import './styles/connection.css';

const Connection = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [loginStatus, setLoginStatus] = useState('');
  const { login } = useContext(AuthContext);

  const handleLogin = async (e) => {
    e.preventDefault();

    // Vérification du pseudo et du mot de passe via l'API
    try {
      const response = await fetch(
        `http://localhost:8080/Backend/API?action=Connexion&pseudo=${username}&password=${password}`
      );

      if (response.ok) {
        const data = await response.json();
        const { res } = data;

        if (res === true) {
          // Succès de la connexion
          login(); // Met à jour l'état de connexion (~Variable Globale)
          setLoginStatus('Connexion réussie');
        } else {
          // Échec de la connexion
          setLoginStatus('Échec de la connexion');
        }
      } else {
        setLoginStatus('Échec de la connexion');
      }
    } catch (error) {
      console.log('Erreur lors de la connexion:', error);
    }
  };

  return (
    <div className="container">
      <h2>Connection</h2>
      <form onSubmit={handleLogin}>
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
        <input type="submit" value="Se connecter" />
        <Link to="/inscription">      
            <input type="button" value="Pas encore inscrit ? C'est par ici" />
        </Link>
      </form>
      {loginStatus && <p>{loginStatus}</p>}
    </div>
  );
};

export default Connection;