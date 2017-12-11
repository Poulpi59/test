package projetsix;

import java.util.Date;

public class Film {

	private Integer id;
	private String titre;
	private Date annee;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titreFilm) {
		this.titre = titreFilm;
	}
	public Date getAnnee() {
		return annee;
	}
	public void setAnnee(Date annee) {
		this.annee = annee;
	}
	
	public String toString() {
		return titre + " - " + annee +  " " + id;
		
	}
	
}
