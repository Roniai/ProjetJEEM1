package test;

import java.sql.Date;
import java.text.SimpleDateFormat;

import bean.Medecin;
import bean.Visiter;
import manager.MedecinManager;
import manager.PatientManager;
import manager.VisiterManager;
import util.HibernateUtil;
import web.VisiterModele;

public class Test_Main {

	public static void main(String[] args){
		
		//MEDECIN - TEST
		
//		MedecinManager m = new MedecinManager();
//		
//		m.ajouterMedecin("A502", "MAHOLY", "Jeanne", "P");
//		m.ajouterMedecin("A012", "TAHIRY", "Marie Claire", "P");
//		m.ajouterMedecin("B124", "MAHERY", "Sarobidy", "D");
//		m.ajouterMedecin("C117", "LALAINA", "Lovatiana", "D");
//		m.ajouterMedecin("C004", "ANDRY", "Nomenjanahary", "MI");
//		m.ajouterMedecin("D315", "TANTELY", "Mirantsoa", "E");
		
		
//		m.modifierMedecin("A502", "A502", "MAHOLY", "Jeannes", "P");
//		m.modifierMedecin("A012", "A012", "TAHIRY", "Marie Claire", "P");
//		m.modifierMedecin("B124", "B124", "MAHERY", "Sarobidy", "D");
//		m.modifierMedecin("C117", "C117", "LALAINA", "Lovatiana", "D");
//		m.modifierMedecin("C004", "C004", "ANDRY", "Nomenjanahary", "MI");
//		m.modifierMedecin("D315", "D315", "TANTELY", "Mirantsoa", "E");
		
//		m.supprimerMedecin("A502");
		
//		System.out.println(m.afficherTousLesMedecins());
		
//		System.out.println(m.getMedecin("A012"));
		
		
		//PATIENT - TEST
		
//		PatientManager p = new PatientManager();
//	
//		p.ajouterPatient("PA401", "MARO", "Manana", "M", "Ampandrana");
//		p.ajouterPatient("PB502", "RAKOTO", "Manandray", "M", "Masoalahy");
//		p.ajouterPatient("PB351", "RASOA", "Marie", "F", "Mananara");
//		p.ajouterPatient("PC601", "RABE", "Tolotra", "M", "Ampahibe");
//		p.ajouterPatient("PC708", "BARY", "Mahefa", "M", "Itondra");
//		p.ajouterPatient("PE970", "RINDRA", "Marinà", "F", "Mahalena");
	
//		p.modifierPatient("P401", "P401", "MARO", "Manana", "M", "Ampandrana");
//		p.modifierPatient("P502", "P502", "RAKOTO", "Manandray", "M", "Masoalahy");
//		p.modifierPatient("P351", "P351", "RASOA", "Marie", "F", "Mananara");
//		p.modifierPatient("P601", "P601", "RABE", "Tolotra", "M", "Ampahibe");
//		p.modifierPatient("P708", "P708", "BARY", "Mahefa", "M", "Itondra");
//		p.modifierPatient("P970", "P970", "RINDRA", "Marinà", "F", "Mahalena");
	
//		p.supprimerPatient("P401");

//		System.out.println(p.recherchePatient("P502"));
		
//		System.out.println(p.afficherTousLesPatients());
		
//		System.out.println(p.getPatient("P351"));
		
		
		//VISITE - TEST
		
//		VisiterManager v = new VisiterManager();
		
//		v.ajouterVisiter("P444", "P444", Date.valueOf("2022-08-12"));
//		v.ajouterVisiter("P401", "P502", Date.valueOf("2022-08-13"));
//		v.ajouterVisiter("P012", "P601", Date.valueOf("2022-08-16"));
//		v.ajouterVisiter("D117", "P970", Date.valueOf("2022-08-18"));
		
//		System.out.println(v.getVisiter("P012", "P601"));
		
//		v.modifierVisiter("P444", "P444", "P401", "P401", Date.valueOf("2022-08-16"));
		
//		v.supprimerVisiter("P012", "P601");
		
		HibernateUtil.sessionFactory.close();
	}
}
