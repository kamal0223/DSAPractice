package flash.twopointer;

import org.junit.Test;

import junit.framework.Assert;

//https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class ReverseWordsString_557 {

	@Test
	public void test1() {
		String s = "Let's take LeetCode contest";
		Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", reverseEachWord(s));
	}
	
	@Test
	public void test2() {
		String s = "Let's";
		Assert.assertEquals("s'teL", reverseEachWord(s));
	}
	
	
	
	//in place technique using this techinque we are not creating a extra string or builder
	/*
	 * convert the string to char array 
	 * declare a start int as 0  and wordEnd int as 0
	 * traverse the character array till the end of array
	 * 	  iterate till char at wordEnd not equal to space and also less than lenght
	 * 	  now we got wordEnd at first space. so wordEnd-1 gives last index of first word
	 * 	  reverse the substring of start index and wordEnd index
	 * return the string by passing chararray as constructor params
	 */

	private String reverseEachWordOptimized(String s) {
		char[] charArray = s.toCharArray();
		int start  = 0, wordEnd = 0;
		for(int i = 0;i<charArray.length;i++) {
			if(charArray[i] ==' ') {
				reverse(charArray,start,wordEnd-1);
				start = wordEnd+1;
			}
			wordEnd++;
		}
		reverse(charArray,start,wordEnd-1);
		String output = new String(charArray);
	    return output;
	}

	private String reverseEachWord(String s) {
		StringBuilder sb = new StringBuilder();
        String[] arrStr = s.split("\\s");
        for(int i = 0;i<arrStr.length;i++){
            char[] charArr = arrStr[i].toCharArray();
            int left = 0, right = charArr.length-1;
            reverse(charArr, left, right);
            sb.append(charArr);
            sb.append(" ");
        }
        return sb.toString().trim();
	}
	
	private String reverseEachUsingString(String s) {
		//initialize String output
        //split the word to get each word from string
        //traverse through the splitted array to get each word
        //swap each letters in the words using 2 pointer and add it to a outpu string
        //When adding each word to the output give spaces
        
		String[] splitted = s.split(" ");
        String output = "";
        for(int i = 0;i<splitted.length;i++){
        	char[] currentChar = splitted[i].toCharArray();
            int left = 0, right = currentChar.length-1;
            while(left<right){
                char temp = currentChar[left];
                currentChar[left++] = currentChar[right];
                currentChar[right--] = temp;
            }
            //System.out.println(Arrays.toString(currentChar));
            output+= String.valueOf(currentChar)+" ";     
        }
        return output.trim();
	}


	private void reverse(char[] charArr, int start, int wordEnd) {
		while(start<wordEnd){
            char temp = charArr[start];
            charArr[start++] = charArr[wordEnd];
            charArr[wordEnd--] = temp;
        }
		
	}
	
}
