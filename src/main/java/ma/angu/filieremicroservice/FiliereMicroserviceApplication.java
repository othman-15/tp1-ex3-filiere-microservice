package ma.angu.filieremicroservice;

import ma.angu.filieremicroservice.configuration.RsaKeys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeys.class)
public class FiliereMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiliereMicroserviceApplication.class, args);
    }

}
