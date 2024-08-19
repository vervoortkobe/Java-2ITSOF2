package server;

import controller.AnimalClinicController;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyServer {
    private Server server;

    public void start() {
        //create server listening on localhost port 8080
        server = new Server(8080);

        //register API
        ResourceConfig config = new ResourceConfig();
        config.register(AnimalClinicController.class);

        //create servlet
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new ServletContainer(config)), "/api/*");

        server.setHandler(handler);

        //start server
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
