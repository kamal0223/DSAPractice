package palo.alto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class shortestFragment {
	
	@Test
	public void test1() {
		String s = "azABaabza";
		System.out.println(findBalancedFragment(s)); //5
	}
	
	@Test
	public void test2() {
		String s = "TacoCat";
		System.out.println(findBalancedFragment(s)); //-1
	}
	
	@Test
	public void test3() {
		String s = "AcZCbaBz";
		System.out.println(findBalancedFragment(s)); //8
	}
	
	 
	 public int shortestFragment(String s){
		 for(int k=1;k<=s.length();k++){
	            for(int i=0;i<s.length()-k+1;i++){
	                Set<Character> lower = new HashSet<>();
	                Set<Character> upper = new HashSet<>();
	                String fragment = s.substring(i,i+k);
	                char[] tempCharArr = fragment.toCharArray();
	                for(char ch : tempCharArr){
	                if(Character.isLowerCase(ch))
	                    lower.add(ch);
	                else
	                    upper.add(ch);
	                }
	                if(containsAllElements(lower, upper) && containsAllElements(upper, lower)) return fragment.length();
	            }            
	        }
	        return -1;   
	    }
	 
	 static boolean containsAllElements(Set<Character> first, Set<Character> second){
	        Set<Character> lower1 = new HashSet<>();
	        Set<Character> lower2 = new HashSet<>();
	        first.forEach((e) -> {
	            lower1.add(Character.toLowerCase(e));
	        });
	       second.forEach((e) -> {
	            lower2.add(Character.toLowerCase(e));
	        });
	        return lower1.containsAll(lower2);
	    }
	 
	 private int findBalancedFragment(String s) {
	        HashSet<Character>lowerSet=new HashSet<>();
	        HashSet<Character>upperSet=new HashSet<>();
	        String substring = s.substring(0, 0);
	        s.contains('c');
	        
	        char[] chars = s.toCharArray();
	        for (int i=0;i<chars.length;i++){
	            if((int)chars[i]>=97 && (int)chars[i]<=122) lowerSet.add(chars[i]);
	            else upperSet.add(chars[i]);
	        }
	        int left=0, right=0, length=0;
	        String temp="";
	        while (right<s.length()){
	            if(lowerSet.contains(Character.toLowerCase(s.charAt(right)))&& upperSet.contains(Character.toUpperCase(s.charAt(right)))){
	                temp+=s.charAt(right);
	                length=Math.max(length,right-left+1);
	                right++;
	            }else{
	               left=left+2;
	               right=left;
	               temp="";
	            }
	        }
	        return length==1?-1:length;
	    }

}
