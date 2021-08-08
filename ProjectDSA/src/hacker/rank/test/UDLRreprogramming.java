package hacker.rank.test;

import org.junit.Test;

import junit.framework.Assert;

/*you can travel in four direction U, D, L, R. Find the number of deletions requrired to travel in optimised path.
 * URRDL - U,D R,L can be deleted 
 * output - 1
 */
public class UDLRreprogramming {
	
	@Test
	public void test1() {
		String input = "URRDL";
		Assert.assertEquals(4, optimisedPathDeletion(input));
	}
	
	@Test
	public void test2() {
		String input = "U";
		Assert.assertEquals(0, optimisedPathDeletion(input));
	}
	
	@Test
	public void test3() {
		String input = "LLL";
		Assert.assertEquals(0, optimisedPathDeletion(input));
	}
	
	@Test
	public void test4() {
		String input = "UD";
		Assert.assertEquals(2, optimisedPathDeletion(input));
	}

	private int optimisedPathDeletion(String input) {
		//create four variables uCount, rCount, lCount, dCount
		//declare an int noOfDeletions
		//iterate the input and count the number of occurence of each variable in input
		//shortest distance is absolute diff of U and D + absolute diff of R and L
		//no of deletions is equal to input lenght - shortestDistance
		//return noOfDeletions
		
		int uCount = 0, rCount = 0, lCount = 0, dCount = 0;
		int noOfDeletions = 0;
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == 'U') uCount++;
			if(input.charAt(i) == 'D') dCount++;
			if(input.charAt(i) == 'L') lCount++;
			if(input.charAt(i) == 'R') rCount++;
			
			noOfDeletions = input.length() - ( Math.abs(uCount-dCount) + Math.abs(rCount-lCount) );
		}
		System.out.println(noOfDeletions);
		return noOfDeletions;
	}

}
