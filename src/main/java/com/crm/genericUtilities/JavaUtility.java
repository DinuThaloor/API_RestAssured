package com.crm.genericUtilities;

import java.util.Random;

public class JavaUtility 
{
	public int getRandomNumber()
	{
		Random random=new Random();
		int randNum=random.nextInt(1000);
		return randNum;
	}


}
