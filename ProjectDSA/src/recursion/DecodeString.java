package recursion;

import org.junit.Test;

public class DecodeString {
	
	 /*
	    * Input: s = "3[a]2[bc]" -> a]2[bc]->bc] bcbc
	    Output: "aaabcbc”3[a]bcbc
	    * */

	    @Test
	    public void test1() {
	        String s = "3[a]2[bc]";
	        String output = "aaabcbcd";
	        System.out.println(decodeUsingRecursion(s));
	    }

	    @Test
	    public void test2() {
	        String s = "3[a2[c]]";
	        			//3[acc]
	        String output = "accaccacc";
	    	System.out.println(decodeUsingRecursion(s));
	        
	    }

	    /*
	    * Breaking point - When there are no more closing brackets
	If closing bracket is found, get the index of last opening bracket before closing bracket and the substring between that
	 Check for number before opening bracket and iterate the number of times as digit and concatenate the substring
		put the concatenated string at the index of opening bracket -1
	    *
	    *
	    *
	    * */
	    private String decodeUsingRecursion(String s) {
	        StringBuilder str = new StringBuilder(s);
	        if(str.indexOf("]")==-1) return "";
	        int closingIndex = str.lastIndexOf("]");
	        int openingIndex = str.lastIndexOf("[");
	        int digit;
	        if(!Character.isDigit(str.charAt(openingIndex-1)))  digit = 1;
	        else digit = str.charAt(openingIndex-1);
	        String subString = str.substring(openingIndex+1,closingIndex);
	        while(digit>1) {
	        	//concatenate the substring with recursive call
	            subString = subString.concat(subString);
	            digit--;
	        }
	        //append the subString to stringbuilder
	        str.insert(openingIndex-1, subString);
	      //delete the char at position of digits to index of ] brackets
	        str.delete(openingIndex-1, closingIndex+1);
	        return decodeUsingRecursion(str.append(subString).toString());
	        
	    }
	    
	    private void appender() {
	    	String input= "jamie";
	    	StringBuilder sb = new StringBuilder(input);
	    	sb.delete(input.length()-3, input.length());
	    	//sb.insert(input.length()-2, "anderson");
	    	sb.append("anderson");
	    	System.out.println(sb.toString());
	    }

}
