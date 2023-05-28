package hagimanga;

import java.util.Collection;

import javax.persistence.*;
/*Auteur :Pierre Thuriès*/
@Entity
public class GenreBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nom;
	
	private String description;
	
	@ManyToMany(mappedBy="genres")
	Collection<OeuvreBean> oeuvres;

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
}
