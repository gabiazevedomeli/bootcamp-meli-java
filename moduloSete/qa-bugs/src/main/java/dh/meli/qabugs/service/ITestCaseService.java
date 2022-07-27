package dh.meli.qabugs.service;

import dh.meli.qabugs.model.TestCase;

import java.util.List;

public interface ITestCaseService {
    // crie um novo cado de teste

    TestCase createNewTestCase(TestCase testeCase);

    // retorne todos os casos de teste

    List<TestCase> getAllTestCases();

    // retornar um caso de teste por id

    TestCase getTestCaseById(Long id);

    // atualizar um caso de teste por id

    TestCase updateTestCase(Long id);

    // excluir um caso de teste por id

    void deleteTestCase(Long id);

    // encontre todos os casos de teste que foram atualizados após uma determinada data (método customizado)
}

























