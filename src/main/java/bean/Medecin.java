package bean;

public class Medecin {
	private int id;
	private String codemed;
	private String nom;
	private String prenom;
	private String grade;
	
	public Medecin(){}
	
	public Medecin(String codemed, String nom, String prenom, String grade) {
		super();
		this.codemed = codemed;
		this.nom = nom;
		this.prenom = prenom;
		this.grade = grade;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodemed() {
		return codemed;
	}

	public void setCodemed(String codemed) {
		this.codemed = codemed;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Medecin [codemed=" + codemed + ", nom=" + nom + ", prenom=" + prenom + ", grade=" + grade + "]";
	}
	
	
}
