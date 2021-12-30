package onspot;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class CheckOrderOf007 {

	@Test
	public void test1() {
		int[] arr = {1,2,4,0,0,7,5};
		Assert.assertTrue(find007(arr));
	}
	
	@Test
	public void test2() {
		int[] arr = {0,7,0,7};
		Assert.assertTrue(find007(arr));
	}
	//1020374573450
	private boolean find007(int[] arr) {
		int n = arr.length;
		int zero_count = 0, seven_count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				zero_count++;
			else if (arr[i] == 7){
				if (zero_count > 1) return true; 
				else zero_count = 0;
			}

		}
		return false;
	}
}
