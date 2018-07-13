import java.util.Collections;
import java.util.Comparator;


public class Ledger extends registerManagement{

	private float credit;
	
	public void comp(){
		
		Comparator<salesRegister> cmp = new Comparator<salesRegister>() {
			public int compare(salesRegister o1, salesRegister o2) {
				
				String first = o1.getPartyName().toLowerCase();
				String second = o2.getPartyName().toLowerCase();
				
				return first.compareTo(second);
			}
		};
		
		Collections.sort(salesReg,cmp);
		
	}
	
	public void calcBalance(String name,float credit) throws CustomerNotFoundException{
		
		for(salesRegister records:salesReg){
			
			if(records.partyName.equals(name)){
				records.setCredit(credit);
				records.setBalance(getCustomer(name).totalValue-credit);
				break;
			}
		}
		
	}

	@Override
	public void display(){
		
		
		
		for(salesRegister records:salesReg){
			
			String str = records.toStrings();
			
			if(records.validTotal())
				System.out.println(str);
				
			else
				System.out.println("Invalid total income. Total should be "+records.expectedTotal);

		}
		
	}
	
	public void displaySales(){
		super.display();
	}
	
	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}


	
	
	
	

}

	
