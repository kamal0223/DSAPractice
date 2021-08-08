package LinkedList;

import org.junit.Test;

import LinkedList.MergeTwoLinkedList.Node;

public class CountNodeLinkedList {
	
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
	
	public int countAllNodes(Node head) {
		int count = 0;
		while (head!=null) {
			count++;
			head = head.next;
		}
		return count;
	}
	
	public boolean removeNode(int toRemoveValue, Node head) {
		Node current = head;
		boolean isRemoved = false;
		while(current!=null) {
			if (current.next.value == toRemoveValue) {
				current.next = current.next.next;
				isRemoved = true;
				break;
			}
			current = current.next;
		}
		return isRemoved;
	}
	
	public boolean addNodeAfterNode(int nodePosition, Node head, int value) {
		Node current = head;
		boolean isAdded = false;
		int nodeCount = 0;
		Node newNode = new Node(value);
		while (current!=null) {
			nodeCount++;
			if(nodeCount == nodePosition-1) {
				Node temp  = current.next;
				current.next = newNode;
				newNode.next = temp;
				isAdded = true;
				break;
			}
			current = current.next;
		}
		return isAdded;
	}
	
	public Node addAtFirst(Node head, int value) {
		
		
		//create a Node with value
		Node firstNode = new Node(value);
		firstNode.next = head;
		return firstNode;
	}
	
	public void printAllNodes(Node head) {
		
		//iterate the node till it becomes null
		while(head!=null) {
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	public Node reversesinglyLinkedList(Node head) {
		//create an empty node
		//iterate through the linked list till it becomes null
		//get the first node and make its next to null and add it to an empty node
		//get the second node and add it to node 1 as first node
		//continue this till the node become null
		
		Node current = head;
		Node reversed = null;
		Node next = null;
		while(current!=null) {
			//get the next node of current and assign to next
			next = current.next;
			//on first iterate make the current to hold only first node and rest as null
			//from next iteration current add the first element of current to reversed node
			//current will act as temp variable to hold reversed
			current.next = reversed;
			reversed = current;
			//move the current node to next and next and next so on till null
			current = next;
		}
		return reversed;
	}
	
	@Test
    public void test1() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        printAllNodes(reversesinglyLinkedList(head));
        //head = addAtFirst(head,0);
        //System.out.println(removeNode(3,head));
        //System.out.println(addNodeAfterNode(3,head,1));
        //printAllNodes(head);
    }

}
