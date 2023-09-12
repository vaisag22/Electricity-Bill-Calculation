package com.wipro.eb.entity;

public class Commercial extends Connection
{
		public Commercial(int currentReading,int previousReading, float slabs[])
		{
				super(currentReading,previousReading,slabs);
		}
		public float computeBill()
		{
				float diff=(float)currentReading;
				float res=0;
				if(diff<=50)
				{
					res+=(float) 50*slabs[0];
				}
				else if(diff<=100)
				{
					res+=(float) 50*slabs[0];
					diff-=50;
					res+=(float) diff*slabs[1];
				}
				else
				{
					res+=(float) 50*slabs[0];
					diff-=50;
					res+=(float) 50*slabs[1];
					diff-=50;
					res+=(float) diff*slabs[2];
				}
				float bill=0;
				if(res<5000) bill+=(float)res+(res*0.02);
				else if(res<10000) bill+=(float) res+(res*0.06);
				else bill+=(float) res+(res*0.09);
				return bill;
		}
}
