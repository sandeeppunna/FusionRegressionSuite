package Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.sql.RowSet;

public class ReadCSV 
{

   
public static String getcellvalue(String filename,int rownum,int columnnum) {
        String cellvalue=null;
        String csvFile = filename;
        BufferedReader br = null;
        String line = "\n";
        String cvsSplitBy = ",";

        try {

                br = new BufferedReader(new FileReader(csvFile));
                String[][] csvmatrix=null;
                String[] columns=null;
                String[] rows=null;

                int rowcount=0;
                //get each row
                while ((line = br.readLine()) != null) {
                         rows = line.split(cvsSplitBy);
                         if(rownum==rowcount){
                                        //get each column
                                         for (int i=0;i<rows.length;i++){
                                                 if(columnnum-1==i){
                                                         cellvalue=rows[i];
                                                 }
                                         }
                                         

                                }
                         rowcount++;
                }



        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
                if (br != null) {
                        try {
                                br.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }

        
        return(cellvalue);
  }

  
  public static int getrows(String filename) throws IOException{
	  String cellvalue=null;
      String csvFile = filename;
      BufferedReader br = null;
      String line = "\n";
      String cvsSplitBy = ",";
      

          br = new BufferedReader(new FileReader(csvFile));
          String[][] csvmatrix=null;
          String[] columns=null;
          String[] rows=null;

          int rowcount=0;
          //get each row
          while ((line = br.readLine()) != null) {
                   rows = line.split(cvsSplitBy);
                   rowcount++;
          }

	  return(rowcount-1);
      
  }
}



