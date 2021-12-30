package onspot;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class ProductCheck {
	
	
	@Test
	public void test1() {
		String s = "{[]}";
		Assert.assertTrue(isValid(s));
	}
	
	
	public boolean isValid(String s) {
        
        
        
	       Stack<Character> stack = new Stack<Character>();
	        for(int i = 0;i<s.length();i++){
	            //check if the stack is not emtpy and incoming element is a closing
	                //yes - pop the stack and check if is a pair
	                //no - if not a pair return false
	            //no - push the element to stack
	            
	            if(!stack.isEmpty()){
	                if(s.charAt(i) == '}'){
	                    if(!(stack.pop() == '{')) return false;
	                    else stack.pop();
	                }
	                else if(s.charAt(i) == ')'){
	                     if(!(stack.pop() == '(')) return false;
	                     else stack.pop();
	                }
	                else if(s.charAt(i) == ']'){
	                     if(!(stack.pop() == '[')) return false;
	                     else stack.pop();
	                }
	            }
	            stack.push(s.charAt(i));
	            
	        }
	        return true;    
	    }

}
