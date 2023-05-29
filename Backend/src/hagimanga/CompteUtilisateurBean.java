package hagimanga;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import com.google.gson.annotations.Expose;
@Entity
public class CompteUtilisateurBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose
	private int id;
	@Expose
    private String pseudo;

    @Expose
    private String inscription;
    
    @Expose
    private String motDePassse;

    @OneToMany(mappedBy="compte")
    Collection<NoteBean> notesDuCompte;

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getInscription() {
		return inscription;
	}

	public void setInscription(String inscription) {
		this.inscription = inscription;
	}

	public String getMotDePassse() {
		return motDePassse;
	}

	public void setMotDePassse(String motDePassse) {
		this.motDePassse = motDePassse;
	}
}
