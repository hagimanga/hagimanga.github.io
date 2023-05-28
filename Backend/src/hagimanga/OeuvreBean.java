package hagimanga;

import javax.persistence.*;
import java.net.URL;
import java.util.Collection;
import java.util.Date;

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
	
	private URL image;
	
	private String resume;

	@ManyToMany(mappedBy="oeuvres")
	Collection<AuteurBean> auteurs;

	@OneToMany(mappedBy="cible")
	Collection<NoteBean> notes;

	@ManyToMany
	Collection<GenreBean> genres;
	
	//@ManyToOne
	//EditeurBean editeur;

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
		
		if (nombreNote != 0) {
			return result/nombreNote;
		} else {
			return 0;
		}		
	}
	
	public void addAuteur(AuteurBean a) {
		this.auteurs.add(a);
	}
	
//	public void setEditeur(EditeurBean a) {
//		this.editeur = a;
//	}
	
	public void addGenre(GenreBean a) {
		this.genres.add(a);
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
