package ExercicioJUnitVanilla;

public class Problematica {
}
/*
 * Um financiamento possui três dados:
	- totalAmount: valor total de dinheiro financiado
	- income: renda mensal do cliente que está financiando
	- months: número de meses do financiamento

* E dois métodos:
	- entry: Entrada do financiamento, igual a 20% do valor total
	- quota: Prestação mensal do financiamento (sem juros)

* REGRA: O valor da prestação não pode ser maior que metade da renda mensal do cliente. A seguir alguns exemplos de financiamentos:
	- EXEMPLO 1: {totalAmount: 100000, income: 2000, months: 20}
 		- Este exemplo é INVÁLIDO porque com esses dados a entrada seria 20000 e a prestação seria 4000. Porém a prestação não pode passar de 1000, que é a metade da renda do cliente
 
 	- EXEMPLO 2: {totalAmount: 100000, income: 2000, months: 80}
 		- Este exemplo é VÁLIDO porque a entrada seria 20000 e a prestação seria 1000. Neste caso, a prestação é menor ou igual a metade da renda do cliente, satisfazendo a regra.
 
 * TESTES:
	- Deve ser implementado os seguintes testes para validar esta classe (total = 10 testes)
	
	- CONSTRUTOR:
		- Deve criar o objeto com os dados corretos quando os dados forem válidos
		- Deve lançar a exceção IllegalArgumentException quando os dados não forem válidos
	
	- setTotalAmount:
		- Deve atualizar o valor quando os dados forem válidos
		- Deve lançar a exceção IllegalArgumentException quando os dados não forem válidos
	
	- setIncome:
		- Deve atualizar o valor quando os dados forem válidos
		- Deve lançar a exceção IllegalArgumentException quando os dados não forem válidos
	
	- setMonths:
		- Deve atualizar o valor quando os dados forem válidos
		- Deve lançar a exceção IllegalArgumentException quando os dados não forem válidos

	- entry:
		- Deve calcular corretamente o valor da entrada
		
	- quota:
		- Deve calcular corretamente o valor da prestação

*/