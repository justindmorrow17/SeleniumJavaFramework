package demo;

import org.testng.annotations.*;

public class TestNGParameters {

	@Test
	@Parameters({"MyName"})
	public void test1(@Optional ("Alex") String name) {
		System.out.println("Name is: " + name);
	}

}
