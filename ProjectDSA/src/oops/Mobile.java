package oops;

public class Mobile implements Samsung, Oneplus {
	
	public static void main(String[] args) {
		Samsung.OS();
		Oneplus.OS();
		Mobile obj = new Mobile();
		obj.boot();
		obj.display();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		Oneplus.super.display();
	}
	
	
	

}
