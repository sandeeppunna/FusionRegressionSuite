package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Counter_Excel {
	public static void Manage_Segments(String file1, String file2) throws IOException{
		
		//**********************************************************
		//phase 1
			// total elements in list 1
		ArrayList<String> mylist1=excel_reader(file1);
		Set<String> remove_duplicate = new HashSet<String>();
		remove_duplicate.addAll(mylist1);
		mylist1.clear();
		mylist1.addAll(remove_duplicate);
		//System.out.println("list size" + mylist1.size());
		
		
		
		//**********************************************************
		//phase 2
		
		ArrayList<String> mylist2=excel_reader(file2);
		//System.out.println("Segment size" + mylist2.size());
		
		//************************************************************
		//phase 3 
		Integer missed=0,matched=0,multiple=0;
		ArrayList<String> mylist_miss = new ArrayList<String>();
		ArrayList<String> mylist_match = new ArrayList<String>();
		ArrayList<String> mylist_multiple = new ArrayList<String>();
		
		//System.out.println(occurrences);
		for(int i=0;i<mylist1.size();i++){
			//System.out.println("Name: "+ mylist1.get(i));
			int occurrences = Collections.frequency(mylist2, mylist1.get(i));
			//System.out.println("Occurence: "+ occurrences);
			
			
			if(occurrences ==0){
				//System.out.println("Type: "+ "Missed");
				missed++;
				mylist_miss.add(mylist1.get(i));
			}
			if(occurrences ==1){
				//System.out.println("Type: "+ "Matched");
				matched++;
				mylist_match.add(mylist1.get(i));
			}
			if(occurrences >1){
				//System.out.println("Type: "+ "Multiple");
				multiple++;
				mylist_multiple.add(mylist1.get(i));
			}
			
			//System.out.println();
		}
		
		
		
		
		System.out.println("Final Output");
		System.out.println("Missed: "+missed+"  Matched: "+matched+"  Multiple: "+multiple);
		
		
		//System.out.print(mylist1);
		
	}
	
	
	public static ArrayList excel_reader(String filepath) throws IOException{
		FileInputStream file = new FileInputStream(new File(filepath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		CellReference cellReference_A1 = new CellReference("A1"); 
		Row rowa1 = sheet.getRow(cellReference_A1.getRow());
		Cell cella1 = rowa1.getCell(cellReference_A1.getCol());
		

		CellReference cellReference_B1 = new CellReference("B1"); 
		Row rowb1 = sheet.getRow(cellReference_B1.getRow());
		Cell cellb1 = rowa1.getCell(cellReference_B1.getCol());
		

		CellReference cellReference_C1 = new CellReference("C1"); 
		Row rowc1 = sheet.getRow(cellReference_C1.getRow());
		Cell cellc1 = rowa1.getCell(cellReference_C1.getCol());
		//System.out.println(cella1);
		//System.out.println(cellb1);
		//System.out.println(cellc1);
		
		
		Map<String, String> aMap = new HashMap<String, String>();
		aMap.put(cella1.toString() ,"A");
		aMap.put(cellb1.toString() ,"B");
		aMap.put(cellc1.toString() ,"C");
		
		String col1=aMap.get("Year"),col2=aMap.get("Make"),col3=aMap.get("Model");
		
	
		ArrayList<String> mylist = new ArrayList<String>();
		for (Integer i=2;i<=sheet.getLastRowNum()+1;i++){
		
				CellReference cellReference1 = new CellReference(col1+i.toString()); 
				Row row1 = sheet.getRow(cellReference1.getRow());
				Cell cell1 = row1.getCell(cellReference1.getCol());
				Double output_d=cell1.getNumericCellValue();
				Integer output_i=output_d.intValue();
				String output1=output_i.toString();
				
				CellReference cellReference2 = new CellReference(col2+i.toString()); 
				Row row2 = sheet.getRow(cellReference2.getRow());
				Cell cell2 = row2.getCell(cellReference2.getCol());
				//System.out.println(cell2);
				
				
				
				CellReference cellReference3 = new CellReference(col3+i.toString()); 
				Row row3 = sheet.getRow(cellReference3.getRow());
				Cell cell3 = row3.getCell(cellReference3.getCol());
				//System.out.println(cell3);
				
				mylist.add(output1+cell2+cell3);
				//System.out.println(output1+cell2+cell3);
		}
		return(mylist);
	}
}
