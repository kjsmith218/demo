package net.kjsmith;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(new Main().get());
	}

	@SuppressWarnings("static-method")
	public String get() {
		return "Hello world";
	}
}
