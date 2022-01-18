package com.te.sorting;
import java.util.Scanner;

public class StringPalindrome {
	
		 static boolean isPalindrome(String str)
		    {
		 	    int i = 0, j = str.length() - 1;
		 	        while (i < j) {
		            if (str.charAt(i) != str.charAt(j))
		                return false;
		            i++;
		            j--;
		        }
		        return true;
		    }
			public static void main(String[] args)
		    {
				System.out.println("Enter the String:");
				Scanner sc=new Scanner(System.in);
		        String str1 = sc.next();
		        if (isPalindrome(str1))
		            System.out.print("String is a Palindrome");
		        else
		 	            System.out.print("String is Not a Palindrome");
		        sc.close();
		    }
		}


