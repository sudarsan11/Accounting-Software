import java.util.Calendar;
import java.util.Date;

public class salesRegister {
 
	Calendar saleDate = Calendar.getInstance();
	String partyName = new String(); 
	boolean salesOrPurchase;
	int billNum;
	float totalValue;
	float taxableIncome;
	float CGST;
	float SGST;
	float IGST;
	float expectedTotal;
	float fright;
	protected float balance;
	protected float credit;
	
	
	public String toString(){
		
		String temp = (salesOrPurchase==true)?"Sales":"Purchase";
		return "\t"+temp+"\n"+"Date: "+saleDate.getTime()+"\n"+"Name: "+partyName+"\n"+"Bill: "+billNum+"\n"+
				"Total Value: "+totalValue+"\n"+"Taxable Income: "+taxableIncome+"\n"+"CGST: "+CGST+"\n"+
				"SGST: "+SGST+"\n"+"Fright: "+fright+"\n";	
	}
	
	
	public String toStrings(){
		
		String temp = (salesOrPurchase==true)?"Sales":"Purchase";
		return "\t"+temp+"\n"+"Date: "+saleDate.getTime()+"\n"+"Name: "+partyName+"\n"+"Bill: "+billNum+"\n"+
				"Total Value: "+totalValue+"\n"+"Credit: "+credit+"\n"+"Balance: "+balance+"\n";	
		
	}
	

	public salesRegister(Calendar saleDate, String partyName, int billNum,
			float totalValue, float taxableIncome, float cGST, float sGST,float fright,boolean salesOrPurchase) {
		super();
		this.saleDate = saleDate;
		this.partyName = partyName;
		this.billNum = billNum;
		this.totalValue = totalValue;
		this.taxableIncome = taxableIncome;
		this.salesOrPurchase = salesOrPurchase;
		this.fright = fright;
		CGST = cGST;
		SGST = sGST;
		
	}

	public void setSaleDate(Calendar saleDate) {
		this.saleDate = saleDate;
	}

	public Date getSaleDate() {
		return saleDate.getTime();
	}

	
	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public int getBillNum() {
		return billNum;
	}

	public void setBillNum(int billNum) {
		this.billNum = billNum;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}

	public float getTaxableIncome() {
		return taxableIncome;
	}

	public void setTaxableIncome(float taxableIncome) {
		this.taxableIncome = taxableIncome;
	}

	public float getCGST() {
		return CGST;
	}

	public void setCGST(float percentage) {
		
		CGST = (taxableIncome*percentage)/100;
	}

	public float getSGST() {
		return SGST;
	}

	public void setSGST(float percentage) {
		SGST = (taxableIncome*percentage)/100;
	}

	public float getIGST() {
		return IGST;
	}
	
	public float getCredit() {
		return credit;
	}


	public void setCredit(float credit) {
		this.credit = credit;
	}


	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	

	public void setIGST(float percentage) {
		IGST = (taxableIncome*percentage)/100;
	}
	
	public boolean validTotal(){
		
		if(totalValue==CGST+SGST+taxableIncome)
			return true;
		
		expectedTotal = CGST+SGST+taxableIncome;
		return false;
	}
	
	public float getFright() {
		return fright;
	}


	public void setFright(float fright) {
		this.fright = fright;
	}

}
