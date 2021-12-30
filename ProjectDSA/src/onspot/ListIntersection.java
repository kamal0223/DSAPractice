package onspot;

import java.util.Arrays;

import org.junit.Test;

public class ListIntersection {

	@Test
	public void test1() {
		int[] volcano = {7000,134000,7000,14000};
		int[] nonvolcano = {7000, 134000,1500000,7000};
		System.out.println(findMathers(volcano,nonvolcano));
	}

	private int[] findMathers(int[] volcano, int[] nonvolcano) {
		Arrays.sort(volcano);
		Arrays.sort(nonvolcano);
		int left = 0, right = 0;
		
		while(right<nonvolcano.length && left<volcano.length) {
			
		}
		
		return null;
	}
	
	
}
