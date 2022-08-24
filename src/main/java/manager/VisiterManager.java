package manager;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.Visiter;
import bean.VisiterId;
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
	
	public Visiter getVisiter(String codemed, String codepat) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Visiter v = (Visiter)session.load(Visiter.class, new VisiterId(codemed, codepat));
		return v;
	}
	
	public void ajouterVisiter(String codemed, String codepat, Date date) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Visiter v = new Visiter();
		v.setId(new VisiterId(codemed, codepat));
		v.setDate(date);
		session.save(v);
		session.getTransaction().commit();
	}
	
	public void modifierVisiter(String codemed_old, String codemed_new, String codepat_old, String codepat_new, Date date) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		//Codemed et codepat change
		if(codemed_old!=codemed_new || codepat_old!=codepat_new){
			Visiter v_old = (Visiter)session.load(Visiter.class, new VisiterId(codemed_old, codepat_old));
			Visiter v_new = new Visiter();
			v_new.setId(new VisiterId(codemed_new, codepat_new));
			v_new.setDate(date);
			session.delete(v_old);
			session.save(v_new);
		}
		
		//Codemed et codepat ne change pas
		else {
			Visiter v = (Visiter)session.load(Visiter.class, new VisiterId(codemed_old, codepat_old));
			v.setDate(date);
			session.update(v);
		}
		session.getTransaction().commit();
	}
	
	public void supprimerVisiter(String codemed, String codepat) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Visiter v = (Visiter)session.load(Visiter.class, new VisiterId(codemed, codepat));
		session.delete(v);
		session.getTransaction().commit();
	}
}
