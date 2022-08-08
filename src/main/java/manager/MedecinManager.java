package manager;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.Medecin;
import util.HibernateUtil;

public class MedecinManager {
	public List<Medecin> afficherTousLesMedecins() {
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from Medecin m");
		List<Medecin> m = q.list();
		return m;
	}
	
	public Medecin getMedecin(String codemed) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Medecin m = (Medecin)session.load(Medecin.class, codemed);
		return m;
	}
	
	public void ajouterMedecin(String codemed, String nom, String prenom, String grade) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Medecin m = new Medecin();
		m.setCodemed(codemed);
		m.setNom(nom);
		m.setPrenom(prenom);
		m.setGrade(grade);
		session.save(m);
		session.getTransaction().commit();
	}
	
	public void modifierMedecin(String codemed,String codemed_new, String nom, String prenom, String grade) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Medecin m = (Medecin)session.load(Medecin.class, codemed);
		Medecin med_new = new Medecin(); 
		med_new.setCodemed(codemed_new);
		med_new.setNom(nom);
		med_new.setPrenom(prenom);
		med_new.setGrade(grade);
		session.save(med_new);
		session.delete(m);
		session.getTransaction().commit();
	}
	
	public void supprimerMedecin(String codemed) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Medecin m = (Medecin)session.load(Medecin.class, codemed);
		session.delete(m);
		session.getTransaction().commit();
	}

}
