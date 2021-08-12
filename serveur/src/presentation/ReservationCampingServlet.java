package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.HebergementDAO;
import persistance.ReservationDAO;
import persistance.ResevationPlaceDAO;
import persistance.UtilisateurDAO;

public class ReservationCampingServlet extends HttpServlet {

	// DAO pour récuperer manipuler les reservations
	ReservationDAO rdao;
	// NuiteeDAO rpdao;
	UtilisateurDAO udao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
