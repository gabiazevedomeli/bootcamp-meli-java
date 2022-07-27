package dh.meli.spring_elastic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Getter @Setter
@Document(indexName = "meli_doc")
public class Article {

    @Id
    private int id;

    @Field(name = "title", type = FieldType.Text)
    private String title;

    // anotação para definir que a lista de autores será persistida junto com o artigo, aninhado
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authors;
}
