import React, { useEffect, useState } from 'react';

const ListeTests = () => {
  const [tests, setTests] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/Backend/API?action=getTests')
      .then(response => response.json())
      .then(data => setTests(data))
      .catch(error => console.log(error));
  }, []);

  return (
    <div>
      <h1>Liste des Tests</h1>
      <ul>
        {tests.map(test => (
          <li key={test.id}>
            ID : {test.id}, Nom : {test.nom}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListeTests;