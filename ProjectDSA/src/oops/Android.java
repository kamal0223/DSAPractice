package oops;

public interface Android {

	public default void boot() {
		System.out.println("boot the device");
	}
}
