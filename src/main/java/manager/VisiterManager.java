package manager;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.Visiter;
import util.HibernateUtil;

public class VisiterManager {
	public List<Visiter> afficherTousLesVisiters() {
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("FROM Visiter v ORDER BY v.codemed ASC");
		List<Visiter> visiter = new ArrayList<Visiter>();
		List l = q.list();
		Iterator i = l.iterator();
		while(i.hasNext()) {
			Object o = (Object)i.next();
			Visiter v = (Visiter)o;
			visiter.add(v);
		}
		return visiter;
	}
	
	public Visiter getVisiter(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Visiter v = (Visiter)session.load(Visiter.class, id);
		return v;
	}
	
	public void ajouterVisiter(String codemed, String codepat, Date date) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Visiter v = new Visiter();
		v.setCodemed(codemed);
		v.setCodepat(codepat);
		v.setDate(date);
		session.save(v);
		session.getTransaction().commit();
	}
	
	public void modifierVisiter(int id, String codemed, String codepat, Date date) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Visiter v = (Visiter)session.load(Visiter.class, id);
		v.setCodemed(codemed);
		v.setCodepat(codepat);
		v.setDate(date);
		session.update(v);
		session.getTransaction().commit();
	}
	
	public void supprimerVisiter(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Visiter v = (Visiter)session.load(Visiter.class, id);
		session.delete(v);
		session.getTransaction().commit();
	}
}
