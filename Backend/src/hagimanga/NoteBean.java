package hagimanga;

import javax.persistence.*;

import com.google.gson.annotations.Expose;
/*Auteur :Pierre Thuriès*/
@Entity
public class NoteBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose
	private int id;
	
	/* Note d'une oeuvre, peut être vide*/
	@Expose
    private int note;

    /*Commentaire sur une oeuvre*/
	@Expose
    private String detail;

    @ManyToOne
    @Expose
    CompteUtilisateurBean compte;

    @Expose
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
