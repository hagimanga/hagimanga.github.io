import './App.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

// Rajoute un contexte global
import { AuthProvider } from './AuthContext';

import Accueil from './Accueil.js';
import TopMangas from './Top10Mangas.js';
import TopAuteurs from './Top10Auteurs.js';
import ListeTests from './ListeTests.js';
import Connection from './Connection.js';
import Inscription from './Inscription.js';
import Menu from './Menu.js';
import Footer from './Footer.js';
//import FicheManga from './FicheManga';

function App() {
  return (
    <AuthProvider>
      <Router>
          <div>
            <Menu />
            <Route path="/" component={Accueil} />
            <Route path="/top-10-auteurs" component={TopAuteurs} />
            <Route path="/top-10-mangas" component={TopMangas} />
            <Route path="/connection" component={Connection} />
            <Route path="/inscription" component={Inscription} />
            <Route path="/test" component={ListeTests} />
            <Footer />
          </div>
      </Router>
    </AuthProvider>
  );   
}

export default App;
