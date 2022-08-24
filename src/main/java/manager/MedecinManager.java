package manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.Medecin;
import util.HibernateUtil;

public class MedecinManager {
	public List<Medecin> afficherTousLesMedecins() {
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("FROM Medecin m ORDER BY m.codemed ASC");
		List<Medecin> medecin = new ArrayList<Medecin>();
		List l = q.list();
		Iterator i = l.iterator();
		while(i.hasNext()) {
			Object o = (Object)i.next();
			Medecin m = (Medecin)o;
			medecin.add(m);
		}
		return medecin;
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
	
	public void modifierMedecin(String codemed_old, String codemed_new, String nom, String prenom, String grade) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		//Codemed change
		if(codemed_old!=codemed_new) {
			Medecin m_old = (Medecin)session.load(Medecin.class, codemed_old);
			Medecin m_new = new Medecin();
			m_new.setCodemed(codemed_new);
			m_new.setNom(nom);
			m_new.setPrenom(prenom);
			m_new.setGrade(grade);
			session.delete(m_old);
			session.save(m_new);
		}
		//Codemed ne change pas
		else {
			Medecin m = (Medecin)session.load(Medecin.class, codemed_old);
			m.setNom(nom);
			m.setPrenom(prenom);
			m.setGrade(grade);
			session.update(m);
		}
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
