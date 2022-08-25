package manager;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import bean.Medecin;
import bean.Patient;
import bean.Visiter;
import bean.VisiterId;
import web.MedecinModele;
import web.PatientModele;
import web.VisiterModele;

@WebServlet (urlPatterns = {"/patient","*.do"})

public class ControleurServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

		MedecinManager medecinManager;
		PatientManager patientManager;
		VisiterManager visiterManager;

	@Override
	public void init() throws ServletException{
		medecinManager = new MedecinManager();
		patientManager = new PatientManager();
		visiterManager = new VisiterManager();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path=request.getServletPath();

		if(path.equals("/patient")){
			response.sendRedirect("patient.do?motCle="); 
		}
		if(path.equals("/")){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		//Save et Update : button côté formulaire
		
		//###########################  MEDECIN  ###########################
		
		else if(path.equals("/medecin.do")){
		    MedecinModele model = new MedecinModele(); 
		    List<Medecin> medecin = medecinManager.afficherTousLesMedecins(); 
		    model.setMedecins(medecin);
		    request.setAttribute("model", model);
		    request.getRequestDispatcher("medecin.jsp").forward(request, response); 
		}
		else if(path.equals("/ajouterMedecin.do")){
			request.getRequestDispatcher("ajouterMedecin.jsp").forward(request, response);
		}
		else if(path.equals("/saveMedecin.do") && request.getMethod().equals("POST")){
			String codemed = request.getParameter("codemed");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String grade = request.getParameter("grade");
			medecinManager.ajouterMedecin(codemed, nom, prenom, grade);
			response.sendRedirect("medecin.do");
		}
		else if(path.equals("/modifierMedecin.do"))
		{
			String codemed = request.getParameter("codemed");
			Medecin m = medecinManager.getMedecin(codemed);
			request.setAttribute("medecin", m);
			request.getRequestDispatcher("modifierMedecin.jsp").forward(request, response); 
		}
		else if(path.equals("/updateMedecin.do"))
		{
			String codemed_old = request.getParameter("codemed_old");
			String codemed_new = request.getParameter("codemed_new");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String grade = request.getParameter("grade");
			medecinManager.modifierMedecin(codemed_old, codemed_new, nom, prenom, grade);
			response.sendRedirect("medecin.do");
		}
		else if(path.equals("/supprimerMedecin.do")){
			String codemed = request.getParameter("codemed");
			medecinManager.supprimerMedecin(codemed);
			response.sendRedirect("medecin.do");
		}
		
		//###########################  PATIENT  ###########################
		
		else if(path.equals("/patient.do")){
			String motCle = request.getParameter("motCle");
			PatientModele model = new PatientModele(); 
			List<Patient> patient = patientManager.recherchePatient(motCle); 
			model.setMotCle(motCle);
			model.setPatients(patient);
			request.setAttribute("model", model);
			request.getRequestDispatcher("patient.jsp").forward(request, response); 
		}
		else if(path.equals("/ajouterPatient.do")){
			request.getRequestDispatcher("ajouterPatient.jsp").forward(request, response); 
		}
		else if(path.equals("/savePatient.do") && request.getMethod().equals("POST")){
			String codepat = request.getParameter("codepat");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String sexe = request.getParameter("sexe");
			String adresse = request.getParameter("adresse");
			patientManager.ajouterPatient(codepat, nom, prenom, sexe, adresse);
			response.sendRedirect("patient.do?motCle=");
		}
		else if(path.equals("/modifierPatient.do"))
		{
			String codepat = request.getParameter("codepat");
			Patient p = patientManager.getPatient(codepat);
			request.setAttribute("patient", p);
			request.getRequestDispatcher("modifierPatient.jsp").forward(request, response); 
		}
		else if(path.equals("/updatePatient.do"))
		{
			String codepat_old = request.getParameter("codepat_old");
			String codepat_new = request.getParameter("codepat_new");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String sexe = request.getParameter("sexe");
			String adresse = request.getParameter("adresse");
			patientManager.modifierPatient(codepat_old ,codepat_new, nom, prenom, sexe, adresse);
			response.sendRedirect("patient.do?motCle=");
		}
		else if(path.equals("/supprimerPatient.do")){
			String codepat = request.getParameter("codepat");
			patientManager.supprimerPatient(codepat);
			response.sendRedirect("patient.do?motCle=");
		}
		
		//###########################  VISITER  ###########################

		else if(path.equals("/visiter.do")){
		    VisiterModele model = new VisiterModele();
		    List<Visiter> visiter = visiterManager.afficherTousLesVisiters();
		    model.setVisiters(visiter);
		    request.setAttribute("model", model);
		    //Convert java.sql.Date to String format(day-month-year)
		    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		    request.setAttribute("sdf", sdf);
		    request.getRequestDispatcher("visiter.jsp").forward(request, response);
		}
		else if(path.equals("/ajouterVisiter.do")){
			request.getRequestDispatcher("ajouterVisiter.jsp").forward(request, response); 
		}
		else if(path.equals("/saveVisiter.do") && request.getMethod().equals("POST")){
			String codemed = request.getParameter("codemed");
			String codepat = request.getParameter("codepat");
			String date = request.getParameter("date");
			//Convert String to java.sql.Date
			visiterManager.ajouterVisiter(codemed, codepat, Date.valueOf(date));
			response.sendRedirect("visiter.do");
		}
		else if(path.equals("/modifierVisiter.do"))
		{
			String codemed = request.getParameter("codemed");
			String codepat = request.getParameter("codepat");
			Visiter v = visiterManager.getVisiter(codemed, codepat);
			request.setAttribute("visiter", v);
			request.getRequestDispatcher("modifierVisiter.jsp").forward(request, response); 
		}
		else if(path.equals("/updateVisiter.do"))
		{
			String codemed_old = request.getParameter("codemed_old");
			String codepat_old = request.getParameter("codepat_old");
			String codemed_new = request.getParameter("codemed_new");
			String codepat_new = request.getParameter("codepat_new");
			String date = request.getParameter("date");
			visiterManager.modifierVisiter(codemed_old ,codemed_new, codepat_old, codepat_new, Date.valueOf(date));
			response.sendRedirect("visiter.do");
		}
		else if(path.equals("/supprimerVisiter.do")){
			String codemed = request.getParameter("codemed");
			String codepat = request.getParameter("codepat");
			visiterManager.supprimerVisiter(codemed, codepat);
			response.sendRedirect("visiter.do");
		}
		
		else 
		{
			response.sendError(Response.SC_NOT_FOUND);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
		
}
