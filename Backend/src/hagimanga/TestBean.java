package hagimanga;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class TestBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;	
	}
}
