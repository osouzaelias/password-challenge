## Desafio

Construir uma aplicação que exponha uma api web que valide se uma senha é válida.

Input: Uma senha (string).<br>
Output: Um boolean indicando se a senha é válida.

**Regras**
Considere uma senha sendo válida quando a mesma possuir as seguintes definições:

1. Nove ou mais caracteres
2. Ao menos 1 dígito
3. Ao menos 1 letra minúscula
4. Ao menos 1 letra maiúscula
5. Ao menos 1 caractere especial
   - Considere como especial os seguintes caracteres: !@#$%^&*()-+
7. Não possuir caracteres repetidos dentro do conjunto


## Solução

A ideia foi separar o projeto em 3 camadas, seguindo a seguinte estrutura: 

+ Application
  + Controller
+ Domain
  + Entity
  + Factory
  + Specification
+ Infrastructure
  + Config
+ Test
  + Application
  + Domain
  
<p align="justify">
  Começando pela camada de domínio, temos todas as especificações de senha, tais como
  caractere repetido, letra maiuscula e etc. Temos a entidade <strong><i>Password</i></strong> 
  que representa um tipo genérico de senha, já a <i><strong>ChallengePasswordFactory</strong></i>
  irá criar uma entidade senha com as especificações do desafio. Se no sistema houver 
  um novo tipo de senha, basta criar outra fábrica.
</p>


<p align="justify">
  Quanto as demais camadas, na aplicação temos o controlador que expões a versão 1 da api,
  faz a validação da senha e trata a exceção de acordo com seus respectivos status http.
  E na camada de infra estrutura, temos configurações do swagger para documentar a api.
</p>

## Tecnologias utilizadas

- [Java SE Development Kit 11.0.9](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [IntelliJ IDEA 2020.3](https://www.jetbrains.com/pt-br/idea/)
- [Spring Framework 5](https://spring.io/)
- [Apache Maven 3.6.3](https://maven.apache.org/download.cgi)
- [Tomcat 9](https://tomcat.apache.org/download-90.cgi)
- [Swagger](https://swagger.io/)
- [JUnit 5](https://junit.org/junit5/)

## Executando o projeto

<p align="justify">
Espero que você tenha instalado tecnologias citadas acima, caso contrátrio, será necessário a instalação para o 
perfeito funcionamento do projeto.
</p>

<p align="justify">
<strong>1º Passo:</strong> Crie um diretório na sua máquina e clone o projeto do Github com o seguinte comando:

```shell
git clone https://github.com/osouzaelias/password-challenge.git
```
</p>

> **Observação:** Se preferir usar uma IDE basta importar o projeto.

<p align="justify">
<strong>2º Passo:</strong> Acesse o diretório em que você clonou o repositório e execute o projeto com o 
seguinte comando:

```shell
mvn spring-boot:run
```
</p>

<p align="justify">
<strong>3º Passo:</strong> Depois que o projeto executar, acesse o endereço abaixo no seu navegador e 
execute os testes:

```shell
http://localhost:8080/swagger-ui/
```
</p>

Até mais. :vulcan_salute: