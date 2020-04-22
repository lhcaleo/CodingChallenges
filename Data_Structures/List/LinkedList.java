public class LinkedList 
{
	Node head;
	
	public void insert(int data) 
	{
		Node node = new Node(data);
		
		if (head == null)
			head = node;
		else 
		{
			Node n = head;
			while (n.next != null) 
			{
				n = n.next;
			}
			n.next = node;
		}
	}
	
	public void insertAtStart(int data) 
	{
		Node node = new Node(data);
		
		node.next = head;
		head = node;
	}
	
	public void insertAt(int index, int data)
	{	
		if (index == 0) 
		{
			insertAtStart(data);
			return;
		}
		Node node = new Node(data);
		
		Node n = head;
		
		for (int i = 0; i < index - 1; i++) 
		{
			n = n.next;
		}
		node.next = n.next;
		n.next = node;
	}
	
	public void deleteAt(int index) 
	{
		if (index < 0 || index >= this.size()) {
			System.out.println("illegal index");
			return;
		}
		
		if (index == 0)
		{
			head = head.next;
		} else {
			Node n = head;
			for (int i = 0; i < index - 1; i++) 
			{
				n = n.next;
			}
			Node delete = n.next;
			n.next = delete.next;
			System.out.println("-> delete " + delete.data + ". ");
			delete = null;
		}
	}
	
	public int size() 
	{
		int length = 1;
		Node node = head;
		
		while (node.next != null) {
			length++;
			node = node.next;
		}
		return length++;
	}
	
	public void show() 
	{
		Node node = head;
		
		while (node.next != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.print(node.data + " ");
	}
}
