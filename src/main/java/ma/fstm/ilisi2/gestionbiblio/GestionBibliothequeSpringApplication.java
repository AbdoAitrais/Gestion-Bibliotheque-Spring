package ma.fstm.ilisi2.gestionbiblio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


///This annotation creates an instance of the WebServer and the generic servlet DispatcherServlet of Spring MVC
@SpringBootApplication
public class GestionBibliothequeSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionBibliothequeSpringApplication.class, args);
    }

}
