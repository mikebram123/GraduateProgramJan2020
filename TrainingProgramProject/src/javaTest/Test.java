package javaTest;

public class Test {

	public Test() {
		this(10);
		System.out.println("A");
		
	}
	
	private Test(int value) {
		this("Hello");
		System.out.println("B");
	}
	
	protected Test(String value) {
		System.out.println("C");
	}
	public static void main(String[] args) {
		Test test = new Test();

	}

}
