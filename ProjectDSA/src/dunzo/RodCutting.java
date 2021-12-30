package dunzo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class RodCutting {
	
	@Test
	public void test1() {
		List<Integer> lt = Arrays.asList(1,1,3,4);
		System.out.println(rodOffCut2(lt));
	}

	//declare a output list
	//add the length of input list to outputlist
	//sort the input list and get smallest
	//pick the smallest length rod
	//remove that rod including duplicates from the list
	//substract the smallest rod in the new input list elements
	//find the size of this list after removal add it to output list
	
	private List<Integer> rodOffCut(List<Integer> lt) {
		List<Integer> output = new ArrayList<Integer>();
		Collections.sort(lt);
		output.add(lt.size());
		for (int i = 1; i < lt.size(); i++) {
			if(lt.get(i) != lt.get(i-1)) {
				output.add(lt.size()-i);
			}
		}
		return output;
	}

	private List<Integer> rodOffCut2(List<Integer> lengths) {
		int count, len=lengths.size();
        HashMap<Integer,Integer> countMap=new HashMap<Integer,Integer>();
        TreeSet<Integer> sticks=new TreeSet<Integer>();
        for(Integer stick: lengths) {
            count=countMap.getOrDefault(stick,0);
            countMap.put(stick,++count);
            sticks.add(stick);
        }
        List<Integer> result = new ArrayList<Integer>();
        count=0;
        for(Integer stick:sticks) {
            result.add(len-count);
            count+=countMap.get(stick);
        }
        return result;
	}
}
