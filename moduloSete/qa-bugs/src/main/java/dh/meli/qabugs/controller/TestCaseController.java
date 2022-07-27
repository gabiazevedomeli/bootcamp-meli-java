package dh.meli.qabugs.controller;

import dh.meli.qabugs.model.TestCase;
import dh.meli.qabugs.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @GetMapping
    public ResponseEntity<List<TestCase>> getAllTestCases() {
        return ResponseEntity.ok(testCaseService.getAllTestCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.getTestCaseById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<TestCase> createNewTestCase(@RequestBody TestCase testCase) {
        return new ResponseEntity<>(testCaseService.createNewTestCase(testCase), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCase> updateTestCase(@PathVariable Long id, @RequestBody TestCase testCase) {
        return ResponseEntity.ok(testCaseService.updateTestCase(id, testCase));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TestCase> testCasePartialUpdate(@PathVariable Long id, @RequestBody Map<String, ?> testCaseChanges) {
        return ResponseEntity.ok(testCaseService.partialTestCaseUpdate(id, testCaseChanges));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return ResponseEntity.noContent().build();
    }
}





















