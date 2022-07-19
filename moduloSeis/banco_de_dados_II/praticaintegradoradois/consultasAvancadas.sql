-- Prática Integradora Dois - Consultas Avançadas

USE company;

-- 1. Selecione o nome, cargo e localização dos departamentos onde os vendedores trabalham.

SELECT func.nome, func.cargo, dep.localizacao
FROM funcionario AS func
         INNER JOIN departamento AS dep
                    ON func.depto_nro = dep.depto_nro;

-- 2. Visualize departamentos com mais de dois funcionários.

SELECT dep.nome_depto, COUNT(func.cod_func) AS dep_mais_cinco_func
FROM departamento AS dep
         INNER JOIN funcionario AS func
                    ON func.depto_nro = dep.depto_nro
GROUP BY dep.depto_nro
HAVING dep_mais_cinco_func > 2;

-- 3. Exiba o nome, salário e nome do departamento dos funcionários que têm o mesmo cargo que 'Jonathan Aguilera'.

SELECT func.nome, func.cargo, func.salario, dep.nome_depto
FROM funcionario AS func
         INNER JOIN departamento AS dep
                    ON func.depto_nro = dep.depto_nro
WHERE func.cargo = (SELECT cargo FROM funcionario WHERE nome = 'Jonathan' AND sobrenome = 'Aguilera');

-- 4. Mostre os dados dos funcionários que trabalham no departamento de contabilidade, ordenados por nome.

SELECT func.nome, func.sobrenome, func.cargo, func.data_alta, func.salario, func.comissao
FROM funcionario AS func
         INNER JOIN departamento AS dep
                    ON func.depto_nro = dep.depto_nro
WHERE dep.nome_depto = 'Contabilidade'
ORDER BY func.nome;

-- 5. Mostre o nome do funcionário que tem o menor salário.

SELECT nome, MIN(salario) AS func_min_salario
FROM funcionario
GROUP BY nome
LIMIT 1;

-- 6. Mostre os dados do funcionário que tem o maior salário do departamento 'Vendas'.

SELECT MAX(func.salario) AS func_max_salario, func.nome, func.sobrenome, func.cargo, func.data_alta, func.comissao, dep.nome_depto
FROM funcionario AS func
         INNER JOIN departamento as dep
                    ON func.depto_nro = dep.depto_nro
GROUP BY cod_func
HAVING nome_depto = 'Vendas';
