package ExercicioJUnitVanilla;

public class Problematica {
}
/*
 * Um financiamento possui tr�s dados:
	- totalAmount: valor total de dinheiro financiado
	- income: renda mensal do cliente que est� financiando
	- months: n�mero de meses do financiamento

* E dois m�todos:
	- entry: Entrada do financiamento, igual a 20% do valor total
	- quota: Presta��o mensal do financiamento (sem juros)

* REGRA: O valor da presta��o n�o pode ser maior que metade da renda mensal do cliente. A seguir alguns exemplos de financiamentos:
	- EXEMPLO 1: {totalAmount: 100000, income: 2000, months: 20}
 		- Este exemplo � INV�LIDO porque com esses dados a entrada seria 20000 e a presta��o seria 4000. Por�m a presta��o n�o pode passar de 1000, que � a metade da renda do cliente
 
 	- EXEMPLO 2: {totalAmount: 100000, income: 2000, months: 80}
 		- Este exemplo � V�LIDO porque a entrada seria 20000 e a presta��o seria 1000. Neste caso, a presta��o � menor ou igual a metade da renda do cliente, satisfazendo a regra.
 
 * TESTES:
	- Deve ser implementado os seguintes testes para validar esta classe (total = 10 testes)
	
	- CONSTRUTOR:
		- Deve criar o objeto com os dados corretos quando os dados forem v�lidos
		- Deve lan�ar a exce��o IllegalArgumentException quando os dados n�o forem v�lidos
	
	- setTotalAmount:
		- Deve atualizar o valor quando os dados forem v�lidos
		- Deve lan�ar a exce��o IllegalArgumentException quando os dados n�o forem v�lidos
	
	- setIncome:
		- Deve atualizar o valor quando os dados forem v�lidos
		- Deve lan�ar a exce��o IllegalArgumentException quando os dados n�o forem v�lidos
	
	- setMonths:
		- Deve atualizar o valor quando os dados forem v�lidos
		- Deve lan�ar a exce��o IllegalArgumentException quando os dados n�o forem v�lidos

	- entry:
		- Deve calcular corretamente o valor da entrada
		
	- quota:
		- Deve calcular corretamente o valor da presta��o

*/