package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/*Auteur :Pierre Thuriès*/
@Entity
public class NoteBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	/* Note d'une oeuvre, peut être vide*/
    private int note;

    /*Commentaire sur une oeuvre*/
    private String detail;

    @ManyToOne
    CompteUtilisateurBean compte;

    @ManyToOne
    OeuvreBean cible;

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public void setCible(OeuvreBean oeuvre) {
		this.cible=oeuvre;
	}
	
	public void setCompte(CompteUtilisateurBean utilisateur) {
		this.compte=utilisateur;
	}
}
