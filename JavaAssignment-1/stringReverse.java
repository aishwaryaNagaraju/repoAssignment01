package com.te.sorting;
import java.util.Scanner;

public class StringReverse {
	
		public static String reverseString(String str){  
		    char ch[]=str.toCharArray();  
		    String rev="";  
		    for(int i=ch.length-1;i>=0;i--){  
		        rev+=ch[i];  
		    }  
		    return rev;  
		}
		
		public static void main(String[] args) { 
			System.out.println("Enter the String:");
			Scanner sc=new Scanner(System.in);
			String str1=sc.next();
			sc.close();
		    System.out.println(StringReverse.reverseString(str1));        
		    }  

	}