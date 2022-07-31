package dh.meli.qabugs.service;

import dh.meli.qabugs.exceptions.TestCaseBadRequestException;
import dh.meli.qabugs.exceptions.TestCaseNotFoundException;
import dh.meli.qabugs.model.TestCase;
import dh.meli.qabugs.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TestCaseService implements ITestCaseService {

    @Autowired
    private TestCaseRepository testcaseRepo;

    @Override
    public TestCase createNewTestCase(TestCase testCase) {
        if (testCase.getId_case() != null) {
            throw new TestCaseBadRequestException("Test Case cannot have an id to be inserted on DB");
        }
        return testcaseRepo.save(testCase);
    }

    @Override
    public List<TestCase> getAllTestCases() {
        return testcaseRepo.findAllTestCases();
    }

    @Override
    public TestCase getTestCaseById(Long id) {
        return testcaseRepo.findById(id).orElseThrow(() -> new TestCaseNotFoundException("TestCase ID: " + id + " not found"));
    }

    @Override
    public TestCase updateTestCase(Long id, TestCase testCase) {
        getTestCaseById(id);
        return testcaseRepo.save(testCase);
    }

    @Override
    public TestCase partialTestCaseUpdate(Long id, Map<String, ?> testCaseChanges) {
        TestCase testCaseFound = getTestCaseById(id);
        testCaseChanges.forEach((key, value) -> {
            switch (key) {
                case "description": testCaseFound.setDescription((String) value); break;
                case "tested": testCaseFound.setTested((Boolean) value); break;
                case "passed": testCaseFound.setPassed((Boolean) value); break;
                case "number_of_tries": testCaseFound.setNumber_of_tries((Integer) value); break;
                case "last_update": testCaseFound.setLast_update((Date) value); break;
            }
        });
        return testcaseRepo.save(testCaseFound);
    }

    @Override
    public void deleteTestCase(Long id) {
        getTestCaseById(id);
        testcaseRepo.deleteById(id);
    }

    @Override
    public List<TestCase> findAllTestCasesByDate(Date date) {
        return testcaseRepo.findTestCaseByDate(date);
    }
}
