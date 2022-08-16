package manager;

import java.io.IOException;
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
			Medecin m = new Medecin(codemed, nom, prenom, grade);
			medecinManager.ajouterMedecin(codemed, nom, prenom, grade);
			request.setAttribute("medecin", m);
			response.sendRedirect("medecin.do");
		}
		else if(path.equals("/modifierMedecin.do"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Medecin m = medecinManager.getMedecin(id);
			request.setAttribute("medecin", m);
			request.getRequestDispatcher("modifierMedecin.jsp").forward(request, response); 
		}
		else if(path.equals("/updateMedecin.do"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String codemed = request.getParameter("codemed");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenoms");
			String grade = request.getParameter("grade");
			Medecin m = new Medecin(codemed, nom, prenom, grade);
			medecinManager.modifierMedecin(id ,codemed, nom, prenom, grade);
			request.setAttribute("medecin", m);
			response.sendRedirect("medecin.do");
		}
		else if(path.equals("/supprimerMedecin.do")){
			int id = Integer.parseInt(request.getParameter("id"));
			medecinManager.supprimerMedecin(id);
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
			Patient p = new Patient(codepat, nom, prenom, sexe, adresse);
			patientManager.ajouterPatient(codepat, nom, prenom, sexe, adresse);
			request.setAttribute("patient", p);
			response.sendRedirect("patient.do?motCle=");
		}
		else if(path.equals("/modifierPatient.do"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Patient p = patientManager.getPatient(id);
			request.setAttribute("patient", p);
			request.getRequestDispatcher("modifierPatient.jsp").forward(request, response); 
		}
		else if(path.equals("/updatePatient.do"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String codepat = request.getParameter("codepat");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenoms");
			String sexe = request.getParameter("sexe");
			String adresse = request.getParameter("adresse");
			Patient p = new Patient(codepat, nom, prenom, sexe, adresse);
			patientManager.modifierPatient(id ,codepat, nom, prenom, sexe, adresse);
			request.setAttribute("patient", p);
			response.sendRedirect("patient.do?motCle=");
		}
		else if(path.equals("/supprimerPatient.do")){
			int id = Integer.parseInt(request.getParameter("id"));
			patientManager.supprimerPatient(id);
			response.sendRedirect("patient.do?motCle=");
		}
		
		//###########################  VISITER  ###########################
		
		else if(path.equals("/visiter.do")){
		  VisiterModele model = new VisiterModele(); 
		  List<Visiter> visiter = visiterManager.afficherTousLesVisiters(); 
		  model.setVisiters(visiter);
		  request.setAttribute("model", model);
		  request.getRequestDispatcher("visiter.jsp").forward(request, response); 
		}
		else if(path.equals("/ajouterVisiter.do")){
			request.getRequestDispatcher("ajouterVisiter.jsp").forward(request, response); 
		}
		else if(path.equals("/saveVisiter.do") && request.getMethod().equals("POST")){
			String codemed = request.getParameter("codemed");
			String codepat = request.getParameter("codepat");
			String date = request.getParameter("date");
			Visiter v = new Visiter(codemed, codepat, date);
			visiterManager.ajouterVisiter(codemed, codepat, date);
			request.setAttribute("visiter", v);
			response.sendRedirect("visiter.do");
		}
		else if(path.equals("/modifierVisiter.do"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Visiter v = visiterManager.getVisiter(id);
			request.setAttribute("visiter", v);
			request.getRequestDispatcher("modifierVisiter.jsp").forward(request, response); 
		}
		else if(path.equals("/updateVisiter.do"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String codemed = request.getParameter("codemed");
			String codepat = request.getParameter("codepat");
			String date = request.getParameter("date");
			Visiter v = new Visiter(codemed, codepat, date);
			visiterManager.modifierVisiter(id ,codemed, codepat, date);
			request.setAttribute("visiter", v);
			response.sendRedirect("visiter.do");
		}
		else if(path.equals("/supprimerVisiter.do")){
			int id = Integer.parseInt(request.getParameter("id"));
			visiterManager.supprimerVisiter(id);
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
