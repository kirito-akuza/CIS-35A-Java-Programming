/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 3
 * Due Date: 02/14/2022
 * Date Submitted: 02/14/2022
 */

Instruction to review and run code:

*****************************************Driver.java*****************************************************
1. In function "public static int BinaryToDecimal(int binaryNumber) {} "

Step 1: // Create instance and object of FileIO	
	FileIO a1 = new FileIO("C:\\Users\\Nathan Dinh\\eclipse-workspace\\CIS_35A\\src\\assignment_3\\Salesdat.txt");

Step 2: // Read data from file
	Franchise f = a1.readData();

Step 3: // Do calculation for all stores by calling method calc()
	f.calc();

Step 4: // Get ready and Run UI
	UI ui = new UI(f);
	ui.play();

*****************************************FileIO.java*****************************************************

Step 1: // Declares variables
	private String fname = null;
	// Set DEBUG status to true to print getting data processing to the screen
	private boolean DEBUG = false;
		
Step 2: // Constructor
	public FileIO(String fname) {
		this.fname = fname;
	}
		
Step 3: /// Method of reading data
	public Franchise readData() {
		// Declares variables
		Franchise a1 = null;
		int counter = 0;
		// Exception handling to open and read the file
		try {
			// Open the file
			FileReader file = new FileReader(fname);
			// Create a buffer
			BufferedReader buff = new BufferedReader(file);
			String temp;
			boolean eof = false;
			// Check if the file is end already or not
			while (!eof) {
				// Get the next line and store in line variable
				String line = buff.readLine();
				// Count increases
				counter++;
				// If there are no line -> set eof true
				if (line == null)
					eof = true;
				else {
					if (DEBUG)
						System.out.println("Reading" + line);
					// Get and store number of store
					if (counter == 1) {
						temp = line;
						a1 = new Franchise(Integer.parseInt(temp));
						if (DEBUG)
							System.out.println("d  " + a1.numberofstores());
					}
					// Ignore if counter equals to 2
					if (counter == 2)
						;
					// Create stores
					if (counter > 2) {
						  	int x = buildStore(a1, (counter-3), line);
							if (DEBUG)
								System.out.println("Reading Store # "+(counter-2)+" Number of weeks read =  " +  x);
							if (DEBUG)
							{	
								System.out.println("Data read:");
								// Get the store data
								a1.getStores(counter-3).printdata();
							}
					}
				}
			}
			// Close the buffer
			buff.close();
		} catch (Exception e) {
			// If there is any error while opening and reading the file, catch the exception
			System.out.println("Error -- " + e.toString());
		}
		// Return the value
		return a1;
	}

Note: The try-catch block is used to check the exception while opening and processing the file. If there is anything wrong found -> catch the exception

Step 4: // Method of building stores
	public int buildStore(Franchise a1, int counter, String temp) {
		// Declares variables
		Store tstore = new Store();
		String s1  =  "";
		float sale = 0.0f;
		int week = 0;
		int day = 0;
		// Break string into tokens
		StringTokenizer st = new StringTokenizer(temp);
	    while (st.hasMoreTokens()) {
	         for(day=0;day<7;day++)
	         {
		    	 s1 = st.nextToken();
		    	 // Convert string to float
		         sale = Float.parseFloat(s1);
		         // Set store's sales by day and week
	        	 tstore.setsaleforweekdayintersection(week, day, sale);
	         }
	         week++;
	    }
	    // Setting a store
		a1.setStores(tstore, counter);
	    return week; 
	}


*****************************************Franchise.java*****************************************************

Step 1: // Declares variable
	private Store stores[];
	
Step 2: // Constructor
	public Franchise(int num) {
		stores = new Store[num];
	}

Step 3: // Get a store
	public Store getStores(int i) {
		return stores[i];
	}

Step 4: // Set a store
	public void setStores(Store stores, int i) {
		this.stores[i] = stores;
	}
	
Step 5: // Get number of stores
	public int numberofstores()
	{
		return stores.length;
	}
Step 6: // Do calculation for all stores
	public void calc() {
		for(int i = 0; i < stores.length; i++) {
			stores[i].analyzeresult();
		}
	}


*****************************************Store.java*****************************************************

Step 1: // Declares variables
	private float salesbyweek[][];
	private float totalsalesbyweek[];
	private float avgsalesbyweek[];
	private float totalsalesforallweeks;
	private float avgweeklysales;
	private int weekwithhighestsales;
	private int weekwithlowestsales;

Step 2:	// Default Constructor
	Store() {
		salesbyweek = new float[5][7];
		totalsalesbyweek = new float[5];
		avgsalesbyweek = new float[5];
		totalsalesforallweeks = 0;
		avgweeklysales = 0;
	}
		
Step 3: // setsaleforweekdayintersection(int week, int day, float sale)
	public void setsaleforweekdayintersection(int week, int day, float sale) {
		salesbyweek[week][day] = sale;
	}
		
Step 4: // Method of printing table of sales data
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
		
Step 6: // Calculate total sales by week
	public void calctotalsalesbyweek() {
		for (int i = 0; i < 5; i++) {
			totalsalesbyweek[i] = 0;
			for (int j = 0; j < 7; j++) {
				totalsalesbyweek[i] += getsaleforweekdayintersection()[i][j];
			}
		}
	}
		
Step 7: // Calculate average sales by week
	public void calcavgsalesbyweek() {
		calctotalsalesbyweek();
		for (int i = 0; i < 5; i++) {
			avgsalesbyweek[i] = gettotalsalesbyweek()[i] / 7;
		}
	}
		
Step 8: // Calculate total sales
	public void calctotal() {
		calctotalsalesbyweek();
		for (int i = 0; i < 5; i++) {
			totalsalesforallweeks += gettotalsalesbyweek()[i];
		}
	}
		
Step 9:	// Calculate average weekly sales
	public void calcavgweeklysales() {
		calcavgsalesbyweek();
		for (int i = 0; i < 5; i++) {
			avgweeklysales += getavgsalesbyweek()[i] / 5;
		}
	}
		
Step 10: // Calculate week with highest sales
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
		
Step 11: // Calculate week with lowest sales
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
		
Step 12: // Get sale for week day intersection
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

Step 13: // Do calculation data 
	public void analyzeresult() {
		calctotalsalesbyweek();
		calcavgsalesbyweek();
		calctotal();
		calcavgweeklysales();
		calcweekwithhighestsales();
		calcweekwithlowestsales();
	}

Step 14: // Print data by options
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

*****************************************UI.java*****************************************************
Step 1: // Get data from keyboard
	Scanner in = new Scanner(System.in);
	
	// Declare variable
	private Franchise f;

Step 2: public void play() {
		// Declare variables
		boolean flag = true;
		boolean checkInput = true;
		char key;
		
		System.out.println("Welcome to Franchise App");
		System.out.println("We have data for 6 stores for last 5 weeks.");
		// If flag == true -> keep looping
		while (flag) {
			// If checkInput == true -> runUI() to ask and get data from user
			if (checkInput)
				runUI();
			// Ask user if he/she wants to continue to use the app
			System.out.print("Do you want to continue? - enter <y/n>: ");
			key = in.next().charAt(0);
			
			// If user enters any character that invalid -> asks user to enter again
			if(key == 'y' || key =='Y') {
				checkInput = true;
			} else if (key == 'n' || key == 'N') {
				// If user enter 'n' or 'N' -> exit the loop
				flag = false;
			} else {
				System.out.println("Invalid input. Please try it again.");
				checkInput = false;
			}
		}
		// If user enters 'n' or 'N' -> exit the loop and say goodbye
		System.out.println("Thank you! Have a nice day!");	
	}

Step 3: // RunUI method
	void runUI() {
		// Declares variables
		int i, k;
		
		// Get user's input the store's number
		System.out.print("Select a store # you want to see analytics for - enter <1 through 6>: ");
		i = in.nextInt();
		
		// If user enters a number out of range from 1 to 6 -> Asks user to retry
		while (i > 6 || i < 1) {
			System.out.println("Store invalid.");
			System.out.println("Please try it again.");
			System.out.print("\nSelect a store # you want to see analytics for - enter <1 through 6>: ");
			i = in.nextInt();
		}
		
		// Asks user to select operation for a store
		System.out.printf("Acessing data from store %d ...\n", i);
		System.out.println("Select operation - ");
		System.out.println("1. Enter 1 for total sales for each week");
		System.out.println("2. Enter 2 for average daily sales for each week");
		System.out.println("3. Enter 3 for total sales for all weeks");
		System.out.println("4. Enter 4 for average weekly sales");
		System.out.println("5. Enter 5 for week with the highest amount in sales.");
		System.out.println("6. Enter 6 for week with the lowest amount in sales.");
		System.out.println("7. Enter 7 for all analytical data. (1 through 6)");
		System.out.println("8. Enter 8 for table of sales data");
		System.out.print("Enter <1 through 8>: ");
		k = in.nextInt();
		
		// If users enter a number out of range from 1 to 8 -> ask user to retry
		while (k < 1 || k > 8) {
			System.out.println("Invalid operation");
			System.out.println("Please try it again.");
			System.out.println("\nSelect operation - ");
			System.out.println("1. Enter 1 for total sales for each week");
			System.out.println("2. Enter 2 for average daily sales for each week");
			System.out.println("3. Enter 3 for total sales for all weeks");
			System.out.println("4. Enter 4 for average weekly sales");
			System.out.println("5. Enter 5 for week with the highest amount in sales.");
			System.out.println("6. Enter 6 for week with the lowest amount in sales.");
			System.out.println("7. Enter 7 for all analytical data. (1 through 6)");
			System.out.println("8. Enter 8 for table of sales data");
			System.out.print("Enter <1 through 8>: ");
			k = in.nextInt();
		}
		
		// Print out to the screen
		f.getStores(i-1).print(k);
	}
