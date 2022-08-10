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
//		List<Patient> p = q.list();
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
	
	public Patient getPatient(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Patient p = (Patient)session.load(Patient.class, id);
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
	
	public void modifierPatient(int id, String codepat, String nom, String prenom, String sexe, String adresse) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Patient p = (Patient)session.load(Patient.class, id);
		p.setCodepat(codepat);
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setSexe(sexe);
		p.setAdresse(adresse);
		session.update(p);
		session.getTransaction().commit();
	}
	
	public void supprimerPatient(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Patient p = (Patient)session.load(Patient.class, id);
		session.delete(p);
		session.getTransaction().commit();
	}

}
