package beans;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class CompteUtilisateurBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    private String pseudo;

    private Date inscription;
    
    private String motDePassse;

    @OneToMany(mappedBy="compte")
    Collection<NoteBean> notesDuCompte;

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Date getInscription() {
		return inscription;
	}

	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}

	public String getMotDePassse() {
		return motDePassse;
	}

	public void setMotDePassse(String motDePassse) {
		this.motDePassse = motDePassse;
	}
}
