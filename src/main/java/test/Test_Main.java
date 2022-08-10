package test;

//import manager.MedecinManager;
import manager.PatientManager;
import util.HibernateUtil;

public class Test_Main {

	public static void main(String[] args) {
		PatientManager p = new PatientManager();
		
//		p.ajouterPatient("P401", "MARO", "Manana", "M", "Ampandrana");
//		p.ajouterPatient("P201", "RAKOTO", "Manandray", "M", "Masoalahy");
//		p.ajouterPatient("P351", "RASOA", "Marie", "F", "Mananara");
//		p.ajouterPatient("P601", "RABE", "Tolotra", "M", "Ampahibe");
//		p.ajouterPatient("P708", "BARY", "Mahefa", "M", "Itondra");
//		p.ajouterPatient("P970", "RINDRA", "Marinà", "F", "Mahalena");
		
//		p.modifierPatient(1, "P402", "MARO", "Manana", "M", "Ampandrana");

//		System.out.println(p.recherchePatient("1"));
		
//		MedecinManager m = new MedecinManager();
//		m.supprimerMedecin(6);
		
//		m.modifierMedecin(1, "P502", "MAHOLY", "Jeanne", "Professeur");
//		m.modifierMedecin(2, "P012", "MAHERY", "Sarobidy", "Professeur");
//		m.modifierMedecin(3, "D124", "TAHIRY", "Marie Claire", "Docteur");
//		m.modifierMedecin(4, "D117", "LALAINA", "Lovatiana", "Docteur");
//		m.modifierMedecin(5, "D004", "ANDRY", "Nomenjanahary", "Docteur");
//		m.modifierMedecin(6, "D315", "TANTELY", "Mirantsoa", "Docteur");
		
//		m.ajouterMedecin("P502", "MAHOLY", "Jeanne", "Pharmacienne");
//		m.ajouterMedecin("M012", "TAHIRY", "Marie Claire", "Médecin");
//		m.ajouterMedecin("M124", "MAHERY", "Sarobidy", "Médecin");
//		m.ajouterMedecin("I117", "LALAINA", "Lovatiana", "Infirmier");
//		m.ajouterMedecin("I004", "ANDRY", "Nomenjanahary", "Infirmier");
//		m.ajouterMedecin("SG315", "TANTELY", "Mirantsoa", "Sage-femme");
		
//		System.out.println(m.afficherTousLesMedecins());
		HibernateUtil.sessionFactory.close();
	}
}
