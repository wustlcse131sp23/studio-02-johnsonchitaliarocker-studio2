package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("How much money are you starting with? ");
	int start = in.nextInt();
	System.out.println("What is the probablility that you win? ");
	double probability = in.nextDouble();
	System.out.println("What is your win limit? ");
	int winLimit = in.nextInt();
	System.out.println("How many days do you want to play? ");
	double totalDays = in.nextInt();
	int currentAmount;
	double Losses = 0;
	for (int today = 1; today <= totalDays; today++) {
	currentAmount = start;	
	int count = 0;
	while(true) { 
		double random = Math.random();
		if (random < probability / 100.0) {
			currentAmount++;
		}
		else {
			currentAmount--;
		}
		count++;
		if (currentAmount >= winLimit) {
			System.out.println("Simulation " + today + ": " + count + " WIN");
			break;
		}
		if (currentAmount == 0) {
			System.out.println("Simulation " + today + ": " + count + " LOSE");
			Losses++;
			break;
		}
		
	}
	}
	double expectedRuin;
	double a = (1 - probability) / (probability);
	 if (probability == 5) {
		 expectedRuin = 1 - start / winLimit;
	 }
	 else {
		expectedRuin = (((Math.pow(a, start)) - Math.pow(a, winLimit)) / (1.0 - Math.pow(a, winLimit)));
	 }
	System.out.println("Losses: " + Losses + " Simulations: " + totalDays);
	System.out.print("Ruin Rate from Simulation: " + Losses / totalDays + " Simulations: " + totalDays + "\t");
	System.out.print("Expected Ruin Rate: " + expectedRuin );
	}

}
