package dh.meli.qabugs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter @Setter
@Entity
@Table(name = "test_cases")
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_case;

    @Column(length = 200, nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean tested;

    @Column(nullable = false)
    private Boolean passed;

    @Column(nullable = false)
    private Integer number_of_tries;

    @Column(nullable = false)
    private Date last_update;
}






















