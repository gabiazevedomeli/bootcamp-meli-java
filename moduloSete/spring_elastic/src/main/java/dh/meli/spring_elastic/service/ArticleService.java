package dh.meli.spring_elastic.service;

import dh.meli.spring_elastic.model.Article;
import dh.meli.spring_elastic.repository.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IArticleService {

    // injeção de dependência por construtor
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article findById(int id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public List<Article> findAllArticles() {
//        List<Article> list = new ArrayList<>();
//        Iterable<Article> listArticle = articleRepository.findAll();
//
//        listArticle.forEach(list::add);
//
//        return list;
        return articleRepository.findAllArticles();
    }

    @Override
    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Page<Article> getPageByTitle(String title, Pageable page) {
        return articleRepository.findByTitle(title, page);
    }

    @Override
    public String deleteArticleById(int id) {
        articleRepository.deleteById(id);
        return "Article deleted successfully!!!";
    }

}
