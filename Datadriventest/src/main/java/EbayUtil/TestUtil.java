package EbayUtil;

import java.util.ArrayList;
import Uilities.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		
		try 
		{
		reader =new Xls_Reader("D:\\Automation\\Datadriventest\\src\\main\\java\\TestData\\Ebaydata.xlsx");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2; rowNum<=reader.getRowCount("RegisterData"); rowNum++)
		{
			String firstName=reader.getCellData("RegisterData", "firstname", rowNum);
			String lastName=reader.getCellData("RegisterData", "lastname", rowNum);
			String address1=reader.getCellData("RegisterData", "address1", rowNum);
			String address2=reader.getCellData("RegisterData", "address2", rowNum);
			String city=reader.getCellData("RegisterData", "city", rowNum);
			String state=reader.getCellData("RegisterData", "state", rowNum);
			String zip=reader.getCellData("RegisterData", "zipcode", rowNum);
			String email=reader.getCellData("RegisterData", "emailaddress", rowNum);
			
			//All these system variabled stored in an particular object array
			Object ob[] = {firstName, lastName, address1, address2, city, state, zip, email  };
			myData.add(ob);	
		}
		return myData;  //Retun 1 arraty list object	
	}
}
