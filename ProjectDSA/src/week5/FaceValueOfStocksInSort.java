package week5;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FaceValueOfStocksInSort {

	public static void main(String[] args) {
		Map<String,Integer> hm = new HashMap<String,Integer>();
		hm.put("ITC", 5);
		hm.put("HUL", 10);
		hm.put("HCL", 2);
		hm.put("BPCL", 3);
		
		Collection<Integer> faceValues = hm.values();
		Integer maxFaceValue = Collections.max(faceValues);
		String maxKey = hm.entrySet().stream().filter(n->n.getValue().equals(maxFaceValue)).findFirst().get().getKey();
		System.out.println(maxKey+":"+maxFaceValue);
		Integer minFaceValue1 = Collections.min(faceValues);
		String minKey1 = hm.entrySet().stream().filter(n->n.getValue().equals(minFaceValue1)).findFirst().get().getKey();
		System.out.println(minKey1+":"+minFaceValue1);
		//loop till the map becomes empty
		//stream the map hm and get the min face value entry and print the map entry
		//delete that entry
		//continue the loop t
		while(!hm.isEmpty()) {
			int minFaceValue = Collections.min(hm.values());
			String minKey = hm.entrySet().stream().filter(n->n.getValue().equals(minFaceValue)).findFirst().get().getKey();
			System.out.println(minKey+":"+minFaceValue);
			hm.remove(minKey);
		}
	}
}
