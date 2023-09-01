package com.project_demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info=@Info(
				contact=@Contact(
						name="Tour Planner",
						email="vivinsr16@gmail.com",
						url="https://hehe-url.com"
				),
				description="This is open API documentation of Tour Planner",
				title="Tour Planner",
				version="1.0",
				license=@License(
						name="MIT",
						url="https://hehe-url.com"
				),
				termsOfService="Terms of Service"
		),
		servers=@Server(
				description="DEV ENV",
				url="http://localhost:8181"
		)
)

public class OpenApiConfig {

}
