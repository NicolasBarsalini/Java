package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of Tax Payers: ");
		int n = sc.nextInt();
		
		for(int i=0; i<n ; i++) {
			System.out.println("Tax payer #" + (i+1) + " Data:");
			System.out.print("Individual or Company? (i/c): ");
			char ic = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			double anualIncome = sc.nextDouble();
			if(ic == 'i') {
				System.out.print("Health Expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else {
				System.out.print("Number of Employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		
		System.out.println("Taxes Paid: ");
		double taxes = 0;
		for(TaxPayer i : list) {
			taxes += i.tax();
			System.out.println(i.getName() + " : $ " + String.format("%.2f", i.tax()));
		}
		System.out.println("Total taxes: $" + String.format("%.2f", taxes));
		sc.close();
	}

}
