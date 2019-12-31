package demo;

import org.testng.annotations.*;

public class TestNGIgnoreDemo {

	@Ignore
	@Test
	public void test1() {
		System.out.println("I am inside test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside test 2");
	}
	
//	@Test
//	public void test3() {
//		System.out.println("I am inside test 3");
//	}
}
