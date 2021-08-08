package LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ReverseLinkedList {

	public class Node{

		int value;
		public Node next;

		public Node(int key){
			this.value = key;
			next = null;
		}

	}
	public Node addNode(int key) {
		return new Node(key);
	}

	public void printAllNodes(Node node) {
		while(node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}
	// reverse the node
	public Node reverseNode(Node node) {
		Node curr = node, prev = null, next = null;
		while(curr != null) {
			next = curr.next;  //box 14 6 23, box 6 23, box 23, null
			curr.next = prev;  //null, 10 null, box 14 6 23, box 6 23
			prev = curr;       //10 null, box 14 6 23, box 6 23, box 23
			curr = next;       //14 6 23, box 6 23, box 23, null
		}
		return prev;
	}

	//odd and even
	public Node oddEvenList(Node node) {

		if (node == null || node.next == null)
			return node;
		Node odd = node, even = node.next, allEven = even;
		
		// Hold the odd numbers separate and point to node
		// Hold the even numbers and point to allEven
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = allEven; // append allEven to odd thus to node 
		return node;
	}
				
		/*Node curr = node, prev = null, next = null;
		while(curr != null) {
			next = curr.next;  //box 14 6 23, box 6 23, box 23, null
			curr.next = prev;  //null, 10 null, box 14 6 23, box 6 23
			prev = curr;       //10 null, box 14 6 23, box 6 23, box 23
			curr = next;       //14 6 23, box 6 23, box 23, null
		}*/
		//return prev;
	//}
	
	public static Node condense(Node node) {
        //traverse till head.next becomes null
        //check if the value of current node is contained in hashset
        // if no add the value of cuurent node to hashset
        //  get the head.next as prev
        // if yes then map prev to head.next
        
        Node result = node;
        Node prev = null;
        Set<Integer> hs = new HashSet<Integer>();
        while(result.next!=null){
            if(!hs.contains(result.value)){
                hs.add(result.value);
                prev = result.next;
            }else {
                result.next = prev;
            }
            result = result.next;
        }
        return result;
    }
	
	@Test
	public void test1() {
		Node head = addNode(10);
		head.next = addNode(14);
		head.next.next = addNode(10);
		head.next.next.next = addNode(23);
	
		Node reverseNode = condense(head);
		printAllNodes(reverseNode);
		
	}



}
