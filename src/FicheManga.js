import React, { useEffect, useState } from 'react';
import './styles/ficheManga.css';

function FicheManga(props) {
//   const [manga, setManga] = useState(null);

//   useEffect(() => {
//     const { id } = props.match.params;
//     const apiUrl = `http://localhost:8080/Backend/API?action=getManga&id=${id}`;

//     fetch(apiUrl)
//       .then(response => response.json())
//       .then(data => setManga(data))
//       .catch(error => console.error(error));
//   }, []);

//   if (!manga) {
//     return <div>Loading...</div>;
//   }

  const manga = {
    id: 1,
    titreFr: "One Piece",
    titreVO: "ワンピース",
    parution: "22 juillet 1997",
    nombreTome: 100,
    image: "https://www.glenat.com/sites/default/files/images/livres/couv/9782723488525-T.jpg",
    resume: "One Piece est un manga d'aventure écrit et dessiné par Eiichiro Oda. L'histoire suit les aventures de Monkey D. Luffy, un jeune garçon dont le corps a acquis les propriétés du caoutchouc après avoir mangé accidentellement un fruit du démon. Luffy explore le monde à la recherche du trésor ultime connu sous le nom de One Piece, dans l'espoir de devenir le roi des pirates.",
    auteurs: [],
    notes: [],
    genres: [],
    editeur: {
      id: 1,
      nom: "Shueisha"
    }
  };

  return (
    <div className="fiche-manga">
        <div className="image-container">
            <img className="manga-image" src={manga.image} alt={manga.titreFr} />
        </div>
        <div className="manga-details">
            <h2 className="manga-title">{manga.titreFr}</h2>
            <div className="attribute-row">
                <div className="attribute">
                    <span className="attribute-label">Titre VO:</span>
                    <span className="attribute-value">{manga.titreVO || "Non renseigné"}</span>
                </div>
                <div className="attribute">
                    <span className="attribute-label">Parution:</span>
                    <span className="attribute-value">{manga.parution || "Non renseigné"}</span>
                </div>
                <div className="attribute">
                    <span className="attribute-label">Nombre de tomes:</span>
                    <span className="attribute-value">{manga.nombreTome || "Non renseigné"}</span>
                </div>
                <div className="attribute">
                    <span className="attribute-label">Editeur:</span>
                    <span className="attribute-value">{manga.editeur?.nom || "Non renseigné"}</span>
                </div>
                <div className="attribute">
                    <span className="attribute-label">Auteurs:</span>
                    <span className="attribute-value">{manga.auteurs.length > 0 ? manga.auteurs.map(auteur => <div key={auteur}>{auteur}</div>) : "Non renseigné"}</span>
                </div>
                <div className="attribute">
                    <span className="attribute-label">Genres:</span>
                    <span className="attribute-value">{manga.genres.length > 0 ? manga.genres.map(genre => <div key={genre}>{genre}</div>) : "Non renseigné"}</span>
                </div>
            </div>
            <p className="manga-summary">{manga.resume}</p>
            <div className="notes-section">
            <h3>Notes</h3>
            {manga.notes.length > 0 ? (
                manga.notes.map(note => (
                <div className="note" key={note.id}>
                    <span className="note-value">{note.note}</span>
                    <span className="note-comment">{note.commentaire}</span>
                </div>
                ))
            ) : (
                <div className="no-notes">Aucune note disponible.</div>
            )}
            </div>
        </div>
    </div>
  );
}

export default FicheManga;