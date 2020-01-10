package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOCompte;
import dao.FactoryCompte;
import model.Compte;

/**
 * Servlet implementation class connexionServlet
 */
@WebServlet("/connexion")
public class connexionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOCompte daoC=FactoryCompte.getDAOCompte();
		
		Compte c;
		if(request.getParameter("action")!=null) 
		{
			if(request.getParameter("action").equals("connect"))
			{
				c=daoC.checkConnect(request.getParameter("email"), request.getParameter("pass"));
				if(c==null) 
				{
					request.setAttribute("error", "Login/Mot de passe invalides");
					this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
				}
				else if (c.getType().equals("client"))
				{
					request.getSession().setAttribute("isConnectClient", "Y");
					request.getSession().setAttribute("compte", c);
					this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
				}
				else if (c.getType().equals("admin"))
				{
					request.getSession().setAttribute("isConnectAdmin", "Y");
					request.getSession().setAttribute("compte", c);
					this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	
				}
				
			}
			
			else if (request.getParameter("action").equals("inscription"))
			{
				//Vérifier les name des input dans la page inscription.html
				c = new Compte(request.getParameter("nom"), request.getParameter("email"), request.getParameter("mdp"), "Client", "en attente");
				daoC.insert(c);
				this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
			}
		}
	}

}
