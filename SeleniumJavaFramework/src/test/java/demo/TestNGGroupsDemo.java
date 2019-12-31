package demo;

import org.testng.annotations.*;

@Test(groups = {"AllClassGroup"})
public class TestNGGroupsDemo {

	@Test(groups = { "sanity" })
	public void test1() {
		System.out.println("This is Test 1");
	}

	@Test(groups = { "sanity", "smoke" })
	public void test2() {
		System.out.println("This is Test 2");
	}

	@Test(groups = { "sanity", "regression" })
	public void test3() {
		System.out.println("This is Test 3");
	}

	@Test(groups = { "" })
	public void test4() {
		System.out.println("This is Test 4");
	}
}
