import java.util.ArrayList;

public class registerManagement {

	
	protected ArrayList<salesRegister> salesReg = new ArrayList<salesRegister>();
	
	public void addCustomer(salesRegister s){
		salesReg.add(s);
	}
	
	public salesRegister getCustomer(String name)throws CustomerNotFoundException{
		
		for(salesRegister s:salesReg)
			if(s.getPartyName().equals(name))
				return s;
	
		throw new CustomerNotFoundException("Customer not found");
	}
	
	public void deleteCustomer(String name) throws CustomerNotFoundException{
		
		boolean flag = false;
		
		for(salesRegister s:salesReg){
			
			if(s.getPartyName().equals(name)){
				flag = true;
				salesReg.remove(s);
				break;
				
			}
		}
		
		if(flag)
			System.out.println("Customer "+name+" Deleted");
		else
			throw new CustomerNotFoundException("Customer not found");
		
	}
	
	public void display(){
		
		for(salesRegister records:salesReg){
			
			String str = records.toString();
			
			if(records.validTotal())
				System.out.println(str);
				
			else
				System.out.println("Invalid total income. Total should be "+records.expectedTotal);

		}
		
	}
	
	 
	
}
