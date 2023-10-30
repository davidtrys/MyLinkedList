import org.w3c.dom.Node;

public class MyLinkedList<E extends Comparable<E>> {
   private Node<E> head, tail;
   private int size = 0; // Number of elements in the list

   public MyLinkedList() {
      head = tail = null;
      size = 0;
   }

   /** Create a list from an array of objects */
   public MyLinkedList(E[] objects) {

      // Establish head as null
      head = null;

      // Establish size as 0
      size = 0;

      // Iterate through array and add each element to list
      for (int i = 0; i < objects.length; i++) {

         // Add object at index i to end of list
         addLast(objects[i]);
      }
   }

   /** Return the head element in the list */
   public E getFirst() {
      if (size == 0) {
         return null;
      } else {
         return head.element;
      }
   }

   /** Return the last element in the list */
   public E getLast() {
      if (size == 0) {
         return null;
      } else {
         return tail.element;
      }
   }

   /** Add an element to the beginning of the list */
   public void addFirst(E e) {
      Node<E> newNode = new Node<>(e); // Create a new node
      newNode.next = head; // link the new node with the head
      head = newNode; // head points to the new node
      size++; // Increase list size

      if (tail == null) // the new node is the only node in list
         tail = head;
   }

   /** Add an element to the end of the list */
   public void addLast(E e) {
      Node<E> newNode = new Node<>(e); // Create a new for element e

      if (tail == null) {
         head = tail = newNode; // The new node is the only node in list
      } else {
         tail.next = newNode; // Link the new with the last node
         tail = newNode; // tail now points to the last node
      }

      size++; // Increase size
   }

   public void add(int index, E e) {
      if (index == 0) {
         addFirst(e);
      } else if (index >= size) {
         addLast(e);
      } else {
         Node<E> current = head;
         for (int i = 1; i < index; i++) {
            current = current.next;
         }
         Node<E> temp = current.next;
         current.next = new Node<>(e);
         (current.next).next = temp;
         size++;
      }
   }

   /**
    * Remove the head node and
    * return the object that is contained in the removed node.
    */
   public E removeFirst() {
      if (size == 0) {
         return null;
      } else {
         E temp = head.element;
         head = head.next;
         size--;
         if (head == null) {
            tail = null;
         }
         return temp;
      }
   }

   /**
    * Remove the last node and
    * return the object that is contained in the removed node.
    */
   public E removeLast() {
      if (size == 0) {
         return null;
      } else if (size == 1) {
         E temp = head.element;
         head = tail = null;
         size = 0;
         return temp;
      } else {
         Node<E> current = head;

         for (int i = 0; i < size - 2; i++) {
            current = current.next;
         }

         E temp = tail.element;
         tail = current;
         tail.next = null;
         size--;
         return temp;
      }
   }

   /** Return the length of this list using recursion */
   public int getLength() {
      return getLength(head);
   }

   public int getLength(Node<E> curr) {
      if (curr == null)
         return 0;
      else
         return 1 + getLength(curr.next);
   }

   /* Override toString() to return elements in the list in [] separated by , */
   public String toString() {
      StringBuilder result = new StringBuilder("[");

      Node<E> current = head;
      for (int i = 0; i < size; i++) {
         result.append(current.element);
         current = current.next;
         if (current != null) {
            result.append(", "); // Separate two elements with a comma
         } else {
            result.append("]"); // Insert the closing ] in the string
         }
      }

      return result.toString();
   }

   /** Clear the list */
   public void clear() {
      size = 0;
      head = tail = null;
   }

   /*
    * Return the element at the specified index.
    * Return null if index not in range
    */
   public E get(int index) {
      // Left as an exercise
      if (index < 0 || index >= size) {
         return null;
      }
      Node<E> current = head;
      for (int i = 0; i < index; ++i) {
         current = current.next;
      }
      return current.element;
   }

   /* Return the number of elements in this list */
   public int size() {
      return size;
   }

   /* Return true if this list contains no elements */
   public boolean isEmpty() {
      return size == 0;
   }

   public void addAfter(int index, E value) {

      // Create Node
      Node<E> newNode = new Node<>(value);

      // Checks if index is within range
      if (index < 0 || index >= size) {
         return;
      }

      Node<E> current = head;

      // Travel through list
      for (int i = 0; i < index - 1; i++) {
         current = current.next;
      }

      // Insert Node
      newNode.next = current.next;
      current.next = newNode;

      // Increment Size
      size++;

   }

   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MyLinkedList)) {
         return false;
      }

      @SuppressWarnings("unchecked")
      MyLinkedList<E> other = (MyLinkedList<E>) o;

      // Check if sizes are equal
      if (this.size != other.size) {
         return false;
      }

      Node<E> current1 = this.head;
      Node<E> current2 = other.head;

      // Traverse both lists, compare data
      while (current1 != null) {
         if (!current1.element.equals(current2.element)) {
            return false;
         }
         current1 = current1.next;
         current2 = current2.next;
      }

      return true;
   }

   /*
    * Remove the element at the specified position in this
    * list. Return the element that was removed from the list.
    */
   public E remove(int index) {

      E removed;
      // I spent 2 hours trying to use the word or instead of ||
      if (index < 0 || index >= size || head == null) {
         return null;
      }
      // Index 0=head
      if (index == 0) {
         removed = head.element;
         head = head.next;
      } else {
         Node<E> prevNode = head;
         // Move through the list
         for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.next;
         }
         removed = prevNode.next.element;
         // Actually remove at specific index
         prevNode.next = prevNode.next.next;
      }
      // Decrement Size
      size--;

      // Return removed value
      return removed;
   }

   /* Check to see if this list contains element e */
   public boolean contains(E e) {

      Node<E> current = head;

      // Increment Through List
      for (int i = 0; i < size; i++) {

         // Does List contain Element?
         if (current.element.equals(e)) {
            return true;
         }

         current = current.next;
      }

      return false;
   }

   /*
    * Remove all the occurrences of the element e
    * from this list. Return true if the element is removed.
    */
   public boolean removeAll(E e) {

      Node<E> current = head;
      Node<E> previous = null;

      boolean removed = false;

      // Iterate over list
      while (current != null) {
         if (current.element.equals(e)) {

            // Store next node
            Node<E> next = current.next;

            // Update previous node
            if (previous == null) {
               head = next;
            } else {
               previous.next = next;
            }

            // Decrement size
            size--;

            removed = true;
            current = next;

         } else {
            // Move pointers
            previous = current;
            current = current.next;
         }

      }

      return removed;

   }

   /*
    * Remove the first occurrence of the element e
    * from this list. Return true if the element is removed.
    */
   public boolean removeElement(E e) {

      // Empty list, element cannot be removed
      if (head == null) {
         return false;
      }

      // Check head
      if (head.element.equals(e)) {
         // If head matches value passed to e then remove head
         head = head.next;
         // Decrement size
         size--;
         return true;
      }

      Node<E> current = head;

      /*
       * All linked lists end in null, so until we hit null we are
       * still inside the list
       */
      while (current.next != null) {
         if (current.next.element.equals(e)) {
            current.next = current.next.next;
            // If we remove, update size variable
            size--;
            return true;
         }
         /*
          * While loops don't inherintly increment
          * Implementing this variable update will cause that
          */
         current = current.next;
      }

      // Element with associated data, not found :(
      return false;
   }

   /*
    * Return the index of the head matching element in
    * this list. Return -1 if no match.
    */
   public int indexOf(Object e) {
      // Left as an exercise

      return -1;
   }

   /*
    * Return the index of the last matching element in
    * this list. Return -1 if no match.
    */
   public int lastIndex(E e) {

      //Initialize Counter
      int temp = 0;

      //Initialize placement
      int index = -1;

      Node<E> current = head;

      //Iterate list
      while(current != null) {

         if(current.element.equals(e)) {
            temp = index;
         }

         index++;
         current = current.next;

      }

      return temp;
   }

   /*
    * Replace the element at the specified position
    * in this list with the specified element and return the old element that was
    * over written
    */
   public E set(int index, E e) {

      Node<E> current = head;

      // Check if index within range
      if (size < index || head == null) {
         return null;
      }

      // Iterate through until at indexed location
      for (int i = 0; i < index; i++) {
         current = current.next;
      }

      // Store removed element
      E removed = current.element;
      current.element = e;

      return removed;
   }

   /* Print this list in reverse using recursion */
   public void printListBackWard() {
      // Begin recursive Call
      printListBackWard(head);
   }

   private void printListBackWard(Node<E> nextNode) {
      // Check for list
      if (nextNode == null) {
         return;
      }

      // Call on next node
      printListBackWard(nextNode.next);

      // Print node element
      System.out.print(nextNode.element);
      System.out.print(' ');
   }

   /*
    * Split the original list in half. The original
    * list will continue to reference the
    * front half of the original list and the method
    * returns a reference to a new list that stores the
    * back half of the original list. If the number of
    * elements is odd, the extra element should remain
    * with the front half of the list.
    */
   public MyLinkedList<E> split() {
      MyLinkedList<E> temp = new MyLinkedList<>();
      
      // Check if lists are empty
      if(head == null || head.next == null) {
         return null;
      }

      //Find the middle
      Node<E> mid = head;
      Node<E> fast = head;

      while(fast.next != null && fast.next.next != null) {
         mid = mid.next;
         fast = fast.next.next;
      }

      // Update pointers
      temp.head = mid.next;
      mid.next = null;

      // Update Size
      temp.size = size - (size/2);
      size = size/2;

      return temp;

   }

   private static class Node<E extends Comparable<E>> {
      E element;
      Node<E> next;

      public Node(E element) {
         this.element = element;
      }
   }

}