package dh.meli.qabugs.service;

import dh.meli.qabugs.model.TestCase;
import org.aspectj.weaver.ast.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ITestCaseService {
    // crie um novo cado de teste

    TestCase createNewTestCase(TestCase testeCase);

    // retorne todos os casos de teste

    List<TestCase> getAllTestCases();

    // retornar um caso de teste por id

    TestCase getTestCaseById(Long id);

    // atualizar um caso de teste por id

    TestCase updateTestCase(Long id, TestCase testCase);

    // atualização parcial de um test case

    TestCase partialTestCaseUpdate(Long id, Map<String, ?> testCaseChanges);

    // excluir um caso de teste por id

    void deleteTestCase(Long id);

    // encontre todos os casos de teste que foram atualizados após uma determinada data (método customizado)

    List<TestCase> findAllTestCasesByDate(Date date);
}

























