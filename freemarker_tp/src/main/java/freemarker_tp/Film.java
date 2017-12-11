package freemarker_tp;

public class Film {
	private String titre;
	private String realisateur;
	private int annee;

	public Film(String titre, String realisateur, int annee) {
		this.titre = titre;
		this.realisateur = realisateur;
		this.annee = annee;

	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String réalisateur) {
		this.realisateur = réalisateur;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int année) {
		this.annee = année;
	}
}
