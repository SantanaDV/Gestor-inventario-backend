package com.inventario.gestor_inventario;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class GestorInventarioApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
				.directory("src/main/resources")
				.filename("variables.env")
				.load();

		String urlServer = dotenv.get("URL_SERVER");
		String bdPort = dotenv.get("BD_PORT");
		String bdName = dotenv.get("BD_NAME");
		String username = dotenv.get("BD_USERNAME");
		String password = dotenv.get("BD_PASSWORD");
		String portServer = dotenv.get("PORT_SERVER");
		String protocol = dotenv.get("SERVER_PROTOCOL");
		String databaseUrl = "jdbc:mysql://" + urlServer + ":" + bdPort + "/" + bdName;

		StandardEnvironment environment = new StandardEnvironment();
		MutablePropertySources propertySources = environment.getPropertySources();
		Map<String, Object> dotenvMap = new HashMap<>();
		dotenvMap.put("PORT_SERVER", portServer);
		dotenvMap.put("SPRING_DATASOURCE_URL", databaseUrl);
		dotenvMap.put("SPRING_DATASOURCE_USERNAME", username);
		dotenvMap.put("SPRING_DATASOURCE_PASSWORD", password);

		SpringApplication app = new SpringApplication(GestorInventarioApplication.class);
		app.addInitializers(applicationContext -> {
			StandardEnvironment env = (StandardEnvironment) applicationContext.getEnvironment();
			env.getPropertySources().addFirst(new MapPropertySource("dotenv", dotenvMap));
		});
		app.run(args);
	}
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new
				InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

}