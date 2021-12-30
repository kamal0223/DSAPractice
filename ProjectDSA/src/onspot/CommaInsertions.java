package onspot;

import org.junit.Test;

import junit.framework.Assert;

public class CommaInsertions {
	
	@Test
	public void test1() {
		String input = "pray jump spy. jump spy, jump. spy ally now ally.";
		Assert.assertEquals("pray, jump spy. jump spy, jump. spy, ally now, ally.", commaInsertions(input));
	}

	
	/*
	 * , word - If a word in the string is after a comma. insert , before every word

		word, - If a word in the string is before a comma . insert , after word

		 If spy, - remove the , after word and store in a string1
		  check the string1 is duplicated. yes then replace the "spy" with "spy,"

		 If , Jump - remove the , and space and . and store in a string	
	       check the string1 is duplicated. yes then replace the " Jump" with ", Jump"
	 */
	private String commaInsertions(String input) {
		//insert all words in a map
		
		
		return "";
		
	}
	
	

}
