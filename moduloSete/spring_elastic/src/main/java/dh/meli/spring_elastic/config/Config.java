package dh.meli.spring_elastic.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

// anotação para marcar que esta classe é de configuração
@Configuration
@EnableElasticsearchRepositories(basePackages = "dh.meli.spring_elastic.repository")
@ComponentScan(basePackages = "dh.meli.spring_elastic")
public class Config {

    @Bean
    public RestHighLevelClient cliente() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
            .connectedTo("localhost:9200")
            //.withBasicAuth("elastic", "algumasenha")
            .withConnectTimeout(10000)
            .withSocketTimeout(10000)
            .build();
        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(cliente());
    }
}
