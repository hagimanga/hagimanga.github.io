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
		
		AuteurBean tony = new AuteurBean();
		tony.setGenre("H");
		tony.setNaissance("11 octobre 1984");
		tony.setNationalite("Français");
		tony.setNom("Tony Valente");
		facade.addAuteur(tony);
		
		AuteurBean kubo = new AuteurBean();
		kubo.setGenre("H");
		kubo.setNaissance("26 juin 1977");
		kubo.setNationalite("Japonais");
		kubo.setNom("Tite Kubo");
		facade.addAuteur(kubo);
		
		AuteurBean obata = new AuteurBean();
		obata.setGenre("H");
		obata.setNaissance("11 février 1969");
		obata.setNationalite("Japonais");
		obata.setNom("Takeshi Obata");
		facade.addAuteur(obata);
		
		AuteurBean arakawa = new AuteurBean();
		arakawa.setGenre("F");
		arakawa.setNaissance("8 mai 1973");
		arakawa.setNationalite("Japonaise");
		arakawa.setNom("Hiromu Arakawa");
		facade.addAuteur(arakawa);
		
		AuteurBean isayama = new AuteurBean();
		isayama.setGenre("H");
		isayama.setNaissance("29 août 1986");
		isayama.setNationalite("Japonais");
		isayama.setNom("Hajime Isayama");
		facade.addAuteur(isayama);
		
		AuteurBean horikoshi = new AuteurBean();
		horikoshi.setGenre("H");
		horikoshi.setNaissance("20 novembre 1986");
		horikoshi.setNationalite("Japonais");
		horikoshi.setNom("Kōhei Horikoshi");
		facade.addAuteur(horikoshi);
		
		AuteurBean toriyama = new AuteurBean();
		toriyama.setGenre("H");
		toriyama.setNaissance("5 avril 1955");
		toriyama.setNationalite("Japonais");
		toriyama.setNom("Akira Toriyama");
		facade.addAuteur(toriyama);
	
		EditeurBean shueisha = new EditeurBean();
		shueisha.setNom("Shueisha");
		facade.addEditeur(shueisha);
		
		
		EditeurBean shōgakukan = new EditeurBean();
		shōgakukan.setNom("Shōgakukan");
		facade.addEditeur(shōgakukan);
		
		EditeurBean ankama = new EditeurBean();
		ankama.setNom("Ankama");
		facade.addEditeur(ankama);
		
		EditeurBean squareEnix = new EditeurBean();
		squareEnix.setNom("Square Enix");
		facade.addEditeur(squareEnix);
		
		EditeurBean kodansha = new EditeurBean();
		kodansha.setNom("Kodansha");
		facade.addEditeur(kodansha);
		
		GenreBean nekketsu = new GenreBean();
		nekketsu.setNom("Nekketsu");
		nekketsu.setDescription("Nekketsu désigne un canevas et un procédé narratif employé principalement dans les mangas shōnen et shōsetsu. Ces récits initiatiques sont directement inspirés du concept du monomythe");
		facade.addGenre(nekketsu);
		
		GenreBean cr = new GenreBean();
		cr.setNom("Comédie romantique");
		cr.setDescription("Lit le nom du genre, bêta!");
		facade.addGenre(cr);
		
		GenreBean thriller = new GenreBean();
		thriller.setNom("Thriller");
		thriller.setDescription("Genre suscitant le suspense, l'intrigue et les rebondissements captivants.");
		facade.addGenre(thriller);
		
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
		
		OeuvreBean radiant = new OeuvreBean();
		try {
			radiant.setImage(new URL("https://m.media-amazon.com/images/I/71uBoufnhWL._AC_UF1000,1000_QL80_.jpg"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		radiant.setEditeur(ankama);
		radiant.setParution("13 juillet 2013");
		radiant.setNombreTome(72);
		radiant.setTitreFr("Radiant");
		radiant.setTitreVO("Radiant");	
		radiant.setAuteur(tony);
		radiant.setGenre(nekketsu);
		radiant.setResume("Radiant est un manga qui suit les aventures de Seth, un jeune sorcier doté de pouvoirs magiques, dans sa quête pour éliminer les monstrueux Némésis et découvrir la vérité sur son passé.");
		facade.addOeuvre(radiant);
		
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
		
		OeuvreBean bleach = new OeuvreBean();
		try {
			bleach.setImage(new URL("https://www.glenat.com/sites/default/files/styles/large/public/images/livres/couv/9782723442275-G.JPG?itok=GgSAufVE"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		bleach.setEditeur(shueisha);
		bleach.setParution("5 août 2001");
		bleach.setNombreTome(74);
		bleach.setTitreFr("Bleach");
		bleach.setTitreVO("ブリーチ");
		bleach.setAuteur(kubo);
		bleach.setGenre(nekketsu);
		bleach.setResume("Bleach suit les aventures de Ichigo Kurosaki, un lycéen devenu Shinigami (dieu de la mort), qui combat les esprits maléfiques pour protéger les humains.");
		facade.addOeuvre(bleach);
		
		OeuvreBean deathNote = new OeuvreBean();
		try {
			deathNote.setImage(new URL("https://m.media-amazon.com/images/I/91oJQn82WXL._AC_UF1000,1000_QL80_.jpg"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		deathNote.setEditeur(shueisha);
		deathNote.setParution("1er décembre 2003");
		deathNote.setNombreTome(12);
		deathNote.setTitreFr("Death Note");
		deathNote.setTitreVO("デスノート");
		deathNote.setAuteur(obata);
		deathNote.setGenre(thriller);
		deathNote.setResume("Death Note raconte l'histoire de Light Yagami qui découvre un carnet permettant de tuer les personnes dont il connaît le nom, ce qui le plonge dans une quête de justice et de pouvoir.");
		facade.addOeuvre(deathNote);
		
		OeuvreBean fullmetalAlchemist = new OeuvreBean();
		try {
			fullmetalAlchemist.setImage(new URL("https://static.fnac-static.com/multimedia/FR/images_produits/FR/Fnac.com/ZoomPE/1/7/1/9782351420171/tsp20160523120449/Fullmetal-alchemist.jpg"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		fullmetalAlchemist.setEditeur(squareEnix);
		fullmetalAlchemist.setParution("12 juillet 2001");
		fullmetalAlchemist.setNombreTome(27);
		fullmetalAlchemist.setTitreFr("Fullmetal Alchemist");
		fullmetalAlchemist.setTitreVO("鋼の錬金術師");
		fullmetalAlchemist.setAuteur(arakawa);
		fullmetalAlchemist.setGenre(nekketsu);
		fullmetalAlchemist.setResume("Fullmetal Alchemist suit les frères Edward et Alphonse Elric, des alchimistes en quête de la pierre philosophale pour restaurer leurs corps après une expérience qui a mal tourné.");
		facade.addOeuvre(fullmetalAlchemist);
		
		OeuvreBean attackOnTitan = new OeuvreBean();
		try {
			attackOnTitan.setImage(new URL("https://www.pika.fr/sites/default/files/images/livres/couv/9782811611699-T.jpg"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		attackOnTitan.setEditeur(kodansha);
		attackOnTitan.setParution("9 septembre 2009");
		attackOnTitan.setNombreTome(34);
		attackOnTitan.setTitreFr("Attack on Titan");
		attackOnTitan.setTitreVO("進撃の巨人");
		attackOnTitan.setAuteur(isayama);
		attackOnTitan.setGenre(thriller);
		attackOnTitan.setResume("Attack on Titan se déroule dans un monde où des titans géants dévorent les humains, et suit Eren Yeager et ses amis dans leur combat pour sauver l'humanité.");
		facade.addOeuvre(attackOnTitan);
		
		

		OeuvreBean myHeroAcademia = new OeuvreBean();
		try {
			myHeroAcademia.setImage(new URL("https://m.media-amazon.com/images/I/51Vh+5ION1L._SX326_BO1,204,203,200_.jpg"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		myHeroAcademia.setEditeur(shueisha);
		myHeroAcademia.setParution("7 juillet 2014");
		myHeroAcademia.setNombreTome(34);
		myHeroAcademia.setTitreFr("My Hero Academia");
		myHeroAcademia.setTitreVO("僕のヒーローアカデミア");
		myHeroAcademia.setAuteur(horikoshi);
		myHeroAcademia.setGenre(nekketsu);
		myHeroAcademia.setResume("My Hero Academia se déroule dans un monde où la majorité de la population possède des super-pouvoirs, et suit Izuku Midoriya dans sa quête pour devenir un super-héros.");
		facade.addOeuvre(myHeroAcademia);
		
		OeuvreBean dragonBall = new OeuvreBean();
		try {
			dragonBall.setImage(new URL("https://www.glenat.com/sites/default/files/images/livres/couv/9782723434621-001-T.jpeg"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		dragonBall.setEditeur(shueisha);
		dragonBall.setParution("3 décembre 1984");
		dragonBall.setNombreTome(42);
		dragonBall.setTitreFr("Dragon Ball");
		dragonBall.setTitreVO("ドラゴンボール");
		dragonBall.setAuteur(toriyama);
		dragonBall.setGenre(nekketsu);
		dragonBall.setResume("Dragon Ball raconte l'histoire de Son Goku, un jeune garçon doté de pouvoirs extraordinaires, et de ses aventures pour trouver les sept Dragon Balls afin de réaliser des vœux.");
		facade.addOeuvre(dragonBall);
		
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
		

		NoteBean noteBaba2 = new NoteBean();
		noteBaba2.setCible(naruto);
		
		noteBaba2.setCompte(baba);
		noteBaba2.setNote(58);
		noteBaba2.setDetail(";P");
		facade.addNote(noteBaba2);
		

		NoteBean noteBaba3 = new NoteBean();
		noteBaba3.setCible(myHeroAcademia);
		
		noteBaba3.setCompte(baba);
		noteBaba3.setNote(100);
		noteBaba3.setDetail(";P");
		facade.addNote(noteBaba3);
		
		NoteBean noteBaba4 = new NoteBean();
		noteBaba4.setCible(deathNote);
		
		noteBaba4.setCompte(baba);
		noteBaba4.setNote(90);
		noteBaba4.setDetail(";P");
		facade.addNote(noteBaba4);
		
		NoteBean noteBaba5 = new NoteBean();
		noteBaba5.setCible(ud);
		
		noteBaba5.setCompte(baba);
		noteBaba5.setNote(75);
		noteBaba5.setDetail(";P");
		facade.addNote(noteBaba5);
		
		
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
        else if (action.equals("getNote")) {
        	OeuvreBean oeuvre = facade.getOeuvre(Integer.parseInt(request.getParameter("Id")));
            String json = convertToJson(oeuvre.getMoyenneNote());
            sendJsonResponse(response, "{\"note\":"+json+"}");
        }
	}

}
