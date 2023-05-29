package hagimanga;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class OeuvreBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose
	private int id;
	
	@Expose
	private String titreFr;
	@Expose
	private String titreVO;
	
	/*Date de parution de l'oeuvre*/
	@Expose
	private String parution;
	
	/* Nombre de tome de l'oeuvre*/
	@Expose
	private int nombreTome;
	
	@Expose
	private URL image;
	
	@Expose
	private String resume;

	@Expose
	@ManyToOne
	AuteurBean auteur;

	
	@OneToMany(mappedBy="cible", fetch=FetchType.EAGER)
	Collection<NoteBean> notes = new ArrayList<NoteBean>(); 

	@Expose
	@ManyToOne
	GenreBean genre;
	
	@ManyToOne
	@Expose
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

	public String getParution() {
		return parution;
	}

	public void setParution(String parution) {
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
		
		if (nombreNote != 0) {
			return result/nombreNote;
		} else {
			return 0;
		}		
	}
	
	
	public void setEditeur(EditeurBean a) {
		this.editeur = a;
	}

	public AuteurBean getAuteur() {
		return auteur;
	}

	public void setAuteur(AuteurBean auteur) {
		this.auteur = auteur;
	}

	public GenreBean getGenre() {
		return genre;
	}

	public void setGenre(GenreBean genre) {
		this.genre = genre;
	}

	public URL getImage() {
		return this.image;
	}

	public void setImage(URL image) {
		this.image = image;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
}
