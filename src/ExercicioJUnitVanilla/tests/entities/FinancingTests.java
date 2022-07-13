package ExercicioJUnitVanilla.tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ExercicioJUnitVanilla.entities.Financing;
import ExercicioJUnitVanilla.tests.factory.FinancingFactory;

public class FinancingTests {

	@Test
	public void constructorShouldCreateObjectWhenDataIsValid () {
		
		Financing financing = FinancingFactory.createFinancing();
		Assertions.assertEquals(financing.getClass(), new Financing().getClass());
	}
	
	@Test
	public void constructorShouldThrowExceptionWhenDataInvalid() {
		
		double income = 2000.00;
		int months = 20;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			FinancingFactory.createFinancing(income, months);
		});
	}
	
	@Test
	public void setTotalAmountShouldChangeDataWhenItIsValid() {
		
		double expectedValue = 50000.00;
		
		Financing financing = FinancingFactory.createFinancing();
		financing.setTotalAmount(expectedValue);
		
		Assertions.assertEquals(expectedValue, financing.getTotalAmount());
	}
	
	@Test
	public void setTotalAmountShouldThrowExceptionWhenDataInvalid() {
		
		double expectedValue = 101000.00;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = FinancingFactory.createFinancing();
			financing.setTotalAmount(expectedValue);
		});
	}
	
	@Test
	public void setIncomeShouldChangeDataWhenItIsValid() {
		
		double expectedValue = 2500.00;
		
		Financing financing = FinancingFactory.createFinancing();
		financing.setIncome(expectedValue);
		
		Assertions.assertEquals(expectedValue, financing.getIncome());
	}
	
	@Test
	public void setIncomeShouldThrowExceptionWhenDataInvalid() {
		
		double expectedValue = 1500.00;
		Financing financing = FinancingFactory.createFinancing();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			financing.setIncome(expectedValue);
		});
	}
	
	@Test
	public void setMonthsShouldChangeDataWhenItIsValid() {
		
		int expectedValue = 100;
		
		Financing financing = FinancingFactory.createFinancing();
		financing.setMonths(expectedValue);
		
		Assertions.assertEquals(expectedValue, financing.getMonths());
	}
	
	@Test
	public void setMonthsShouldThrowExceptionWhenDataInvalid() {
		
		int expectedValue = 20;
		Financing financing = FinancingFactory.createFinancing();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			financing.setMonths(expectedValue);
		});
	}
	
	@Test
	public void entryShouldCalculateInputValue() {
		
		double expectedValue = 20000.0;
		
		Financing financing = FinancingFactory.createFinancing();
		
		Assertions.assertTrue(expectedValue == financing.entry());
	}
	
	@Test
	public void quotaShouldCalculateInputValue() {
		
		double expectedValue = 1000.00;
		
		Financing financing = FinancingFactory.createFinancing();
		
		Assertions.assertTrue(expectedValue == financing.quota());
	}
}