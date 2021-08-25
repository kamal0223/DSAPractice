package onspot;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DesignAddSearch {
	
	@Test
	public void test1() {
		DesignAddSearch obj = new DesignAddSearch();
		obj.addWord("at");
		obj.addWord("and");
		obj.addWord("an");
		obj.addWord("add");
		obj.print(ali);
		//System.out.println(obj.search("pad"));
		System.out.println(obj.search("a"));
		System.out.println(obj.search(".at"));
		System.out.println("----------------------add below and search");
		obj.addWord("bat");
		System.out.println(obj.search(".at"));
		System.out.println(obj.search("an."));
		System.out.println(obj.search("a.d."));
		System.out.println(obj.search("b."));
		System.out.println(obj.search("a.d"));
		System.out.println(obj.search("."));
		
		//["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
		//		[[],["at"],["and"],["an"],["add"]                 ,["a"],  [".at"],  ["bat"],  [".at"], ["an."], ["a.d."],["b."],  ["a.d"],  ["."]]
		
	}
	
	List<String> ali;
    public DesignAddSearch() {
        this.ali = new ArrayList<String>();
    }
    
    public void addWord(String word) {
        ali.add(word);
    }
    
    public void print(List<String> ali) {
        System.out.println(ali);
    }
    
    public boolean search(String word) {
        //.ad  b..
        //iterate the arraylist and pick each string
        //character by character if . is found in input then move to next char
        //or if any other letter is found check both char are matching
        //get words from arraylis
  
    	if(word.length()>0 && ali.size() == 0) return false;
        char[] charArray = word.toCharArray();
        for(String each:ali){
            if(each.length()!=word.length()) continue;
        for(int i = 0;i<charArray.length;i++){
            if(each.charAt(i) != charArray[i] && charArray[i] != '.')
            	//when last element comes then return false else for other elements break
            	return false;
        }
            return true;
        }
        return false;
    }

}
