package com.csv;

import java.io.IOException;

import com.util.Util;

public class CSVTester {
	
	
	/**
	 * 
	 */
	public String somemethd(int i) {
		int d = 10; 
		
		return "Hello";
	}
	
	public static void main(String[] args) throws IOException {
	
		String filePath = "C:\\Users\\shailendra.rajawat\\Downloads\\Overview_report_download_csv - Verizon.csv";
		
		CSVManager csv=new CSVManager(filePath);
		
		String d2 = Util.getTimeStamp_In_dd_MMM_yyyy_HH_mm_ss_S();
		
		String[] arr1s = Util.getArray("Home  Operator Name"	,"Traffic Period"	,"Partner Group Name"	,"Country","Partner PMN"); 
		
		for (int row = 0; row < 10; row++) {
			System.out.print(row + "\t");
			for (int col = 0; col < csv.getColumnCount(); col++) {
				System.out.print(csv.getValue(row, col)+"\t");
			}
			System.out.println();
		}
		
		String d3 = Util.getTimeStamp_In_dd_MMM_yyyy_HH_mm_ss_S();
		System.out.println("**************************************************************************************************");

		System.out.println(d2);
		System.out.println(d3);
		
		
		
	}
}
