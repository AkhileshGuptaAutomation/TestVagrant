package commonFunctions;

import org.testng.Assert;

public class CommonFunctions {
	
	static int TIMEDIFF = 2;
	
	
	public static void verifyIfDiffrenceIsLessThan2(String str1, String str2){
		
	 int WebTemp = Integer.parseInt(str1);
	 int APITemp = Integer.parseInt(str2);
	 
	 int diff = WebTemp-APITemp;
	 if(Math.abs(diff)<=2){Assert.assertTrue(true);}
	 else {Assert.assertTrue(false,"Failed : Diff in Web Temperature Value and API Temperature Value is greater than 2");}
		
	}

}
