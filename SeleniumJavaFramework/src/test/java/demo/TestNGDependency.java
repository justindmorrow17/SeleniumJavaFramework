package demo;

import org.testng.annotations.*;

public class TestNGDependency {
	
	@Test(dependsOnGroups= {"sanity1"})
	public void Test1() {
		System.out.println("I am inside Test 1");
	}
	
	@Test(groups="sanity1")
	public void Test2() {
		System.out.println("I am inside Test 2");
	}
	
	@Test(priority = 3)
	public void Test3() {
		System.out.println("I am inside Test 3");
	}
	
	
	
	
//	@Test(dependsOnMethods= {"Test2", "Test3"}, priority = 1)
//	public void Test1() {
//		System.out.println("I am inside Test 1");
//	}
//	
//	@Test(priority = 2)
//	public void Test2() {
//		System.out.println("I am inside Test 2");
//	}
//	
//	@Test(priority = 3)
//	public void Test3() {
//		System.out.println("I am inside Test 3");
//	}
}
