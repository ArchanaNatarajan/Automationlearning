package Student_Tests;

import Uilities.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xls_Reader reader=new Xls_Reader("D:\\Automation\\Datadriventest\\src\\main\\java\\TestData\\StudentRegistration.xlsx");  //created object from Xls_Reader.jave from utilities package
	
		//How to add a Sheet
		if(!reader.isSheetExist("homePage"))
		{
		reader.addSheet("homePage");  //create a new sheet in excel file
		}

		//GetRowCount and GetColCount Features
		int colCount=reader.getColumnCount("Stu-sheet1");
		System.out.println("Total colums are present in Stu_sheet1 :" +colCount);
		System.out.println(reader.getCellRowNum("Stu-sheet1", "FirstName", "Archana"));
}
}