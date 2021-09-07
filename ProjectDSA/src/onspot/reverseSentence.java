package onspot;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

/*
 Revere the given sentence by its word
 input - > today is a beautiful day
 output-> day beautiful a is today
 
 input -> string
 output -> String
 */
public class reverseSentence {
	
	@Test
	public void test1() {
		String input = "today is a beautiful day";
		Assert.assertEquals("day beautiful a is today", reverseSentence(input));
	}
	
	@Test
	public void test2() {
		String input = "today";
		Assert.assertEquals("today", reverseSentence(input));
	}
	
	@Test
	public void test3() {
		String input = "today  is a beautiful  day";
		Assert.assertEquals("day beautiful a is today", reverseSentence(input));
	}

	/*
	 * declare a string builder
	 * Split the string based on the spaces and form a string array
	 * iterate the string array from the end
	 * trim each string
	 * append each string to the strigbuilder with spaces
	 * convert the string builder to string
	 */
	private String reverseSentence(String input) {
		String[] split = input.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = (split.length)-1;i>=0;i--) {
			sb.append(split[i].trim()+" ");
		}
		return sb.toString();
	}
	
	/*
	 * 
	 */
	
}
