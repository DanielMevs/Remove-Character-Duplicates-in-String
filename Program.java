import java.util.Scanner;

public class Program {
	
	public static class LinkedList {
		public char value;
		public LinkedList next;
		

		public LinkedList() {
			this.value = 0;
			this.next = null;
		}
		
	}
	public static LinkedList add(char data) {
		LinkedList newLinkedList = new LinkedList();
		newLinkedList.value = data;
		newLinkedList.next = null;
		return newLinkedList;
	}
	public static LinkedList stringToLinkedList(String inputString, LinkedList head) {
		if(inputString.length() == 0) {
			System.out.println("Empty String");
			return null;
		}
		else {
			head = add(inputString.charAt(0));
			LinkedList currentLL = head;
			for (int i = 1; i < inputString.length(); i++) {
				currentLL.next = add(inputString.charAt(i));
				currentLL = currentLL.next;
				
			}
			return head;
			
		}
		
	}
	public static LinkedList removeDuplicates(LinkedList linkedList) {
		LinkedList currentNode = linkedList;
		while(currentNode != null) {
			LinkedList nextDistinctNode = currentNode.next;
			while(nextDistinctNode != null && nextDistinctNode.value == currentNode.value) {
				nextDistinctNode = nextDistinctNode.next;
			}
			currentNode.next = nextDistinctNode;
			System.out.print(currentNode.value);
			currentNode = nextDistinctNode;
			if(currentNode != null) {
				System.out.print(", ");
			}
			
		}
		return linkedList;
	}
	

	


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char interested = 'y';
		while(interested == 'y' || interested == 'Y') {
			System.out.println("Enter a string: ");
			String text = input.nextLine();
			LinkedList head = null;
			head = stringToLinkedList(text, head);
			head = removeDuplicates(head);
			System.out.println("\nWould you be interested in another simulation? "
					+ "Type y or Y for yes or any other key for no.");
			interested = input.next().charAt(0);
		}
	}

}
