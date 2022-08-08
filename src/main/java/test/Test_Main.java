package test;

import manager.MedecinManager;
import util.HibernateUtil;

public class Test_Main {

	public static void main(String[] args) {
		MedecinManager m = new MedecinManager();
//		m.ajouterMedecin("P502", "MAHOLY", "Jeanne", "Pharmacienne");
		System.out.println(m.getMedecin("P502"));
		HibernateUtil.sessionFactory.close();
	}
}
