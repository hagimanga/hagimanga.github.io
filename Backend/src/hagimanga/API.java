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

	Integer i = 0;
	
	private void initFacade() {
		i = i +1;
		AuteurBean oda = new AuteurBean();
		oda.setGenre("H");
		oda.setNaissance("1er Janvier 1975");
		oda.setNationalite("Japonais");
		oda.setNom("Eiichiro Oda");
		facade.addAuteur(oda);
		
		AuteurBean kishi = new AuteurBean();
		kishi.setGenre("H");
		kishi.setNaissance("8 novembre 1974");
		kishi.setNationalite("Japonais");
		kishi.setNom("Masashi Kishimoto");
		facade.addAuteur(kishi);
		
		AuteurBean taka = new AuteurBean();
		taka.setGenre("F");
		taka.setNaissance("10 octobre 1957");
		taka.setNationalite("Japonaise");
		taka.setNom("Rumiko Takahashi");
		facade.addAuteur(taka);
	
		EditeurBean shueisha = new EditeurBean();
		shueisha.setNom("Shueisha");
		facade.addEditeur(shueisha);
		
		
		EditeurBean shōgakukan = new EditeurBean();
		shōgakukan.setNom("Shōgakukan");
		facade.addEditeur(shōgakukan);
		
		GenreBean nekketsu = new GenreBean();
		nekketsu.setNom("Nekketsu");
		nekketsu.setDescription("Nekketsu désigne un canevas et un procédé narratif employé principalement dans les mangas shōnen et shōsetsu. Ces récits initiatiques sont directement inspirés du concept du monomythe");
		facade.addGenre(nekketsu);
		
		GenreBean cr = new GenreBean();
		cr.setNom("Comédie romantique");
		cr.setDescription("Lit le nom du genre, bêta!");
		facade.addGenre(cr);
		
		OeuvreBean oeuvre = new OeuvreBean();
		try {
			oeuvre.setImage(new URL("https://www.glenat.com/sites/default/files/images/livres/couv/9782723488525-T.jpg"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		oeuvre.setEditeur(shueisha);
		oeuvre.setParution("22 Juillet 1997");
		oeuvre.setNombreTome(105);
		oeuvre.setTitreFr("One Piece");
		oeuvre.setTitreVO("ワンピース");	
		oeuvre.setAuteur(oda);
		oeuvre.setGenre(nekketsu);
		oeuvre.setResume("One Piece est un manga qui suit les aventures de Monkey D. Luffy et de son équipage de pirates à la recherche du légendaire trésor, le One Piece.");
		facade.addOeuvre(oeuvre);
		
		OeuvreBean naruto = new OeuvreBean();
		try {
			naruto.setImage(new URL("https://static.fnac-static.com/multimedia/Images/FR/NR/c8/8c/13/1281224/1507-1/tsp20230127083104/Naruto-Tome-1-avec-Sticker-euro.jpg"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		naruto.setEditeur(shueisha);
		naruto.setParution("20 septembre 1999");
		naruto.setNombreTome(72);
		naruto.setTitreFr("Naruto");
		naruto.setTitreVO("ナルト");	
		naruto.setAuteur(kishi);
		naruto.setGenre(nekketsu);
		naruto.setResume("Naruto est un manga qui raconte l'histoire d'un jeune ninja ambitieux nommé Naruto Uzumaki, qui lutte pour devenir le chef de son village");
		facade.addOeuvre(naruto);
		
		OeuvreBean ud = new OeuvreBean();
		try {
			ud.setImage(new URL("https://www.glenat.com/sites/default/files/images/livres/couv/9782344025307-001-T.jpeg"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		ud.setEditeur(shōgakukan);
		ud.setParution("19 août 1987");
		ud.setNombreTome(38);
		ud.setTitreFr("Ranma ½");
		ud.setTitreVO("らんま½");	
		ud.setAuteur(taka);
		ud.setGenre(cr);
		ud.setResume("Ranma 1/2 est un manga comique qui raconte l'histoire de Ranma Saotome, un jeune homme maudit qui se transforme en fille lorsqu'il est mouillé par de l'eau froide");
		facade.addOeuvre(ud);
		
		CompteUtilisateurBean baba = new CompteUtilisateurBean();
		baba.setPseudo("Baba"+i.toString());	
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
		if(i==0)this.initFacade();
			
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
        else if (action.equals("getGenres")) {
        	Collection<GenreBean> genres = facade.listeGenres();
            String json = convertToJson(genres);
            sendJsonResponse(response, json);
        }
        else if (action.equals("getEditeurs")) {
        	Collection<EditeurBean> editeurs = facade.listeEditeurs();
            String json = convertToJson(editeurs);
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
    		oeuvre.setResume(request.getParameter("resume"));
    		
    		facade.addOeuvre(oeuvre);

        }
        else if (action.equals("addAuteur")) {
        	
    		AuteurBean auteur = new AuteurBean();
    		auteur.setGenre(request.getParameter("genre"));
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
    		note.setCompte(facade.getCompte(request.getParameter("compte")));
    		note.setNote(Integer.parseInt(request.getParameter("note")));
    		note.setDetail(request.getParameter("detail"));
    		
    		facade.addNote(note);

        }
        else if (action.equals("connexion")) {
        	String pseudo = request.getParameter("pseudo");
        	String mdp = request.getParameter("mdp");
        	 sendJsonResponse(response,"{\"res\":"+facade.connexion(pseudo, mdp)+"}");

        }
	}

}
