package beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class Facade {

	@PersistenceContext
	EntityManager em;
	
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
	
	/* Pour Obtenir les oeurvres les mieux notées*/
	public ArrayList<OeuvreBean> getTopOeuvres(){
		ArrayList<OeuvreBean> oeuvres = new ArrayList(this.listeOeuvres());
		Collections.sort(oeuvres,(n1,n2) -> Integer.compare(n2.getMoyenneNote(),n1.getMoyenneNote()));
		return oeuvres;
		
	}
	
	public Collection<AuteurBean> listeAuteurs(){
		return em.createQuery("from Auteur",AuteurBean.class).getResultList();
	}
	
	/* Pour Obtenir les auteurs les mieux notés*/
	public ArrayList<AuteurBean> getTopAuteurs(){
		ArrayList<AuteurBean> auteurs = new ArrayList(this.listeAuteur());
		Collections.sort(auteurs,(n1,n2) -> Integer.compare(n2.getMoyenneNote(),n1.getMoyenneNote()));
		return auteurs;
		
	}
	
	public void associerOeuvreAuteur(int oeuvreId,int auteurId) {
		em.find(AuteurBean.class, auteurId).addOeuvres(em.find(OeuvreBean.class, oeuvreId));
	}
	
	public void associreOeuvreEditeur(int oeuvreId,int editeurId) {
		em.find(OeuvreBean.class, oeuvreId).setEditeur(em.find(EditeurBean.class, editeurId));
	}
	
	public void associerOeuvreGenre(int oeuvreId,int genreId) {
		em.find(OeuvreBean.class, oeuvreId).addGenre(em.find(GenreBean.class, genreId));
	}
	
	public void associerOeuvreNote(int oeuvreId,int noteId) {
		em.find(NoteBean.class, noteId).setCible(em.find(OeuvreBean.class,oeuvreId));
	}
	
	public void associerNoteUtilisateur(int noteId,int utilisateurId) {
		em.find(NoteBean.class, noteId).setCompte(em.find(CompteUtilisateurBean.class, utilisateurId));
	}
}
