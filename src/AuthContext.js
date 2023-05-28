import React, { createContext, useState } from 'react';

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [username, setUsername] = useState('');
  
  const login = (pseudo) => {
    setIsLoggedIn(true);
    setUsername(pseudo);
  };

  const logout = () => {
    setIsLoggedIn(false);
    setUsername('Vous êtes déconnecté.');
  };

  return (
    <AuthContext.Provider value={{ isLoggedIn, username, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};