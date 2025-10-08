package day1_10092025;

import org.testng.annotations.*;

public class AnnotationsDemo {
	
	@AfterClass
	public void acls()
	{
		System.out.println("After class Method");
	}
	@BeforeTest
	public void btest()
	{
		System.out.println("Before Test Method");
	}
	@BeforeClass
	public void bcls()
	{
		System.out.println("Before class Method");
	}
	@BeforeMethod
	public void bmethod()
	{
		System.out.println("Before Method Method");
	}
	@Test
	public void t1()
	{
		System.out.println("Test 1");
	}
	@Test
	public void t2()
	{
		System.out.println("Test 2");
	}
	@AfterMethod
	public void amethod()
	{
		System.out.println("After Method Method");
	}
	
	@AfterTest
	public void atest()
	{
		System.out.println("After Test Method");
	}
	@AfterSuite
	public void aSuite()
	{
		System.out.println("After Suite Method");
	}
	@BeforeSuite
	public void bsuite()
	{
		System.out.println("Before Suite Method");
	}

}
