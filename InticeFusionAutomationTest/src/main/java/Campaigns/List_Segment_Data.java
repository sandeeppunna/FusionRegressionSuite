package Campaigns;

import Base.Page;

public class List_Segment_Data extends Page
{
	public void get_List1801( String Year, String Make, String Model)
	{
		String listdata = Year+Make+Model;
		System.out.println(Year+Make+Model);
//		for(int i=0;i<listdata.length;i++)
//			{
//				for(int j=0;j<3;j++)
//				{
//					System.out.print(listdata[i][j]+"\t");
//					System.out.println();
////					{
////						System.out.println(segmentdata);
////						count++;
////					}
//				}
//			}
//		System.out.println(listdata.length);
	}
	public void get_HondaSegmentCampaign(String Year, String Make, String Model, String sheetName)
	{
		int segment_Count =	excel.getRowCount(sheetName);
		
		
		
//		for(int i=0;i<segmentdata.length;i++)
//			{
//				for(int j=0;j<3;j++)
//				{
//					System.out.print(segmentdata[i][j]+"\t");
//				}
//			}
	}
}
