package streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Employee {
	//find all employees who has age greater than 30
	
	@Test
	public void test1() {
		Map<String, Integer> hm = new HashMap<String,Integer>();
		hm.put("Ram", 25);
		hm.put("Ganesh", 34);
		hm.put("Ravi", 25);
		hm.put("Teja", 31);
		hm.put("Alastair", 30);
		System.out.println(findAgeCount(hm));
		
	}

	private int findAgeCount(Map<String, Integer> hm) {
		int count = 0;
		hm.entrySet().stream().filter(emp -> emp.getValue()>30).forEach(emp -> System.out.println(emp.getKey()));
		
		int[] num = {1,2,3,4,5};
		Arrays.fill(num, 0, 2, 0);
		System.out.println(Arrays.toString(num));
		
		return 0;
		
	}
	
	

}
