package bean;

public class Patient {
	private int id;
	private String codepat;
	private String nom;
	private String prenom;
	private String sexe;
	private String adresse;
	
	public Patient() {}

	public Patient(String codepat, String nom, String prenom, String sexe, String adresse) {
		super();
		this.codepat = codepat;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodepat() {
		return codepat;
	}

	public void setCodepat(String codepat) {
		this.codepat = codepat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", codepat=" + codepat + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe
				+ ", adresse=" + adresse + "]";
	}
	
}
