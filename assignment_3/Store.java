/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 3
 * Due Date: 02/14/2022
 * Date Submitted: 02/14/2022
 */

package assignment_3;

public class Store {
	// Declares variables
	private float salesbyweek[][];
	private float totalsalesbyweek[];
	private float avgsalesbyweek[];
	private float totalsalesforallweeks;
	private float avgweeklysales;
	private int weekwithhighestsales;
	private int weekwithlowestsales;
	
	// Default Constructor
	Store() {
		salesbyweek = new float[5][7];
		totalsalesbyweek = new float[5];
		avgsalesbyweek = new float[5];
		totalsalesforallweeks = 0;
		avgweeklysales = 0;
	}

	// getter and setters
	// setsaleforweekdayintersection(int week, int day, float sale)
	public void setsaleforweekdayintersection(int week, int day, float sale) {
		salesbyweek[week][day] = sale;
	}
	
	// Method of printing table of sales data
	public void printdata() {
		System.out.printf("%6s%10s%10s%10s%10s%10s%10s%10s\n", "", "Day 1", "Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7");
		for (int i = 0; i < 5; i++)	{
			System.out.printf("Week %d\t", i + 1);
			for (int j = 0; j < 7; j++)	{
				System.out.printf("%10.2f",salesbyweek[i][j]);
			}
			System.out.println("");
		}
	}
	
	// Calculate total sales by week
	public void calctotalsalesbyweek() {
		for (int i = 0; i < 5; i++) {
			totalsalesbyweek[i] = 0;
			for (int j = 0; j < 7; j++) {
				totalsalesbyweek[i] += getsaleforweekdayintersection()[i][j];
			}
		}
	}
	
	// Calculate average sales by week
	public void calcavgsalesbyweek() {
		calctotalsalesbyweek();
		for (int i = 0; i < 5; i++) {
			avgsalesbyweek[i] = gettotalsalesbyweek()[i] / 7;
		}
	}
	
	// Calculate total sales
	public void calctotal() {
		calctotalsalesbyweek();
		for (int i = 0; i < 5; i++) {
			totalsalesforallweeks += gettotalsalesbyweek()[i];
		}
	}
	
	// Calculate average weekly sales
	public void calcavgweeklysales() {
		calcavgsalesbyweek();
		for (int i = 0; i < 5; i++) {
			avgweeklysales += getavgsalesbyweek()[i] / 5;
		}
	}
	
	// Calculate week with highest sales
	public void calcweekwithhighestsales() {
		float max = gettotalsalesbyweek()[0];
		weekwithhighestsales = 1;
		for (int i = 0; i < 5; i++) {
			if (max < gettotalsalesbyweek()[i]) {
				max = gettotalsalesbyweek()[i];
				weekwithhighestsales = i + 1;
			}
		}
	}
	
	// Calculate week with lowest sales
	public void calcweekwithlowestsales() {
		float min = gettotalsalesbyweek()[0];
		weekwithlowestsales = 1;
		for (int i = 0; i < 5; i++) {
			if (min > gettotalsalesbyweek()[i]) {
				min = gettotalsalesbyweek()[i];
				weekwithlowestsales = i + 1;
			}
		}
	}
	
	// Get sale for week day intersection
	public float[][] getsaleforweekdayintersection() {
		return salesbyweek;
	}
	
	// Get total sales by week
	public float[] gettotalsalesbyweek() {
		return totalsalesbyweek;
	}
	
	// Get average sales by week
	public float[] getavgsalesbyweek() {
		return avgsalesbyweek;
	}
	
	// Get total sales
	public float gettotal() {
		return totalsalesforallweeks;
	}
	
	// Get average weekly sales
	public float getavgweeklysales() {
		return avgweeklysales;
	}
	
	// Get week with highest sales
	public int getweekwithhighestsales() {
		return weekwithhighestsales;
	}
	
	// Get week with lowest sales
	public int getweekwithlowestsales() {
		return weekwithlowestsales;
	}
	
	// Do calculation data 
	public void analyzeresult() {
		calctotalsalesbyweek();
		calcavgsalesbyweek();
		calctotal();
		calcavgweeklysales();
		calcweekwithhighestsales();
		calcweekwithlowestsales();
	}
	
	// Print data by options
	public void print(int i) {
		switch (i) {
		case 1:
			for (int k = 0; k < 5; k++) {
				System.out.printf("Total sales for week %d: %.2f\n", k + 1, gettotalsalesbyweek()[k]);
			}
			break;
		case 2:
			for (int k = 0; k < 5; k++) {
				System.out.printf("Average sales for week %d: %.2f\n", k + 1, getavgsalesbyweek()[k]);
			}
			break;
		case 3:
			System.out.printf("Total sales for all weeks: $%.2f\n", gettotal());
			break;
		case 4:
			System.out.printf("Average weekly sales: $%.2f\n", getavgweeklysales());
			break;
		case 5:
			System.out.printf("Week %d has highest amount in sales with $%.2f\n", getweekwithhighestsales(), gettotalsalesbyweek()[getweekwithhighestsales()-1]);
			break;
		case 6:
			System.out.printf("Week %d has lowest amount in sales with $%.2f\n", getweekwithlowestsales(), gettotalsalesbyweek()[getweekwithlowestsales()-1]);
			break;
		case 7:
			System.out.printf("All analytical data\n");
			System.out.printf("%15s%10s%10s%10s%10s%10s\n", "", "Week 1", "Week 2", "Week 3", "Week 4", "Week 5");
			System.out.printf("%-15s","Total Sales");
			for (int k = 0; k < 5; k++) {
				System.out.printf("%10.2f", gettotalsalesbyweek()[k]);
			}
			System.out.printf("\n%-15s", "Average Sales");
			for (int k = 0; k < 5; k++) {
				System.out.printf("%10.2f", getavgsalesbyweek()[k]);
			}
			System.out.printf("\n\nTotal sales for all weeks: %.2f\n", gettotal());
			System.out.printf("Average weekly sales: $%.2f\n", getavgweeklysales());
			System.out.printf("Week %d has highest amount in sales with $%.2f\n", getweekwithhighestsales(), gettotalsalesbyweek()[getweekwithhighestsales()-1]);
			System.out.printf("Week %d has lowest amount in sales with $%.2f\n", getweekwithlowestsales(), gettotalsalesbyweek()[getweekwithlowestsales()-1]);
			break;
		case 8:
			System.out.printf("Table of Sales Data\n");
			printdata();
			break;
		}
	}
}

