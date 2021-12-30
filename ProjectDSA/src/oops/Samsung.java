package oops;

public interface Samsung extends Android{

	public static void OS() {
		System.out.println("samsung skinned Android");
	}
	
	public default void display() {
		System.out.println("Amoled display");
	}

}
