package hacker.rank.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import LinkedList.MergeTwoLinkedList.Node;

public class condenseLinkedList {
	
	public class Node{
        int value;
        Node next;
        Node(int key){
            this.value = key;
            next = null;
        }

        Node(){
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
    
    public Node condenseList(Node head) {
    	
    	Node outputNode = new Node();
    	Node temp = outputNode;
    	Set<Integer> set = new HashSet<Integer>();
    	while (head!=null) {
			if(set.contains(head.value)) {
				head = head.next;
				temp.next = null;
				
			}else {
				set.add(head.value);
				temp.next = head;
				head = head.next;
				temp = temp.next;
			}
		}
    	
		return outputNode.next;
    	
    }
    
    @Test
    public void test1() {
        Node head = addNode(10); 
        head.next = addNode(2);  
        head.next.next = addNode(10);  
        head.next.next.next = addNode(4); //temp
        printAllNodes(condenseList(head));             //head
    }

}
