package io.db.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "io.db.repository.user", mongoTemplateRef = "primaryMongoTemplate")
public class UserConfiguration {
	
	@Primary
	@ConfigurationProperties(prefix = "spring.data.mongodb")
	public @Bean(name = "primary") MongoProperties getPrimary() {
		return new MongoProperties();
	}

	@Primary
	public @Bean(name = "primaryMongoTemplate") MongoTemplate primaryMongoTemplate() throws Exception {
		return new MongoTemplate(primaryFactory(getPrimary()));
	}

	@Primary
	public @Bean MongoDatabaseFactory primaryFactory(final MongoProperties mongo) throws Exception {
		return new SimpleMongoClientDatabaseFactory(MongoClients.create(mongo.getUri()), mongo.getDatabase());
	}
	
}
