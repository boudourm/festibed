package serveur;

import javax.servlet.http.HttpServlet;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import presentation.BlockingServlet;
import presentation.CampingServlet;
import presentation.DepartementServlet;
import presentation.DomaineServlet;
import presentation.FestivalServlet;
import presentation.HotelServlet;
import presentation.PlaceServlet;
import presentation.RegionServlet;
import presentation.ReservationFestivalServlet;
import presentation.ResidenceServlet;
import presentation.VillageVacanceServlet;

public class FestiBedServer extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Server server;

	void start() throws Exception {
		int maxThreads = 100;
		int minThreads = 10;
		int idleTimeout = 120;

		QueuedThreadPool threadPool = new QueuedThreadPool(maxThreads, minThreads, idleTimeout);

		server = new Server(threadPool);
		ServerConnector connector = new ServerConnector(server);
		connector.setPort(8080);
		server.setConnectors(new Connector[] { connector });

		ServletHandler servletHandler = new ServletHandler();
		server.setHandler(servletHandler);

		servletHandler.addServletWithMapping(BlockingServlet.class, "/status");
		servletHandler.addServletWithMapping(FestivalServlet.class, "/api/festivals");
		servletHandler.addServletWithMapping(PlaceServlet.class, "/api/places");
		servletHandler.addServletWithMapping(DomaineServlet.class, "/api/domaines");
		servletHandler.addServletWithMapping(DepartementServlet.class, "/api/departements");
		servletHandler.addServletWithMapping(RegionServlet.class, "/api/regions");
		servletHandler.addServletWithMapping(HotelServlet.class, "/api/hotels");
		servletHandler.addServletWithMapping(VillageVacanceServlet.class, "/api/villagesvacances");
		servletHandler.addServletWithMapping(CampingServlet.class, "/api/campings");
		servletHandler.addServletWithMapping(ResidenceServlet.class, "/api/residences");
		servletHandler.addServletWithMapping(ReservationFestivalServlet.class, "/api/reservationfestival");
		
		
		
		server.start();
	}

	void stop() throws Exception {
		System.out.println("Server stop");
		server.stop();
	}

	public static void main(String[] args) throws Exception {
		FestiBedServer server = new FestiBedServer();

		server.start();
	}

}
