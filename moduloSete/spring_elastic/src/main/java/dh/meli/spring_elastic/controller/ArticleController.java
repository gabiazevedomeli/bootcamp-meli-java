package dh.meli.spring_elastic.controller;

import dh.meli.spring_elastic.model.Article;
import dh.meli.spring_elastic.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<Article> saveArticle(@RequestBody Article article) {
        return ResponseEntity.ok(articleService.save(article));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> findArticleById(@PathVariable int id) {
        return ResponseEntity.ok(articleService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Article>> findArticleById() {
        return ResponseEntity.ok(articleService.findAllArticles());
    }

    @PutMapping
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        return ResponseEntity.ok(articleService.updateArticle(article));
    }

    @GetMapping("/title/{title}")
    public Page<Article> getPageByTitle(@PathVariable String title, Pageable page) {
        return articleService.getPageByTitle(title, page);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        return ResponseEntity.ok(articleService.deleteArticleById(id));
    }
}
