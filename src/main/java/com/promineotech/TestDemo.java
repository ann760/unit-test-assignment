package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return (a + b);
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!"); 
		}	
	}
	
	public double calIncome(double hours, double payRate) {
		if (hours > 0 && payRate > 0) {
			if (hours > 40) {
				double overT = (hours - 40);
				double overP = (payRate * 1.5);
				double overPay = (overT * overP);
				double regPay = (40 * payRate);
				return (overPay + regPay);
			}
			  else {
//				  System.out.println("reg");
				  return (hours * payRate);
			  }
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!"); 
		}
	}
	
	public int randomNumberSquared() {
		int randNum = getRandomInt();
		return randNum *= randNum;
	}
	
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
			
}
