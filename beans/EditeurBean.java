package beans;

import java.util.Collection;

import javax.persistence.OneToMany;
public class EditeurBean {

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
