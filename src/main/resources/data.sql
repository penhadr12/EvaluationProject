--CADASTRO DE EMPLOYEE
insert into employee (id, name, email, department, salary, birthDate) values (1, 'Monteiro Lobato', 'monteiro.lobato@evaluate.com', 'Arquitetura - JR', 16000.0, '1980-01-25');
insert into employee (id, name, email, department, salary, birthDate) values (2, 'Jose de Alencar', 'jose.alencar@evaluate.com', 'Arquitetura - SR', 18000.0, '1981-02-25');
insert into employee (id, name, email, department, salary, birthDate) values (3, 'Cecilia Meireles', 'cecilia.meireles@evaluate.com', 'Dev. Front End', 14000.0, '1982-03-24');
insert into employee (id, name, email, department, salary, birthDate) values (4, 'Carlos Drummond de Andrade', 'carlos.drummond.andrade@evaluate.com', 'Dev. Back End', 16000.0, '1983-04-25');
insert into employee (id, name, email, department, salary, birthDate) values (5, 'Machado de Assis', 'machado.assis@evaluate.com', 'Dev. Back End', 14000.0, '1984-05-17');
insert into employee (id, name, email, department, salary, birthDate) values (6, 'Clarice Lispector', 'clarice.lispector@evaluate.com', 'UX Design', 12500.0, '1985-06-25');
insert into employee (id, name, email, department, salary, birthDate) values (7, 'Eva Furnari', 'eva.furnari@evaluate.com', 'UX Design', 16000.0, '1986-07-19');
insert into employee (id, name, email, department, salary, birthDate) values (8, 'Veronica Stigger', 'veronica.stigger@evaluate.com', 'Arquitetura - JR', 16000.0, '1987-08-30');
insert into employee (id, name, email, department, salary, birthDate) values (9, 'Mario Quintana', 'mario.quintana@evaluate.com', 'Dev. Back End', 15000.0, '1988-09-20');
insert into employee (id, name, email, department, salary, birthDate) values (10, 'Guimaraes Rosa', 'guimaraes.rosa@evaluate.com', 'Dev. Back End', 9000.0, '1989-10-10');

-- CADASTRO DE USUARIO
insert into Usuario (id, nome, login, senha, ativo) values (1, 'William Penha de Oliveira', 'wpenhaol', '$2a$10$DZdrxhWKE3Um9RY2tzHwOeEdG.A4wrLpVDIesfFq0hSadXrmuyNam', true);
insert into Usuario (id, nome, login, senha, ativo) values (2, 'Sandro Santana Silva ', 'ssantanasi', '$2a$10$DZdrxhWKE3Um9RY2tzHwOeEdG.A4wrLpVDIesfFq0hSadXrmuyNam', true);
-- CADASTRO DE GRUPO
insert into GRUPO (id, nome, descricao) values (1, 'RECURSOS HUMANOS - RH', 'Grupo de recursos humanos');
insert into GRUPO (id, nome, descricao) values (2, 'OPERACOES - OPS', 'Grupo de operacoes');
-- CADASTRO DE PERMISSAO
insert into PERMISSAO (id, nome) values (1, 'ADMIN');
insert into PERMISSAO (id, nome) values (2, 'USER');
-- CADASTRO DE VINCULO USUARIOS E GRUPO
insert into USUARIO_GRUPOS (usuarios_id, grupos_id) values (1, 1);
insert into USUARIO_GRUPOS (usuarios_id, grupos_id) values (2, 2);
-- CADASTRO DE VINCULO GRUPO E PERMISSOES
insert into GRUPO_PERMISSOES (grupos_id, permissoes_id) values (1, 1);
insert into GRUPO_PERMISSOES (grupos_id, permissoes_id) values (1, 2);
insert into GRUPO_PERMISSOES (grupos_id, permissoes_id) values (2, 2);