package Utilities;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.sql.RowSet;

public class MHFeed_Read_CSV 
{
  public static int row_Count(String csvfile1,String file1, String file2)
  {
	  List_Excel getmatched=new List_Excel();
	  int occurtotal=0;
	  try 
	  {
		//phase 1 get matched list
		ArrayList<String> MatchedList=getmatched.matched(file1,file2);
		System.out.println("\nmatched list size "+MatchedList.size());
		
		//phase 2 get rows list from csv
		String csvfile=csvfile1;
		MHFeed_Read_CSV obj = new MHFeed_Read_CSV();
		int mightrows=obj.getrows(csvfile);
		ArrayList<String> mightlist=new ArrayList<String>();
		for(int row=2;row<=mightrows;row++)
		{
			mightlist.add(obj.getcellvalue(csvfile, row, 8)+obj.getcellvalue(csvfile, row, 9)+obj.getcellvalue(csvfile, row, 10));
		}
		
		//phase 3 get occurences
		
		for(int row=0;row<MatchedList.size();row++)
		{
			int occurrences = Collections.frequency(mightlist, MatchedList.get(row));
			System.out.println(" value= "+MatchedList.get(row)+"  occurenece= "+occurrences);
			occurtotal+=occurrences;
		}
		System.out.println("Occurence total  "+occurtotal);
	}
	catch (IOException e) 
	{
			e.printStackTrace();
	}
	  return occurtotal;
  }
 

  @SuppressWarnings("null")
  public String getcellvalue(String filename,int rownum,int columnnum) 
  {
	String cellvalue=null;
	String csvFile = filename;
	BufferedReader br = null;
	String line = "\n";
	String cvsSplitBy = ",";

	try 
	{
		br = new BufferedReader(new FileReader(csvFile));
		String[][] csvmatrix=null;
		String[] columns=null;
		String[] rows=null;
		
		int rowcount=0;
		//get each row
		while ((line = br.readLine()) != null) 
		{
			 rows = line.split(cvsSplitBy);
			 if(rownum-1==rowcount)
			 {
				 	 //get each column
			 		 for (int i=0;i<rows.length;i++)
			 		 {
			 			 if(columnnum-1==i)
			 			 {
			 				 cellvalue=rows[i];
			 			 }
					 }
					 
			 }
			 rowcount++;
		}
	} 
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
	catch (IOException e) 
	{
		e.printStackTrace();
	} finally 
	{
		if (br != null) 
		{
			try 
			{
				br.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	//System.out.println("Done");
	return(cellvalue);
 }

  @SuppressWarnings("null")
  public static int getrows(String filename) 
  {
	String cellvalue=null;
	String csvFile = filename;
	BufferedReader br = null;
	String line = "\n";
	String cvsSplitBy = ",";
	int rowcount=0;
	try 
	{
		br = new BufferedReader(new FileReader(csvFile));
		String[][] csvmatrix=null;
		String[] columns=null;
		String[] rows=null;
		
		//get each row
		while ((line = br.readLine()) != null) 
		{
			 rows = line.split(cvsSplitBy);
			 rowcount++;
		}
	}
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	} catch (IOException e) 
	{
		e.printStackTrace();
	}
	finally 
	{
		if (br != null) 
		{
			try 
			{
				br.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	//System.out.println("Done");
	return(rowcount);
}

}