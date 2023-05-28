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

/**
 * Servlet implementation class API
 */
@WebServlet("/API")
public class API extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	private Facade facade;
	
    private String convertToJson(Object data) {
        // Utilisez une bibliothèque JSON comme Gson pour convertir les objets en JSON
        // par exemple, si vous utilisez Gson :
        Gson gson = new Gson();
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
//		AuteurBean auth = new AuteurBean();
//		auth.setGenre(0);
//		auth.setNaissance(new Date());
//		auth.setNationalite("Francais");
//		auth.setNom("Mozart");
//		facade.addAuteur(auth);
//		
//		AuteurBean auth2 = new AuteurBean();
//		auth2.setGenre(0);
//		auth2.setNaissance(new Date());
//		auth2.setNationalite("Franc");
//		auth2.setNom("TestNom");
//		facade.addAuteur(auth2);
//		
//		EditeurBean ed = new EditeurBean();
//		ed.setNom("TESTEDITEURNOM");
//		facade.addEditeur(ed);
//		
//		OeuvreBean oeuvre = new OeuvreBean();
//		oeuvre.setImage(new URL("https://fr.web.img5.acsta.net/pictures/19/08/09/14/53/1842996.jpg"));
//		//oeuvre.setEditeur(ed);
//		oeuvre.setNombreTome(99);
//		oeuvre.setTitreFr("One Piece");
//		oeuvre.setTitreVO("titre vo");		
//		facade.addOeuvre(oeuvre);

		TestBean t1 = new TestBean();
		t1.setNom("AAA");
		facade.addTest(t1);
		
		TestBean t2 = new TestBean();
		t2.setNom("BBB");
		facade.addTest(t2);
		
		TestBean t3 = new TestBean();
		t3.setNom("CCC");
		facade.addTest(t3);		
		
		String action = request.getParameter("action");	
		if (action.equals("getTop10Mangas")) {
            ArrayList<OeuvreBean> topMangas = facade.getTopOeuvres();
            String json = convertToJson(topMangas);
            sendJsonResponse(response, json);
        } else if (action.equals("getTop10Auteurs")) {
        	ArrayList<AuteurBean> topAuteurs = facade.getTopAuteurs();
            String json = convertToJson(topAuteurs);
            sendJsonResponse(response, json);
        } else if (action.equals("getTests")) {
        	Collection<TestBean> tests = facade.listeTests();
            String json = convertToJson(tests);
            sendJsonResponse(response, json);
        }
	}

}
