package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOCompte;
import dao.DAOPanier;
import dao.FactoryPanier;
import model.Compte;
import model.Panier;


@WebServlet("/panier")
public class panierServlet extends HttpServlet {
	
	static DAOPanier daoP=FactoryPanier.getDAOPanier();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String supprProd= request.getParameter("supprProd");		
		Compte c=(Compte) request.getSession().getAttribute("compte");
		
		if(supprProd==null)
		{
			try
			{
				List<Panier> list= daoP.selectAllForClient(c.getIdCompte());
				request.setAttribute("lstProduits", list);
				this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			}
			catch(Exception e) {e.printStackTrace();}
		}
		
		else
		{
			String idP= request.getParameter("idProd");
			
			if(supprProd.contentEquals("supprimer")) //j'ai appuyer sur le - pour retirer un produit
			{
				try {
					Panier p=daoP.selectById(Integer.parseInt(idP));
					p.setQte(p.getQte()-1);
					daoP.update(p);
					this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
				}
				catch(Exception e) {e.printStackTrace();}
			}
		}
	
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
