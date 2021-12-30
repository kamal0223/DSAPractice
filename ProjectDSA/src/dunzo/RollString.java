package dunzo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RollString {

	@Test
	public void test1() {
		String s = "abc";
		List<String> operations = new ArrayList<String>();
		operations.add("0 0 L");
		operations.add("2 2 L");
		operations.add("0 2 R");
		System.out.println(rollingStr(s, operations));
	}

	//create an asciiarry of 51 char
	//97 to 122+97....122

	public String rollingString(String s, List<String> operations) {
		//get the substrin gof operations from list.get(0) to list.get(1)
		//iterate the operations

		for(int i = 0;i<operations.size();i++) {
			String[] split = operations.get(i).split("\\s+");
			String substring = s.substring(Integer.parseInt(split[0]), Integer.parseInt(split[1])+1);
			s = roll_character(substring, split[2]);
		}

		return s;
	}

	public String roll_character(String str, String side) {
		String output = "";
		char[] charArray = str.toCharArray();
		for(int i = 0;i<charArray.length;i++) {
			//roll = roll % 26;
			int character = charArray[0] - 'a'; 
			if(side.equals("R")) {
				char a = (char) ('a' + (character + 1) % 26);
				output += a+"";
			}else {
				char a = (char) ('a' + (character + 25) % 26);  //a  //0 //z //b //1
				output += a+"";
			}
			//0  a to y
			//lenght-2 = 24
			//roll 2
		}
		return output;
	}

	private String rollingStr(String s, List<String> operations) {

		StringBuffer rollString=new StringBuffer(s);
		for (int i = 0; i < operations.size(); i++) {
			String str[]=operations.get(i).split("\\s+");
			for (int j = Integer.parseInt(str[0]); j <=Integer.parseInt(str[1]); j++) {
				if(str[2].equalsIgnoreCase("L")){
					char temp=rollString.charAt(j);
					if(temp=='a'){
						temp='z';
					}else{
						temp--;
					}
					rollString.setCharAt(j, temp);
				}else{
					char temp=rollString.charAt(j);
					if(temp=='z'){
						temp='a';
					}else{
						temp++;
					}
					rollString.setCharAt(j, temp);
				}
			}
		}
		return rollString.toString();

	}
}
