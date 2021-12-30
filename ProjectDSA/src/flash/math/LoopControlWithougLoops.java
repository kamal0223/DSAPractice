package flash.math;

public class LoopControlWithougLoops {
	
	public static void main(String[] args) {
		LoopControlWithougLoops o = new LoopControlWithougLoops();
		o.loopControl(0);
	}
	
	public void loopControl(int count) {
		if(count>100) return;
		System.out.println(count);
		//count = count+1;
		loopControl(++count);
	}

}
