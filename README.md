# proposta-de-credito
# Estrutura da Aplicação
## Backend
    Spring Boot 
    Spring Data
    Java 8
    Maven
    JPA/Hibernate
    H2 Database
    Junit
    Swagger
    Docker

## Frontend
    AngularJS
    Bootstrap
    NodeJS
    Express
    Docker
    JQuery
    JavaScript
    
# Passos para execução
    **PRÉ-REQUISITOS**
    Ter instalado Java versão 8 
    Ter instalado Docker 18.09.6 
    Ter instalado Maven
    Ter instalado Node

## Executar backend

1.Clone o repositório em uma pasta de sua preferencia, no seu computador:
	*`git clone https://github.com/MatheusTabares/proposta-de-credito.git`

2.Navegue até a pasta raiz da aplicação backend:
	*`cd api/`

3.Construa a aplicação e execute os testes com o comando:
	*`mvn clean install`

4.Construa a imagem docker com o comando:
	*`docker build -t api .`

5.Confira a imagem criada no registro local docker com o comando:
	*`docker images`

4.Execute a aplicação no container docker com o comando:
	*`docker run -p 8080:8080 api`

5.Para enviar a proposta de crédito para a análise utilize a URL e o formato JSON a seguir:
	`POST http://localhost:8080/propostas`
	
	Corpo da requisição:
	{
		"nome": "Ariel",
		"idade": 33,
		"cpf": "50768903033",
		"sexo": "F",
		"estadoCivil": "VIUVO",
		"estado": "SP",
		"dependentes": 0,
		"renda": 10000.00
	 }
    

	**Documentação das rotas você encontra aqui**
	http://localhost:8080/swagger-ui.html


## Executar frontend

1.Navegue até a pasta /frontend no repositório clonado em sua máquina:
	*`cd frontend/`

3.Construa a aplicação e execute os testes com o comando:
	*`npm install`

4.Construa a imagem docker com o comando:
	*`docker build -t frontend .`

5.Confira a imagem criada no registro local docker com o comando:
	*`docker images`

4.Execute a aplicação no container docker com o comando:
	*`docker run -p 5000:5000 frontend`
	
5.Acesse a aplaicação pelo browser de sua preferência com a seguinte URL:
	*`http://localhost:5000`

	
## Observações
Para realizar a análise do crédito foi implementado um algoritmo baseado em pontuação, no qual a pontuação mínima para o crédito ser aprovado é `70 pontos`.
	*Exemplo:
	Uma pessoa casada ou solteira obtem 60 pontos, caso a renda informada dividida pelo número de dependentes mais o cliente, seja igual ou maior que o valor mínimo estabelecido de R$800, a mesma terá sua proposta aprovada. O limite de crédito para esta pessoa dependerá do valor da renda percapita, salvo se ela não seja uma pessoa de risco crítico. 

	Pessoa de risco crítico:
	Com idade menor que 30 anos, solteiro, sexo masculino, sem dependentes.




-
**Me encontro a disposição:**
tabares.lopes@gmail.com
(48)99836-2417
    

    
