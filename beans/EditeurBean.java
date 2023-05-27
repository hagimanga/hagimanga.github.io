package beans;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
/*Auteur :Pierre Thuriès*/
@Entity
public class EditeurBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	
    @OneToMany(mappedBy="editeur")
    Collection<OeuvreBean> oeuvresDeEditeur;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
