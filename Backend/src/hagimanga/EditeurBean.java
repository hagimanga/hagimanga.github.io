package hagimanga;

import java.util.Collection;

import javax.persistence.*;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/*Auteur :Pierre Thuriès*/
@Entity
public class EditeurBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose
	private int id;
	@Expose
	private String nom;
	
    @OneToMany(mappedBy="editeur",fetch=FetchType.EAGER)
    Collection<OeuvreBean> oeuvresDeEditeur;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
