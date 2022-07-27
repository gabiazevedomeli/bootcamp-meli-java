package dh.meli.spring_elastic.repository;

import dh.meli.spring_elastic.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

// não é necessário colocar a anotação @Repository porque no arquivo config eu indiquei o caminho para este arquivo
public interface ArticleRepository extends ElasticsearchRepository <Article, Integer> {
    @Query("{ \"match_all\": {  } }")
    List<Article> findAllArticles();

    @Query("{\"match\": {\"title\": {\"query\": \"?0\"}}}")
    Page<Article> findByTitle(String title, Pageable page);
}
