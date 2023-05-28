package hagimanga;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
/*Auteur :Pierre Thuriès*/

@Entity
public class AuteurBean {

	@Override
	public String toString() {
		return "AuteurBean [id=" + id + ", nom=" + nom + ", nationalite=" + nationalite + ", genre=" + genre
				+ ", naissance=" + naissance + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nom;

	private String nationalite;

	private int genre;

	private String naissance;
	
	@ManyToMany
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

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
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
		return result/nombreNote;
	}
	
	public void addOeuvres(OeuvreBean a) {
		this.oeuvres.add(a);
	}
	
	
}
