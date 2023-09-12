package com.wipro.eb.main;
import java.util.*;
import com.wipro.eb.service.ConnectionService;
public class EBMain 
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your previous month reading: ");
		int previousReading=sc.nextInt();
		System.out.println("Enter your current month reading: ");
		int currentReading=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your Connection Type either 'Domestic' or 'Commercial' : ");
		String type=sc.nextLine();
		System.out.println(new ConnectionService().generateBill(currentReading,previousReading,type));
	}
}
