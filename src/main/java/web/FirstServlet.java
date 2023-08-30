package web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

import dao.GestionCaracteristiqueImp;
import dao.GestionMarqueImp;
import dao.GestionVoitureImp;
import dao.GestionVoitureImpJpa;
import dao.IGestionCaracteristique;
import dao.IGestionMarque;
import dao.IGestionVoiture;

import dao.entities.Marque;

import dao.entities.Voiture;
import javax.servlet.annotation.MultipartConfig;
/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
@MultipartConfig()
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    IGestionVoiture gestion;
    IGestionMarque gestionMarque;
    IGestionCaracteristique gestionCaracteristique;
    public void init(ServletConfig config) throws ServletException {
	
    	gestion = new GestionVoitureImpJpa();
    	gestionMarque = new GestionMarqueImp();
    	gestionCaracteristique = new GestionCaracteristiqueImp();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		// TODO Auto-generated method stub
		if(session != null) {
		String action = request.getParameter("action");
		
		if(action==null) {
			List<Voiture> liste = gestion.getAllVoitures();
			request.setAttribute("liste", liste);
			request.getRequestDispatcher("Vue.jsp").forward(request, response);
		} else 
			if(action.equals("rechercher")) {
			
				 String mc = request.getParameter("mc");
		            List<Voiture> liste = gestion.getVoitureBMC(mc);
		            request.setAttribute("liste", liste);
		            request.getRequestDispatcher("Vue.jsp").forward(request, response);
			}else if(action.equals("supprimer")) {
				int id =Integer.parseInt(request.getParameter("id"));
				gestion.supprimerVoiture(id);
				
				request.setAttribute("liste", gestion.getAllVoitures());
				request.getRequestDispatcher("Vue.jsp").forward(request,response);
			
			}else if(action.equalsIgnoreCase("ajouter")) {
				
				request.setAttribute("marque", gestionMarque.getAllMarques());
				request.getRequestDispatcher("ajoutVoi.jsp").forward(request, response);
				
			}else if (action.equalsIgnoreCase("ajouterform")&&request.getMethod().equalsIgnoreCase("post")) {
				String modele = request.getParameter("modele");
				String carburant = request.getParameter("carburant");
				double prix = Double.parseDouble(request.getParameter("prix"));
				
				int idm =Integer.parseInt(request.getParameter("marque"));
				Marque marque = gestionMarque.getMarque(idm);
				
				
				Part filePart = request.getPart("image");
				String fileName = filePart.getSubmittedFileName();
				String uploadDir = "C:\\Users\\asus\\eclipse-workspace\\GestionVoitures\\src\\main\\webapp\\images\\" + fileName;

				//String uploadDir ="C:\Users\asus\eclipse-workspace\GestionVoitures\src\main\webapp\images" + fileName;
				FileOutputStream fos = new FileOutputStream(uploadDir);
				InputStream is = filePart.getInputStream();
				byte[] data = new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();
				
				String id = request.getParameter("id");
				if(id.equals("")) {
				 Voiture v =new Voiture(modele, carburant, prix);
				 v.setFilename(fileName);
				 v.setMarque(marque);
				
				gestion.ajouterVoiture(v);

				}
				else {
				Voiture v = new Voiture();
				v.setId(Integer.parseInt(id));
				v.setModele(modele);
				v.setCarburant(carburant);
				v.setPrix(prix);
				v.setFilename(fileName);
				v.setMarque(marque);
				gestion.mettreAJourVoiture(v);
				}

				
				request.setAttribute("liste", gestion.getAllVoitures());
				request.getRequestDispatcher("Vue.jsp").forward(request, response);
			}else if (action.equals("getPage")) {
			    int page = Integer.parseInt(request.getParameter("page"));
			    int pageSize = 5; // Nombre d'éléments à afficher par page

			    List<Voiture> liste = gestion.getVoituresByPage(page, pageSize);
			    request.setAttribute("liste", liste);
			    request.getRequestDispatcher("VoitureTable.jsp").forward(request, response);
			}

			
			else if (action.equalsIgnoreCase("modifier")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			Voiture voiture = gestion.getVoiture(id);
			request.setAttribute("voiture", voiture);
			request.setAttribute("marque", gestionMarque.getAllMarques());
			request.getRequestDispatcher("ajoutVoi.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("auth.js");
			}}
				}
				
		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
