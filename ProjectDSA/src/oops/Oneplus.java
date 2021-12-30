package oops;

public interface Oneplus extends Android {
	public static void OS() {
		System.out.println("OnePlus skinned Android");
	}
	
	public default void display() {
		System.out.println("OLED dispaly from one plus");
	}
}
