import java.util.Calendar;


public class registerDemo {

	
	public static void main(String[] args) throws CustomerNotFoundException {
	
		Calendar tac = Calendar.getInstance();
		
		
		//Creating register for customer
		tac.set(2019,4,2);
		salesRegister s = new salesRegister(tac, "B", 1234, 118, 100,9,9,100,true);
		
		tac.set(2018,4,2);
		salesRegister s3 = new salesRegister(tac, "D", 1234, 118, 100,9,9,100,false);
		
		tac.set(2019,6,2);
		salesRegister s1 = new salesRegister(tac, "A", 1243, 160, 140,10,10,100,false);
		
		tac.set(2018,8,2);
		salesRegister s2 = new salesRegister(tac, "C", 1294, 118, 100,9,9,200,true);
		
		//Up casting
		registerManagement rm = new Ledger();
	
		//Adding customers to list
		rm.addCustomer(s);
		rm.addCustomer(s1);
		rm.addCustomer(s2);
		rm.addCustomer(s3);
		
		//Down casting
		Ledger l1 = (Ledger)rm;
				
		//Displaying the list of customers
		l1.displaySales();
			
		//Calculating debit
		l1.calcBalance("B", 30);
		l1.calcBalance("A", 20);
		
		//Sorting according to name
		l1.comp();
		l1.display();
		
	
		//Trading account
		
		tac.set(2018,6,1);
		tradingAccount ta = new tradingAccount(tac);
		ta.calculate();
		ta.display();
		
	}

}
