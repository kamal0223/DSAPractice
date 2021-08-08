package LinkedList;

import org.junit.Test;

import LinkedList.MergeTwoLinkedList.Node;

public class CountNodeLinkedList {
	
	public class ListNode{
        int value;
        ListNode next;
        ListNode(int key){
            this.value = key;
            next = null;
        }

        ListNode(){
            next = null;
        }
    }
	
	public int countAllNodes(ListNode head) {
		int count = 0;
		while (head!=null) {
			count++;
			head = head.next;
		}
		return count;
	}
	
	public boolean removeNode(int toRemoveValue, ListNode head) {
		ListNode current = head;
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
	
	public boolean addNodeAfterNode(int nodePosition, ListNode head, int value) {
		ListNode current = head;
		boolean isAdded = false;
		int nodeCount = 0;
		ListNode newNode = new ListNode(value);
		while (current!=null) {
			nodeCount++;
			if(nodeCount == nodePosition-1) {
				ListNode temp  = current.next;
				current.next = newNode;
				newNode.next = temp;
				isAdded = true;
				break;
			}
			current = current.next;
		}
		return isAdded;
	}
	
	public ListNode addAtFirst(ListNode head, int value) {
		
		
		//create a Node with value
		ListNode firstNode = new ListNode(value);
		firstNode.next = head;
		return firstNode;
	}
	
	public void printAllNodes(ListNode head) {
		
		//iterate the node till it becomes null
		while(head!=null) {
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	public ListNode reversesinglyLinkedList(ListNode head) {
		//create an empty node
		//iterate through the linked list till it becomes null
		//get the first node and make its next to null and add it to an empty node
		//get the second node and add it to node 1 as first node
		//continue this till the node become null
		
		ListNode current = head;
		ListNode reversed = null;
		ListNode next = null;
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        printAllNodes(reversesinglyLinkedList(head));
        //head = addAtFirst(head,0);
        //System.out.println(removeNode(3,head));
        //System.out.println(addNodeAfterNode(3,head,1));
        //printAllNodes(head);
    }

}
