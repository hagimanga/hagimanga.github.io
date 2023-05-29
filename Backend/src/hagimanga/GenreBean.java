package hagimanga;

import java.util.Collection;

import javax.persistence.*;

import com.google.gson.annotations.Expose;
/*Auteur :Pierre Thuriès*/
@Entity
public class GenreBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose
	private int id;
	
	@Expose
	private String nom;
	
	@Expose
	private String description;
	
	@OneToMany(mappedBy="genre", fetch=FetchType.EAGER)
	Collection<OeuvreBean> oeuvresDuGenre;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "GenreBean [id=" + id + ", nom=" + nom + ", description=" + description + "]";
	}

	public void addOeuvre(OeuvreBean find) {
		this.oeuvresDuGenre.add(find);	
	}
	
}
