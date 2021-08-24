package onspot;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//5. List of integer, reverse the list and return the list
public class ReverseAIntList {
	
	@Test
	public void test1() {
		List<Integer> input = new ArrayList<Integer>();
		input.add(2);
		input.add(4);
		input.add(1);
		input.add(5);
		//2415 
		//output 5142
		
		System.out.println(reverseAList(input));
	}

	private List<Integer> reverseAList(List<Integer> input) {
		/*
		 * declare a output list of integers
		 * Iterate the list from end
		 * and add it to the output list from 0 to its size
		 * return output list
		 */
		List<Integer> output = new ArrayList<Integer>();
		for (int i = input.size()-1; i >=0 ; i--) {
			output.add(input.get(i));
		}
		
		return output;
	}
	
	private List<Integer> reverseTwoPointer(List<Integer> input){
		int left = 0, right = input.size()-1;
		while (left<right) {
			//swapp left and right values
			int temp = input.get(left);
			input.set(left, input.get(right));
			input.set(right, temp);
		}
		return input;
	}

}
