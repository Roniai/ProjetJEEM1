package manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.Patient;
import util.HibernateUtil;

public class PatientManager {
	public List<Patient> afficherTousLesPatients() {
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("FROM Patient p ORDER BY p.codepat ASC");
		List<Patient> patient = new ArrayList<Patient>();
		List l = q.list();
		Iterator i = l.iterator();
		while(i.hasNext()) {
			Object o = (Object)i.next();
			Patient p = (Patient)o;
			patient.add(p);
		}
		return patient;
	}
	
	public List<Patient> recherchePatient(String mc){
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("FROM Patient p WHERE p.codepat LIKE ? OR p.nom LIKE ? ORDER BY p.codepat ASC");
		q.setString(0, "%"+mc+"%");
		q.setString(1, "%"+mc+"%");
		List<Patient> patient = new ArrayList<Patient>();
		List l = q.list();
		Iterator i = l.iterator();
		while(i.hasNext()) {
			Object o = (Object)i.next();
			Patient p = (Patient)o;
			patient.add(p);
		}
		return patient;
	}
	
	public Patient getPatient(String codepat) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Patient p = (Patient)session.load(Patient.class, codepat);
		return p;
	}
	
	public void ajouterPatient(String codepat, String nom, String prenom, String sexe, String adresse) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Patient p = new Patient();
		p.setCodepat(codepat);
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setSexe(sexe);
		p.setAdresse(adresse);
		session.save(p);
		session.getTransaction().commit();
	}
	
	public void modifierPatient(String codepat_old, String codepat_new, String nom, String prenom, String sexe, String adresse) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		//Codepat change
		if(codepat_old!=codepat_new) {
			Patient p_old = (Patient)session.load(Patient.class, codepat_old);
			Patient p_new = new Patient();
			p_new.setCodepat(codepat_new);
			p_new.setNom(nom);
			p_new.setPrenom(prenom);
			p_new.setSexe(sexe);
			p_new.setAdresse(adresse);
			session.delete(p_old);
			session.save(p_new);
		}
		//Codepat ne change pas
		else {
			Patient p = (Patient)session.load(Patient.class, codepat_old);
			p.setNom(nom);
			p.setPrenom(prenom);
			p.setSexe(sexe);
			p.setAdresse(adresse);
			session.update(p);
		}
		session.getTransaction().commit();
	}
	
	public void supprimerPatient(String codepat) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Patient p = (Patient)session.load(Patient.class, codepat);
		session.delete(p);
		session.getTransaction().commit();
	}

}
