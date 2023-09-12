package com.wipro.eb.entity;

public class Domestic extends Connection
{
		public Domestic(int currentReading, int previousReading, float slabs[])
		{
			super(currentReading,previousReading,slabs);
		}
		public float computeBill()
		{
			float res=0;
			float diff=(float) currentReading;
			if(diff<=50)
			{
				res+=(float) diff*slabs[0];
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
			return res;
		}
}
