package test;

import manager.MedecinManager;
import util.HibernateUtil;

public class Test_Main {

	public static void main(String[] args) {
		MedecinManager m = new MedecinManager();
		
//		m.supprimerMedecin(6);
		
//		m.modifierMedecin(1, "P502", "MAHOLY", "Jeanne", "Professeur");
//		m.modifierMedecin(2, "M012", "MAHERY", "Sarobidy", "Professeur");
//		m.modifierMedecin(3, "M124", "TAHIRY", "Marie Claire", "Docteur");
//		m.modifierMedecin(4, "I117", "LALAINA", "Lovatiana", "Docteur");
//		m.modifierMedecin(5, "I004", "ANDRY", "Nomenjanahary", "Docteur");
//		m.modifierMedecin(6, "SG315", "TANTELY", "Mirantsoa", "Docteur");
		
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
