package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void sample()
	{
		System.out.println("Step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		
		Assert.assertEquals(0, 1);
		
		System.out.println("Step 4");
		System.out.println("step 5");
		
		
			
	}
	
	@Test
	public void sample1()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("step 2");
		
		sa.assertEquals(0, 1);//fail
		
		System.out.println("step 3");
		
		sa.assertEquals(0, 1);//fail
		
		System.out.println("Step 4");
		
		sa.assertTrue(false);//fail
		
		System.out.println("step 5");
		
		//sa.assertAll();//LOG THE FAIL
		
			
	}

}
