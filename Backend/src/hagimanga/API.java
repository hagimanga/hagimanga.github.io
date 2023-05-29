package hagimanga;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class API
 */
@WebServlet("/API")
public class API extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	private Facade facade;

	
    private String convertToJson(Object data) {
        // Utilisez une biblioth�que JSON comme Gson pour convertir les objets en JSON
        // par exemple, si vous utilisez Gson :
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(data);
	}

    private void sendJsonResponse(HttpServletResponse response, String json) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
	    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	private void initFacade() {
		AuteurBean oda = new AuteurBean();
		oda.setGenre(0);
		oda.setNaissance("1er Janvier 1975");
		oda.setNationalite("Japonais");
		oda.setNom("Eiichiro Oda");
		facade.addAuteur(oda);
		
//		AuteurBean auth2 = new AuteurBean();
//		auth2.setGenre(0);
//		auth2.setNaissance(new Date());
//		auth2.setNationalite("Franc");
//		auth2.setNom("TestNom");
//		facade.addAuteur(auth2);
//		
		EditeurBean shueisha = new EditeurBean();
		shueisha.setNom("Shueisha");
		facade.addEditeur(shueisha);
		
		GenreBean nekketsu = new GenreBean();
		nekketsu.setNom("Nekketsu");
		nekketsu.setDescription("BouBoum");
		facade.addGenre(nekketsu);
		
		OeuvreBean oeuvre = new OeuvreBean();
		try {
			oeuvre.setImage(new URL("https://fr.web.img5.acsta.net/pictures/19/08/09/14/53/1842996.jpg"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oeuvre.setEditeur(shueisha);
		oeuvre.setParution("22 Juillet 1997");
		oeuvre.setNombreTome(105);
		oeuvre.setTitreFr("One Piece");
		oeuvre.setTitreVO("ワンピース");	
		oeuvre.setAuteur(oda);
		oeuvre.setGenre(nekketsu);
		facade.addOeuvre(oeuvre);
		
		CompteUtilisateurBean baba = new CompteUtilisateurBean();
		baba.setPseudo("Baba");
		baba.setInscription("31 février 2000,5");
		baba.setMotDePassse("Bobo");
		facade.addCompteUtilisateur(baba);
		
		NoteBean noteBaba = new NoteBean();
		noteBaba.setCible(oeuvre);
		noteBaba.setCompte(baba);
		noteBaba.setNote(20);
		noteBaba.setDetail(";P");
		facade.addNote(noteBaba);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		this.initFacade();

			
		String action = request.getParameter("action");	
		if (action.equals("getTopMangas")) {
            ArrayList<OeuvreBean> topMangas = facade.getTopOeuvres();
            String json = convertToJson(topMangas);
            sendJsonResponse(response, json);
        } else if (action.equals("getTopAuteurs")) {
        	ArrayList<AuteurBean> topAuteurs = facade.getTopAuteurs();
            String json = convertToJson(topAuteurs);
            sendJsonResponse(response, json);
        } else if (action.equals("getTests")) {
        	Collection<OeuvreBean> tests = facade.listeOeuvres();
            String json = convertToJson(tests);
            sendJsonResponse(response, json);
        }
        else if (action.equals("getManga")) {
        	int id = Integer.parseInt(request.getParameter("Id"));
            String json = convertToJson(facade.getOeuvre(id));
            sendJsonResponse(response, json);
        }
        else if (action.equals("getAuteur")) {
        	int id = Integer.parseInt(request.getParameter("Id"));
            String json = convertToJson(facade.getAuteur(id));
            sendJsonResponse(response, json);
        }
        else if (action.equals("getEditeur")) {
        	int id = Integer.parseInt(request.getParameter("Id"));
            String json = convertToJson(facade.getEditeur(id));
            sendJsonResponse(response, json);
        }
        else if (action.equals("getGenre")) {
        	int id = Integer.parseInt(request.getParameter("Id"));
            String json = convertToJson(facade.getGenre(id));
            sendJsonResponse(response, json);
        }
        else if (action.equals("getMangas")) {
        	Collection<OeuvreBean> mangas = facade.listeOeuvres();
            String json = convertToJson(mangas);
            sendJsonResponse(response, json);
        }
        else if (action.equals("getAuteurs")) {
        	Collection<AuteurBean> auteurs = facade.listeAuteurs();
            String json = convertToJson(auteurs);
            sendJsonResponse(response, json);
        }
        else if (action.equals("addManga")) {
        	
        	OeuvreBean oeuvre = new OeuvreBean();
    		try {
    			oeuvre.setImage(new URL(request.getParameter("image")));
    		} catch (MalformedURLException e) {
    			e.printStackTrace();
    		}
    		oeuvre.setEditeur(facade.getEditeur(Integer.parseInt(request.getParameter("editeur"))));
    		oeuvre.setParution(request.getParameter("parution"));
    		oeuvre.setNombreTome(Integer.parseInt(request.getParameter("nombreTome")));
    		oeuvre.setTitreFr(request.getParameter("titreFr"));
    		oeuvre.setTitreVO(request.getParameter("titreVO"));	
    		oeuvre.setAuteur(facade.getAuteur(Integer.parseInt(request.getParameter("auteur"))));
    		oeuvre.setGenre(facade.getGenre(Integer.parseInt(request.getParameter("genre"))));
    		facade.addOeuvre(oeuvre);

        }
        else if (action.equals("addAuteur")) {
        	
    		AuteurBean auteur = new AuteurBean();
    		auteur.setGenre(Integer.parseInt(request.getParameter("genre")));
    		auteur.setNaissance(request.getParameter("naissance"));
    		auteur.setNationalite(request.getParameter("nationalite"));
    		auteur.setNom(request.getParameter("nom"));
    		facade.addAuteur(auteur);

        }
        else if (action.equals("addEditeur")) {
        	
    		EditeurBean edd = new EditeurBean();
    		edd.setNom(request.getParameter("nom"));
    		facade.addEditeur(edd);

        }
        else if (action.equals("addGenre")) {
        	
    		GenreBean genre = new GenreBean();
    		genre.setNom(request.getParameter("nom"));
    		genre.setDescription(request.getParameter("description"));
    		facade.addGenre(genre);

        }
        else if (action.equals("addCompteUtilisateur")) {
        	
    		CompteUtilisateurBean ce = new CompteUtilisateurBean();
    		ce.setPseudo(request.getParameter("pseudo"));
    		ce.setInscription(request.getParameter("inscription"));
    		ce.setMotDePassse(request.getParameter("motDePasse"));
    		facade.addCompteUtilisateur(ce);

        }
        else if (action.equals("addNote")) {
        	
    		NoteBean note = new NoteBean();
    		note.setCible(facade.getOeuvre(Integer.parseInt(request.getParameter("cible"))));
    		note.setCompte(facade.getCompte(Integer.parseInt(request.getParameter("compte"))));
    		note.setNote(Integer.parseInt(request.getParameter("note")));
    		note.setDetail(request.getParameter("detail"));
    		
    		facade.addNote(note);

        }
	}

}
