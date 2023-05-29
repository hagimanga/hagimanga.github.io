import './App.css';
import { BrowserRouter as Router, Route, Redirect } from 'react-router-dom';

// Rajoute un contexte global
import { AuthProvider } from './AuthContext';

import Accueil from './Accueil.js';
import TopMangas from './Top10Mangas.js';
import TopAuteurs from './Top10Auteurs.js';
import FicheManga from './FicheManga';
import AjoutDonnees from './AjoutDonnees';
import AjoutManga from './AjoutManga';
import AjoutEditeur from './AjoutEditeur';
import AjoutAuteur from './AjoutAuteur';
import AjoutGenre from './AjoutGenre';
import ListeTests from './ListeTests.js';
import Connexion from './Connexion.js';
import Inscription from './Inscription.js';
import Menu from './Menu.js';
import Footer from './Footer.js';

function App() {
  return (
    <AuthProvider>
      <Router>
          <div>
            <Menu />
            <Route exact path="/">
              <Redirect to="/accueil" />
            </Route>
            <Route path="/accueil" component={Accueil} />
            <Route path="/top-10-auteurs" component={TopAuteurs} />
            <Route path="/top-10-mangas" component={TopMangas} />
            <Route path="/ajout-donnees" component={AjoutDonnees} />
            <Route path="/ajout-manga" component={AjoutManga} />
            <Route path="/ajout-editeur" component={AjoutEditeur} />
            <Route path="/ajout-auteur" component={AjoutAuteur} />
            <Route path="/ajout-genre" component={AjoutGenre} />
            <Route path="/manga/:id" component={FicheManga} />
            <Route path="/connexion" component={Connexion} />
            <Route path="/inscription" component={Inscription} />
            <Route path="/test" component={ListeTests} />
            <Footer />
          </div>
      </Router>
    </AuthProvider>
  );   
}

export default App;
