package hagimanga;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.ejb.Singleton;
import javax.persistence.*;

@Singleton
public class Facade {

	@PersistenceContext(name = "MaPU")
	EntityManager em;
	
	public void addTest(TestBean a) {
		System.out.println("Ajout TestBean");
		em.persist(a);
	}
	
	public void addOeuvre(OeuvreBean a) {
		System.out.println("Ajout OeuvreBean");
		em.persist(a);
	}
	
	public void addAuteur(AuteurBean a) {
		System.out.println("Ajout AuteurBean");
		em.persist(a);
	}
	
	
	public void addCompteUtilisateur(CompteUtilisateurBean a) {
		System.out.println("Ajout CompteUtilisateurBean");
		em.persist(a);
	}
	
	public void addEditeur(EditeurBean a) {
		System.out.println("Ajout EditeurBean");
		em.persist(a);
	}
	
	public void addGenre(GenreBean a) {
		System.out.println("Ajout GenreBean");
		em.persist(a);
	}
	
	public void addNote(NoteBean a) {
		System.out.println("Ajout NoteBean");
		em.persist(a);
	}
	
	public Collection<OeuvreBean> listeOeuvres(){
		return em.createQuery("from OeuvreBean",OeuvreBean.class).getResultList();
	}
	
	public OeuvreBean getOeuvre(int id) {
		return em.find(OeuvreBean.class, id);
	}
	
	public AuteurBean getAuteur(int id) {
		return em.find(AuteurBean.class, id);
	}
	
	public EditeurBean getEditeur(int id) {
		return em.find(EditeurBean.class, id);
	}
	
	public GenreBean getGenre(int id) {
		return em.find(GenreBean.class, id);
	}
	
	/* Pour Obtenir les oeurvres les mieux notées*/
	public ArrayList<OeuvreBean> getTopOeuvres(){
		ArrayList<OeuvreBean> oeuvres = new ArrayList(this.listeOeuvres());
		Collections.sort(oeuvres,(n1,n2) -> Integer.compare(n2.getMoyenneNote(),n1.getMoyenneNote()));
		return oeuvres;
		
	}
	
	public Collection<AuteurBean> listeAuteurs(){
		return em.createQuery("from Auteur",AuteurBean.class).getResultList();
	}
	
	public Collection<TestBean> listeTests(){
		return em.createQuery("from TestBean",TestBean.class).getResultList();
	}
	
	/* Pour Obtenir les auteurs les mieux notés*/
	public ArrayList<AuteurBean> getTopAuteurs(){
		ArrayList<AuteurBean> auteurs = new ArrayList(this.listeAuteurs());
		Collections.sort(auteurs,(n1,n2) -> Integer.compare(n2.getMoyenneNote(),n1.getMoyenneNote()));
		return auteurs;
		
	}
	
	public void associerOeuvreAuteur(int oeuvreId,int auteurId) {
		em.find(AuteurBean.class, auteurId).addOeuvres(em.find(OeuvreBean.class, oeuvreId));
	}
	
//	public void associerOeuvreEditeur(int oeuvreId,int editeurId) {
//		em.find(OeuvreBean.class, oeuvreId).setEditeur(em.find(EditeurBean.class, editeurId));
//	}
	
	public void associerOeuvreGenre(int oeuvreId,int genreId) {
		em.find(GenreBean.class, genreId).addOeuvre(em.find(OeuvreBean.class, oeuvreId));
	}
	
	public void associerOeuvreNote(int oeuvreId,int noteId) {
		em.find(NoteBean.class, noteId).setCible(em.find(OeuvreBean.class,oeuvreId));
	}
	
	public void associerNoteUtilisateur(int noteId,int utilisateurId) {
		em.find(NoteBean.class, noteId).setCompte(em.find(CompteUtilisateurBean.class, utilisateurId));
	}
	
}
