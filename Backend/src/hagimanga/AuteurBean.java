package hagimanga;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.util.Collection;
/*Auteur :Pierre Thuriès*/

@Entity
public class AuteurBean {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose
	private int id;
	@Expose
	private String nom;

	@Expose
	private String nationalite;

	@Expose
	private String genre;

	@Expose
	private String naissance;
	
	@OneToMany(mappedBy="auteur", fetch=FetchType.EAGER)
	Collection<OeuvreBean> oeuvres;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNaissance() {
		return naissance;
	}

	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}
	
	public Collection<OeuvreBean> getOeuvre(){
		return this.oeuvres;
	}
	
	public int getMoyenneNote() {
		int result=0;
		int nombreNote=0;
		for(OeuvreBean i : this.getOeuvre()) {
			nombreNote = nombreNote + 1;
			result = result + i.getMoyenneNote();
		}
		if(nombreNote!=0)
		return result/nombreNote;
		else {
			return 0;
		}
	}
	
	public void addOeuvres(OeuvreBean a) {
		this.oeuvres.add(a);
	}
	
	
}
