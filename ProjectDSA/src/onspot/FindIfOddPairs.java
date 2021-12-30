package onspot;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class FindIfOddPairs {

	@Test
	public void test1() {
		int[] arr = {2,7,4,6,3,1};
		System.out.println(findOddPairs2(arr));
	}
	
	@Test
	public void test2() {
		int[] arr = {-1,-3,4,7,7,7};
		System.out.println(findOddPairs2(arr));
	}
	
	@Test
	public void test3() {
		int[] arr = {1,2,4,3};
		System.out.println(findOddPairs2(arr));
	}

	private boolean findOddPairs(int[] arr) {
		int left = 0, right = 1, count = 0;
		Set<Integer> set = new HashSet<Integer>();
		while(right<arr.length) {
			if(set.contains(left)) left++;
			if(set.contains(right)) right++;
			if((arr[left]+arr[right])%2 != 0) {
				set.add(left++);
				set.add(right++);
				count++;
			}else {
				right++;
			}
		}
		if(count == arr.length/2) return true;
		else return false;
	}
	
	private boolean findOddPairs2(int[] arr) {
		int evenCount = 0, oddCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%2 == 0) evenCount++;
			else oddCount++;
		}
		
		if(oddCount-evenCount == 0) return true;
		
		return false;
	}
}
