package beans;

import java.net.URL;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OeuvreBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String titreFr;
	private String titreVO;
	
	/*Date de parution de l'oeuvre*/
	private Date parution;
	
	/* Nombre de tome de l'oeuvre*/
	private int nombreTome;
	
	private URL Image;
	
	private String Resume;

	@ManyToMany(mappedBy="oeuvres")
	Collection<AuteurBean> auteurs;

	@OneToMany(mappedBy="cible")
	Collection<NoteBean> notes;

	@ManyToMany
	Collection<GenreBean> genres;
	
	@ManyToOne
	EditeurBean editeur;

	public String getTitreFr() {
		return titreFr;
	}

	public void setTitreFr(String titreFr) {
		this.titreFr = titreFr;
	}

	public String getTitreVO() {
		return titreVO;
	}

	public void setTitreVO(String titreVO) {
		this.titreVO = titreVO;
	}

	public Date getParution() {
		return parution;
	}

	public void setParution(Date parution) {
		this.parution = parution;
	}

	public int getNombreTome() {
		return nombreTome;
	}

	public void setNombreTome(int nombreTome) {
		this.nombreTome = nombreTome;
	}
	
	public Collection<NoteBean> getNotes(){
		return this.notes;
	}
	
	public int getMoyenneNote() {
		int result=0;
		int nombreNote=0;
		for(NoteBean i : this.getNotes()) {
			nombreNote = nombreNote + 1;
			result = result + i.getNote();
		}
		return result/nombreNote;
	}
	
	public void addAuteur(AuteurBean a) {
		this.auteurs.add(a);
	}
	
	public void setEditeur(EditeurBean a) {
		this.editeur = a;
	}
	
	public void addGenre(GenreBean a) {
		this.genres.add(a);
	}

	public URL getImage() {
		return Image;
	}

	public void setImage(URL image) {
		Image = image;
	}

	public String getResume() {
		return Resume;
	}

	public void setResume(String resume) {
		Resume = resume;
	}
}
