import React, { useContext } from 'react';
import { Link, useLocation } from 'react-router-dom';
import { AuthContext } from './AuthContext';
import './styles/menus.css';

const Menu = () => {
  const { isLoggedIn, username, login, logout } = useContext(AuthContext);
  const location = useLocation();
  return (
    <nav>
      <Link to="/" className={location.pathname === '/' ? 'active' : ''}>Accueil</Link>
      <Link to="/top-10-auteurs" className={location.pathname === '/top-10-auteurs' ? 'active' : ''}>TOP 10 Auteurs</Link>
      <Link to="/top-10-mangas" className={location.pathname === '/top-10-mangas' ? 'active' : ''}>TOP 10 Mangas</Link>
      <Link to="/test" className={location.pathname === '/test' ? 'active' : ''}>TEST LIAISON API</Link>      

      {isLoggedIn  ? (
        <div>
          <Link to="/ajout-donnees" className={location.pathname === '/ajout-donnees' ? 'active' : ''}>Ajouter des données</Link>
          <Link style={{ float: 'right' }} to="/">{username}</Link>
          <Link style={{ float: 'right' }} onClick={logout} to="/">Se déconnecter</Link>
        </div>
      ) : (
        <Link style={{ float: 'right' }} to="/connection" className={location.pathname === '/connection' ? 'active' : ''}>Se connecter</Link>
      )}
      </nav>
  );
};

export default Menu;
