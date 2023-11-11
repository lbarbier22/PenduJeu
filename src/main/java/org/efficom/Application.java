package org.efficom;

/**
 * Hello world!
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);

//        HangManServiceImpl hangManService = new HangManServiceImpl();
//        hangManService.demanderJouer();
    }
}
