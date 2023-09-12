package com.wipro.eb.service;
import com.wipro.eb.exception.InvalidReadingException;
import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;

public class ConnectionService 
{
		float slab1[]= {2.3f, 4.2f, 5.5f};
		float slab2[]= {5.2f, 6.8f, 8.3f};
		public String generateBill(int currentReading, int previousReading, String type)
		{
				float cb=calculateBillAmt(currentReading,previousReading,type);
				if(cb==-1) return (new InvalidReadingException().toString());
				else if(cb==-2) return (new InvalidConnectionException().toString());
				String s="Amount to be paid is: "+cb;
				return s;
		}
		public float calculateBillAmt(int currentReading,int previousReading, String type)
		{
				try
				{
					validate(currentReading,previousReading,type);
				}
				catch(InvalidReadingException e)
				{
					return -1;
				}
				catch(InvalidConnectionException e)
				{
					return -2;
				}
				if(type.toLowerCase().equals("commercial"))
				{
					return(new Commercial(currentReading, previousReading, slab2).computeBill());
				}
				return new Domestic(currentReading, previousReading, slab1).computeBill();
				
		}
		public boolean validate (int currentReading, int previousReading, String type) throws InvalidReadingException,InvalidConnectionException
		{
			if(currentReading<previousReading || currentReading<0 || previousReading<0) throw new InvalidReadingException();
			if(!type.toLowerCase().equals("domestic") && !type.toLowerCase().equals("commercial")) throw new InvalidConnectionException();
			return true;
		}
}
