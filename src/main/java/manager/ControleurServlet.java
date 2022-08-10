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
import web.MedecinModele;

@WebServlet (urlPatterns = {"/","*.do"})


public class ControleurServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

		MedecinManager medecinManager;

	@Override
	public void init() throws ServletException{
		medecinManager = new MedecinManager();
	}
	
	//###########################  MEDECIN  ###########################
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path=request.getServletPath();

		if(path.equals("/")){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		else if(path.equals("/medecin.do")){
		  MedecinModele model = new MedecinModele(); List<Medecin> medecin =
		  medecinManager.afficherTousLesMedecins(); model.setMedecins(medecin);
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
			request.getRequestDispatcher("medecin.jsp").forward(request, response);
		}
		else if(path.equals("/supprimerMedecin.do")){
			int id = Integer.parseInt(request.getParameter("id"));
			medecinManager.supprimerMedecin(id);
			request.getRequestDispatcher("medecin.jsp").forward(request, response);
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
			request.getRequestDispatcher("medecin.jsp").forward(request, response);
		}
//		
//	//###########################  SITE  ###########################
//		
//		else if(path.equals("/site.do")){
//			SiteModele modelS = new SiteModele();
//			List<Site> site = metierSite.afficherSite();
//			modelS.setSites(site);
//			request.setAttribute("model", modelS);
//			request.getRequestDispatcher("site.jsp").forward(request, response); 
//		}
//		else if(path.equals("/ajouterSite.do")){
//			request.getRequestDispatcher("ajouterSite.jsp").forward(request, response); 
//		}
//		else if(path.equals("/saveSite.do") && request.getMethod().equals("POST")){
//			String numsite = request.getParameter("numsite");
//			String nomsite = request.getParameter("nomsite");
//			String lieusite = request.getParameter("lieusite");
//			int tarifsite = Integer.parseInt(request.getParameter("tarifsite"));
//			Site s = metierSite.save(new Site(numsite,nomsite,lieusite,tarifsite));
//			request.setAttribute("site", s);
//			response.sendRedirect("site.do"); 
//			
//		}
//		else if(path.equals("/supprimerSite.do")){
//			String numsite = request.getParameter("numsite");
//			metierSite.deleteSite(numsite);	
//			response.sendRedirect("site.do"); 
//		}
//		else if(path.equals("/editerSite.do"))
//		{
//			String numsite = request.getParameter("numsite");
//			Site s = metierSite.getSite(numsite);
//			request.setAttribute("site", s);
//			request.getRequestDispatcher("editerSite.jsp").forward(request, response); 
//		}
//		else if(path.equals("/updateSite.do"))
//		{
//			String numsite = request.getParameter("numsite");
//			String numsite_hidden = request.getParameter("numsite_hidden");
//			String nomsite = request.getParameter("nomsite");
//			String lieusite = request.getParameter("lieusite");
//			int tarifsite = Integer.parseInt(request.getParameter("tarifsite"));			
//			Site s = new Site();
//			s.setNumsite(numsite);
//			s.setNumsite_hidden(numsite_hidden);
//			s.setNomsite(nomsite);
//			s.setLieusite(lieusite);
//			s.setTarifsite(tarifsite);
//			metierSite.updateSite(s);
//			request.setAttribute("site", s);
//			response.sendRedirect("site.do"); 
//		}
		
		//###########################  VISITER  ###########################
		
//		else if(path.equals("/visiter.do")){
//			VisiterModele modelV = new VisiterModele();
//			List<Visiter> vist = metierVisiter.afficherVisiter();
//			modelV.setVisiter(vist);
//			request.setAttribute("model", modelV);
//			request.getRequestDispatcher("visiter.jsp").forward(request, response); 
//		}
//		else if(path.equals("/ajouterVisiter.do")){
//			request.getRequestDispatcher("ajouterVisiter.jsp").forward(request, response); 
//		}
//		else if(path.equals("/saveVisiter.do") && request.getMethod().equals("POST")){
//			String numvist = request.getParameter("numvist");
//			String numsite = request.getParameter("numsite");
//			int nbjours = Integer.parseInt(request.getParameter("nbjours"));
//			String datevisite = request.getParameter("datevisite");
//			Visiter v = metierVisiter.save(new Visiter(numvist,numsite,nbjours,datevisite));
//			request.setAttribute("visiter", v);
//			response.sendRedirect("visiter.do"); 
//			
//		}
//		else if(path.equals("/supprimerVisiter.do")){
//			String numvist = request.getParameter("numvist");
//			String numsite = request.getParameter("numsite");
//			metierVisiter.deleteVisiter(numvist, numsite);
//			response.sendRedirect("visiter.do"); 
//		}
//		else if(path.equals("/editerVisiter.do"))
//		{
//			String numvist = request.getParameter("numvist");
//			String numsite = request.getParameter("numsite");
//			Visiter v = metierVisiter.getVisiter(numvist, numsite);
//			request.setAttribute("visiter", v);
//			request.getRequestDispatcher("editerVisiter.jsp").forward(request, response); 
//		}
//		else if(path.equals("/updateVisiter.do"))
//		{
//			String numvist = request.getParameter("numvist");
//			String numsite = request.getParameter("numsite");
//			String numvist_hidden = request.getParameter("numvist_hidden");
//			String numsite_hidden = request.getParameter("numsite_hidden");
//			int nbjours = Integer.parseInt(request.getParameter("nbjours"));
//			String datevisite = request.getParameter("datevisite");		
//			Visiter v = new Visiter();
//			v.setNumvist(numvist);
//			v.setNumsite(numsite);
//			v.setNumvist_hidden(numvist_hidden);
//			v.setNumsite_hidden(numsite_hidden);
//			v.setNbjours(nbjours);
//			v.setDatevisite(datevisite);
//			metierVisiter.updateVisiter(v);
//			request.setAttribute("visiter", v);
//			response.sendRedirect("visiter.do"); 
//		}
		
		//###########################  BILAN (requ�te jointure)  ###########################
		
//		else if(path.equals("/bilan.do")){
//			response.sendRedirect("choixNomSite.do?nomsiteSelect="); 
//		}
//		else if(path.equals("/choixNomSite.do")){
//			String nomsiteSelect = request.getParameter("nomsiteSelect");		
//			BilanModele modelB = new BilanModele();
//			List<Bilan> bilan = metierBilan.bilanVisiter(nomsiteSelect);
//			modelB.setBilans(bilan);
//			modelB.setNomsiteSelect(nomsiteSelect);
//			request.setAttribute("model", modelB);
//			SiteModele modelS = new SiteModele();
//			List<Site> site = metierSite.afficherSite();
//			modelS.setSites(site);
//			request.setAttribute("modelS", modelS);
//			request.getRequestDispatcher("bilan.jsp").forward(request, response); 
//		}
		
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
