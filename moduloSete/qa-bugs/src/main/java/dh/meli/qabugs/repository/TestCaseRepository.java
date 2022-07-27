package dh.meli.qabugs.repository;

import dh.meli.qabugs.model.TestCase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepository extends CrudRepository<TestCase, Long> {

}
