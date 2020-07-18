package kz.cf.spring5.lesson7;


import kz.cf.spring5.lesson7.country.CountryClient;
import kz.cf.spring5.lesson7.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner lookup(CountryClient quoteClient) {
        return args -> {
            String country = "Spain";

            if (args.length > 0) {
                country = args[0];
            }
            GetCountryResponse response = quoteClient.getCountry(country);
            System.err.println(response.getCountry().getCurrency());
            System.err.println(response.getCountry().getLang());
        };
    }
}
