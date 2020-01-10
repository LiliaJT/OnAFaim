package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOCompteJDBC;
import dao.DAOProduit;
import dao.FactoryCompte;
import dao.FactoryProduit;
import model.Compte;
import model.Produit;





@WebServlet("/admin/gererProduit")
public class gererProduitServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		DAOProduit daoP = FactoryProduit.getDAOProduit();
		//String valid = request.getParameter("validation");
		if(true) {  //Cas ou on n'a pas cliqué sur un bouton
			try {
				List<Produit> list = daoP.selectAll();
				request.setAttribute("listC", list);
				this.getServletContext().getRequestDispatcher("/WEB-INF/admin/gererProduit.jsp").forward(request, response);
			} catch(Exception e) {e.printStackTrace();}
		}
		/*else {
			String id=request.getParameter("id");
			if(valid.contentEquals("valided")) { // On a cliqué sur le bouton check
				try {
					Compte c=daoC.selectById(Integer.parseInt(id));
					c.setCompteEtat("valide");
					daoC.update(c);
					List<Compte> list = daoC.selectAll();
					request.setAttribute("listC", list);
					this.getServletContext().getRequestDispatcher("/WEB-INF/admin/gererClient.jsp").forward(request, response);
				} catch(Exception e) {e.printStackTrace();}
			}
			else if(valid.contentEquals("notvalided")) { // On a cliqué sur le bouton not check
				try {
					daoC.delete(Integer.parseInt(id));
					List<Compte> list = daoC.selectAll();
					request.setAttribute("listC", list);
					this.getServletContext().getRequestDispatcher("/WEB-INF/admin/gererClient.jsp").forward(request, response);
				} catch(Exception e) {e.printStackTrace();}
			}
		}*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
