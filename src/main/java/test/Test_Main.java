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
		
		VisiterManager v = new VisiterManager();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(sdf.format(v.getVisiter(3).getDate()));
//		v.ajouterVisiter("P502", "P502", Date.valueOf("2022-08-12"));
//		v.ajouterVisiter("P502", "P502", Date.valueOf("2022-08-13"));
//		v.ajouterVisiter("P012", "P601", Date.valueOf("2022-08-16"));
//		v.ajouterVisiter("D117", "P970", Date.valueOf("2022-08-18"));
		
		  
//		  MedecinManager m = new MedecinManager();
//		  System.out.println(m.getMedecinCode("D315"));
		
//		VisiterManager v = new VisiterManager();
		
//		v.modifierVisiter(1, "P315", "P401", "20/08/22");
		
//		v.ajouterVisiter("P502", "P502", "20/08/22");
//		v.ajouterVisiter("P012", "P601", "12/08/22");
//		v.ajouterVisiter("D117", "P970", "12/08/22");
		
//		PatientManager p = new PatientManager();
//		
//		p.ajouterPatient("P401", "MARO", "Manana", "M", "Ampandrana");
//		p.ajouterPatient("P502", "RAKOTO", "Manandray", "M", "Masoalahy");
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
		
//		m.ajouterMedecin("P502", "MAHOLY", "Jeanne", "P");
//		m.ajouterMedecin("M012", "TAHIRY", "Marie Claire", "P");
//		m.ajouterMedecin("M124", "MAHERY", "Sarobidy", "D");
//		m.ajouterMedecin("I117", "LALAINA", "Lovatiana", "D");
//		m.ajouterMedecin("I004", "ANDRY", "Nomenjanahary", "MI");
//		m.ajouterMedecin("SG315", "TANTELY", "Mirantsoa", "E");
		
//		System.out.println(m.afficherTousLesMedecins());
		HibernateUtil.sessionFactory.close();
	}
}
