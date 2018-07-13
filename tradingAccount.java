import java.util.Calendar;


public class tradingAccount extends registerManagement{

	Calendar startDate;
	float openingStock;
	
	float purchaseTotal;
	float salesTotal;
	
	float salesFrightTotal;
	float purchaseFrightTotal;
	
	float sTotal;
	float pTotal;

	
	public tradingAccount(Calendar startDate){
		
		this.startDate = startDate;
		openingStock = 0;
		
	}

	

	@SuppressWarnings("static-access")
	public void calculate() {
		
		float saleSofar=0;
		float purchaseSofar=0;
		
		float eachSale=0;
		float eachPurchase=0;
		
		Calendar yearEnd = Calendar.getInstance();
		yearEnd.set(startDate.YEAR+1,4,1);
		
		for(salesRegister records:salesReg){
			
			if(records.saleDate.after(startDate)&&records.saleDate.after(yearEnd)){
				
				if(records.salesOrPurchase)
					saleSofar += records.totalValue;
				else
					purchaseSofar += records.totalValue;;
			}
			
			if(records.salesOrPurchase==true){
				eachSale +=records.totalValue;
				salesFrightTotal += records.fright;
			}
			else{
				eachPurchase +=records.totalValue;
				purchaseFrightTotal += records.fright;
			}
		}
		
		
		openingStock = saleSofar-purchaseSofar; 
		setOpeningStock(openingStock);
		setSalesTotal(eachSale);
		setPurchaseTotal(eachPurchase);
		setSalesFrightTotal(salesFrightTotal);
		setPurchaseFrightTotal(purchaseFrightTotal);	
		setsTotal(openingStock+eachSale+salesFrightTotal);
		setpTotal(openingStock+eachPurchase+purchaseFrightTotal);
	}

	
	public void display(){
		
		System.out.println("\tTrading Account");
		
		System.out.println("\tSales\n"+"Opening Stock :"+getOpeningStock()+"\n"+"Sales Total :"+getSalesTotal()+"\n"
				+"Fright Total :"+getSalesFrightTotal()+"\n"+"Total :"+getsTotal()+"\n");
		

		System.out.println("\tPurchase\n"+"Opening Stock :"+getOpeningStock()+"\n"+"Purchase Total :"+getPurchaseTotal()+"\n"
				+"Fright Total :"+getPurchaseFrightTotal()+"\n"+"Total :"+getpTotal()+"\n");
	}
	
	
	//Opening Stock
	public float getOpeningStock() {
		return openingStock;
	}
	
	public void setOpeningStock(float openingStock) {
		
		this.openingStock = openingStock;
	}
	
	
	//Sales
	public float getSalesTotal() {
		return salesTotal;
	}

	public void setSalesTotal(float salesTotal) {
		
		this.salesTotal = salesTotal;
		
	}

	public float getSalesFrightTotal() {
		return salesFrightTotal;
	}

	public void setSalesFrightTotal(float salesFrightTotal) {
		this.salesFrightTotal = salesFrightTotal;
	}
	
	
	public float getsTotal() {
		return sTotal;
	}



	public void setsTotal(float sTotal) {
		this.sTotal = sTotal;
	}


	
	
	//Purchase
	public float getPurchaseTotal() {
		return purchaseTotal;
	}

	public void setPurchaseTotal(float purchaseTotal) {
		
		this.purchaseTotal = purchaseTotal;
	}


	public float getPurchaseFrightTotal() {
		return purchaseFrightTotal;
	}

	public void setPurchaseFrightTotal(float pruchaseFrightTotal) {
		this.purchaseFrightTotal = pruchaseFrightTotal;
	}



	public float getpTotal() {
		return pTotal;
	}



	public void setpTotal(float pTotal) {
		this.pTotal = pTotal;
	}

	
	
	
}
