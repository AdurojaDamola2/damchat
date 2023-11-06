package damo.com.damchat;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class DamchatApplication {
	static Logger logger = LoggerFactory.getLogger(DamchatApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DamchatApplication.class, args);
		logger.info("Finish running application");
	}

}
