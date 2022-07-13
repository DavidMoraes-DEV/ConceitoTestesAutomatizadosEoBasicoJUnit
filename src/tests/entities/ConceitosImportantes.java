package tests.entities;

public class ConceitosImportantes {
}
/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
PARTE 1 - CRIA��O DE UM CRUD 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* DTO = Objetos Auxiliares para trafegar os dados

* spring-boot-starter-data-jpa (No arquivo POM.XML)
	- Vem implementado pronto para uso no SubProjeto Spring Data JPA que � definido como depend�ncia no Arquivo POM.XML para ser importado
	- Traz uma implementa��o do acesso a dados b�sico 

* Na INTERFACE CategoryRepositery:
	- JpaRepository<T, ID>: � um tipo gen�rico, esperando 2 par�metros <T(Tipo da Entidade), ID(Tipo do Id)
		- Nesse caso o tipo da entidade � Category e o tipo do ID � long conforme definido na entidade Category
		- Apenas com essa defini��o de INTERFACE herdando/extendendo de JpaRepository ja obtemos muitas opera��es prontas para acessar o banco de dados
		- Funciona para qualquer banco de dados relacional que tenha implementa��o da JPA no Spring
			- ou seja, tudo que for programado aqui pelo banco de dados de teste H2 funcionar� para outros bancos de dados como o MySQL, POSTMAN, ORAGLE e etc

* Para mais informa��es de PADR�O CAMADAS assistir o v�deo do prof N�lio: back end, front end, padr�o camadas, MVC, REST no Youtube

* CAMADA DE SERVI�O
	- � a camada que vai chamar alguma funcionalidade da CAMADA DE ACESSO A DADOS

* Annotation @Service:
	- ir� registrar essa classe como um componente que ir� participar do sistema de inje��o de dependencia automatizada do Spring
	- Ou seja: Quem vai gerenciar as inst�ncias das dependencias da classe Category vai ser o Spring(Todo frameWork moderno tem isso, algum mecanismo de inje��o de dependencia automatizada)

* Annotation @Component:
	- Registra um componente gen�rico que n�o tenha algum significado espec�fico
	- Tamb�m � um mecanismo de Inje��o de dependencia Automatizada

* Annotation @Repository
 	- Registra um reposit�rio tamb�m para o mecanismo de Inje��o de dependencia Automatizada	
	
* O arquivo application.properties da pasta src/main/resources
 	- � o arquivo que tem as configura��es do projeto que v�o funcionar para todos os PERFIS
 
 	* O que � um PERFIL?
 		- Quando se desenvolve uma aplica��o utiliza-se V�RIOS PERFIS (Pelo menos 3 perfil diferente):
 			- Perfil de TEST
 				- Esse perfil serve para rodar um banco de dados PROVIS�RIO
 				- Toda vez que rodar a aplica��o o banco de dados ser� REINICIADO, ZERADO e colocado no mesmo ESTADO INICIAL
 				- Isso � muito importante para teste com um banco de dados bem controlado
 				- Nesse estamos utilizando o banco de dados H2 podendo definir uma INSTANCIA INICIAL do banco (seeding) semear o dados do banco com dados iniciais
 				
 			- Perfil de desenvolvimento para TEST antes da PRODU��O (PERFIL DE DEV)
 				- � um perfil que SER� CONECTADO igual ao banco de dados de PRODU��O banco que rodar� na NUVEM
 				- Por exemplo se o banco de PRODU��O for o POSTGREES o perfil de DEV tamb�m ser� configurado para o postgrees na mesma vers�o
 				- Para testar o banco localmente e se der tudo certo viramos a chave para o de produ��o
 				
 			- Perfil de PRODU��O
 				- Banco que roda na NUVEM

	- spring.profiles.active=test -> no Arquivo application.properties: Indica que o banco atualmente � do perfil do tipo TEST

* A DIFEREN�A entre o .findById() e o .getOne() �:
	- O .findById() efetiva o acesso ao banco de dados indo no banco e traz o objeto do id informado
	- O .getOne() n�o toca no banco de dados, ele instancia um objeto provis�rio com os dados e apenas quando mandar SALVAR a� sim ele vai no banco e atualiza os dados:
	- O .getOne() ent�o evita o acesso desnecess�riode de ir no banco duas vezes com o findById() para buscar o Id e depois atualizar os dados.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
PARTE 2 - TESTES AUTOMATIZADOS
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* RESUMO:
		
* Fundamentos de testes automatizados:
	- Tipos de testes
	- Benef�cios
	- TDD - Test Driven Development
	- Boas pr�ticas e padr�es

* JUnit
	- Principal BIBLIOTECA para testes automatizados no JAVA
	- B�sico (Vanilla: Sem utilizar Framework)
	- Spring Boot (Utilizando framework)
		- Repositories
		- Services
		- Resources (web)
		- Integra��o

* Mockito & MockBean
	- Faz objetos simulados para teste de unidade que n�o pode instanciar um outro componente que � dependencia. Ent�o devemos simular o comportamento da dependencia, fazendo isso mockando os objetos
	- @Mock
	- @InjectMocks
	- Mockito.when / thenReturn / doNothing / doThrow
	- ArgumentMatches
	- Mockito.verify
	- @MockBean
	- @MockMvc	

* Tipos de testes:
	- UNIT�RIO:
		- Teste feito pelo desenvolvedor, respons�vel por validar o comportamento de unidades funcionais de c�digo.
		- Nesse contexto, entende-se como unidade funcional qualquer por��o de c�digo que  atrav�s de algum est�mulo seja capaz de gerar um comportamento esperado (na pr�tica: m�todos de uma classe).
		- Um teste unit�rio n�o pode acessar outros componetes ou recursos externos (arquivos, bd, rede, web services, etc).
	
	- INTEGRA��O:
		- Teste focado em verificar se a comunica��o entre componeentes / m�dulos da aplica��o, e tamb�m recursos externos, est�o interagindo entre si corretamente.
	
	- FUNCIONAL:
		- � um teste do ponto de vista do usu�rio (caso de uso), se uma determinada funcionalidade est� executando corretamente, produzindo resultado ou comportamento desejado pelo usu�rio.

* BENEF�CIOS DOS TESTES:
	- Detectar facilmente se mudan�as violaram as regras.
	- � uma forma de documenta��o (comportamento e entradas/sa�das esperadas)
	- Redu��o de custos em manuten��es, especialmente em fases avan�adas
	- Melhora design da solu��o, pois aplica��o test�vel precisa ser bem delineada

* TDD - Test Driven Development
	- � um M�TODO DE DESENVOLVER SOFTWARE. Consiste em um desenvolvimento guiado pelos testes.
		- IMPORTANTE ENTENDER:
			- N�o � pelo fato de que o software possui testes automatizados que necessariamente ele foi desenvolvido usando o TDD como m�todo de trabalho.
			- TDD ent�o diz respeito a forma como a equipe vai trabalhar, e n�o se o projeto tem ou n�o testes automatizados e se bons ou n�o
			- TDD � um procedimento
	- Princ�pios / vantagens:
		- Foco nos requisitos
			- Por que o TDD faz com que na hora de desenvolver um projeto que tem testes, PRIMEIRO se escreve os TESTE e depois faz os C�DIGOS e a L�GICA que faz aqueles testes funcionarem.
			- Ent�o ao se preocupar em primeiro descrever os testes estamos se preocupando com o que que tem que acontecer e automatizamente � uma forma de escrever os requisitos do sistema.
		
		- Tende a melhorar o design do c�digo, pois o c�digo dever� ser test�vel
			- Quando esta desenvolvendo os testes preocupando que eles tem que existir para depois implementar o c�digo e na hora de implementar a funcionalidade vai ter que ser implementada de uma forma que aquele componente implementado seja test�vel se preocupando com inver��o de controle, inje��o de depend�ncia de forma desacoplada e etc
		
		- Incrementos no projeto t�m menos chance de quebrar a aplica��o
			- Fazendo os testes automatizados quando alterar a aplica��o, vai ter que passar nos testes novamente tamb�m sempre tendo ent�o um c�digo que cumpra aquelas regras e passem nos testes

* PROCESSO B�SICO:
	- 1: Escreva o teste como esperado (naturalmente que ele ainda estar� falhandoo)
		- Exemplo: Tenho uma regra e com ela vai entrar "isso" e vai acontecer "isso" e o resultado esperado vai ser "abcd"
	- 2: Implemente o c�digo necess�rio para que o teste passe
	- 3: Refatore o c�digo conforme necessidade

* BOAS PR�TICAS E PADR�ES:
	- Nomenclatura de um teste:
		- <A��O> should <EFEITO> [when <CEN�RIO>]
		
	- Padr�o AAA:
		- Arrange: instancie os objetos necess�rios
		- Act: Execute as a��es necess�rias
		- Assert: Declare o que deveria acontecer (resultado esperado)
	
	- Princ�pios da invers�o de depend�ncia (SOLID)
		- Se uma classe A depende de uma inst�ncia da classe B, n�o tem como testar a classe A isoladamente. Na verdade nem seria um teste unit�rio.
		- A invers�o de controle ajuda na testabilidade, e garante o isolamento da unidade a ser testada.
		
	- Independ�ncia / isolamento
		- Um teste n�o pode depender de outros testes, nem da ordem de execu��o
		
	- Cen�rio �nico
		- O teste deve ter uma l�gica simples, linear
		- O teste deve testar apenas um cen�rios
		- N�o use condicionais e loops
		
	- Privisibilidade
		- O resultado de um teste deve ser sempre o mesmo para os mesmos dados
		- N�o fa�a o resultado depender de coisas que variam, tais como timestamp atual e valores aleat�rios
		
* JUnit - VIS�O GERAL:

	- Site oficial: junit.org/junit5
	- O primeiro passeo � criar uma classe de testes
	- A classe pode conter um ou mais m�todos com a annotation @Test (� a annotation que identifica que � um teste)
	- Um m�todo @Test DEVE ser VOID
	- O objetivo � que todos m�todos @Test passem sem falhas
	- O que vai definir se um m�todo @Test passa ou n�o s�o as "assertions" deste m�todo
	- Se um ou mais falhas ocorrereem, estas s�o mostradas depois da execu��o do teste
*/
