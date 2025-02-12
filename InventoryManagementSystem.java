class Node {
   String itemName; 
   int itemId;   
   int quantity;    
   double price;    
   Node next;       

 
   public Node(String itemName, int itemId, int quantity, double price) {
       this.itemName = itemName;
       this.itemId = itemId;
       this.quantity = quantity;
       this.price = price;
       this.next = null; 
   }
}

class Inventory {
   Node head; 

  
   public Inventory() {
       head = null;
   }

   // Add an item at the beginning of the list
   public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
       Node newItem = new Node(itemName, itemId, quantity, price);
       newItem.next = head;
       head = newItem;
   }

   // Add an item at the end of the list
   public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
       Node newItem = new Node(itemName, itemId, quantity, price);
       if (head == null) {
           head = newItem;
           return;
       }
       Node current = head;
       while (current.next != null) {
           current = current.next;
       }
       current.next = newItem;
   }

   // Add an item at a specific position in the list
   public void addItemAtPosition(int position, String itemName, int itemId, int quantity, double price) {
       if (position < 1) {
           System.out.println("Invalid position");
           return;
       }
       Node newItem = new Node(itemName, itemId, quantity, price);
       if (position == 1) {
           newItem.next = head;
           head = newItem;
           return;
       }
       Node current = head;
       int currentPosition = 1;
       while (current != null && currentPosition < position - 1) {
           current = current.next;
           currentPosition++;
       }
       if (current == null) {
           System.out.println("Position exceeds the size of the list");
       } else {
           newItem.next = current.next;
           current.next = newItem;
       }
   }

   // Remove an item by Item ID
   public void removeItemById(int itemId) {
       if (head == null) {
           System.out.println("Inventory is empty");
           return;
       }
       if (head.itemId == itemId) {
           head = head.next;
           return;
       }
       Node current = head;
       while (current.next != null && current.next.itemId != itemId) {
           current = current.next;
       }
       if (current.next == null) {
           System.out.println("Item with ID " + itemId + " not found");
       } else {
           current.next = current.next.next;
       }
   }

   // Update the quantity of an item by Item ID
   public void updateItemQuantity(int itemId, int newQuantity) {
       Node current = head;
       while (current != null) {
           if (current.itemId == itemId) {
               current.quantity = newQuantity;
               return;
           }
           current = current.next;
       }
       System.out.println("Item with ID " + itemId + " not found");
   }

   // Search for an item by Item ID or Item Name
   public void searchItem(String searchQuery) {
       Node current = head;
       while (current != null) {
           if (current.itemName.equalsIgnoreCase(searchQuery) || Integer.toString(current.itemId).equals(searchQuery)) {
               System.out.println("Item found: " + current.itemName + ", ID: " + current.itemId + ", Quantity: " + current.quantity + ", Price: " + current.price);
               return;
           }
           current = current.next;
       }
       System.out.println("Item not found");
   }

   // Calculate and display the total value of inventory
   public void displayTotalValue() {
       double totalValue = 0;
       Node current = head;
       while (current != null) {
           totalValue += current.quantity * current.price;
           current = current.next;
       }
       System.out.println("Total value of inventory: $" + totalValue);
   }

   // Merge Sort to sort the inventory by Item Name or Price
   public Node mergeSort(Node head, boolean sortByName) {
       if (head == null || head.next == null) {
           return head;
       }
       Node middle = getMiddle(head);
       Node nextOfMiddle = middle.next;
       middle.next = null;

       Node left = mergeSort(head, sortByName);
       Node right = mergeSort(nextOfMiddle, sortByName);

       return merge(left, right, sortByName);
   }

   private Node merge(Node left, Node right, boolean sortByName) {
       if (left == null) return right;
       if (right == null) return left;

       if ((sortByName && left.itemName.compareTo(right.itemName) < 0) || (!sortByName && left.price < right.price)) {
           left.next = merge(left.next, right, sortByName);
           return left;
       } else {
           right.next = merge(left, right.next, sortByName);
           return right;
       }
   }

   private Node getMiddle(Node head) {
       if (head == null) return head;

       Node slow = head;
       Node fast = head;

       while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
       }

       return slow;
   }

   // Display all items in the inventory
   public void displayItems() {
       if (head == null) {
           System.out.println("Inventory is empty");
           return;
       }
       Node current = head;
       while (current != null) {
           System.out.println("Item: " + current.itemName + ", ID: " + current.itemId + ", Quantity: " + current.quantity + ", Price: " + current.price);
           current = current.next;
       }
   }
}

public class InventoryManagementSystem {
   public static void main(String[] args) {
       Inventory inventory = new Inventory();

       inventory.addItemAtBeginning("Apple", 1, 100, 0.5);
       inventory.addItemAtEnd("Banana", 2, 150, 0.3);
       inventory.addItemAtEnd("Orange", 3, 200, 0.6);
       inventory.addItemAtPosition(2, "Mango", 4, 50, 0.8);

       System.out.println("All items in the inventory:");
       inventory.displayItems();

       System.out.println("Search for item with ID 2:");
       inventory.searchItem("2");

       System.out.println("Search for item with name 'Apple':");
       inventory.searchItem("Apple");

       System.out.println("Update quantity of item with ID 3:");
       inventory.updateItemQuantity(3, 250);
       inventory.displayItems();

       System.out.println("Remove item with ID 2:");
       inventory.removeItemById(2);
       inventory.displayItems();

       System.out.println("Display total inventory value:");
       inventory.displayTotalValue();

       System.out.println("Sorting by Item Name:");
       inventory.head = inventory.mergeSort(inventory.head, true);
       inventory.displayItems();

       System.out.println("Sorting by Price:");
       inventory.head = inventory.mergeSort(inventory.head, false);
       inventory.displayItems();
   }
}