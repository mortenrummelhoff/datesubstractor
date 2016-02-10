package dk.mhr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.net.URI;

/**
 * Created by Morten on 05-12-2015.
 *
 * Main Application
 */
@SpringBootApplication
public class ApplicationMain {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public ApplicationMain() {
        logger.debug("Starting DateSubstractor");
    }

    @PostConstruct
    private void initialize() throws Exception {
        if(Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI("http://localhost:8080"));
        }
        else {
            System.out.print("Please start a browser and enter {HOST}//:8080/");
        }
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
