package net.geozen.cloud.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

import de.codecentric.boot.admin.config.EnableAdminServer;


@SpringBootApplication
//@EnableHystrixDashboard
@EnableTurbine
@EnableAdminServer
public class Application {

    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }

}