
public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
        MyLinkedList<String> list1 = new MyLinkedList<String>();
        MyLinkedList<String> list0 = new MyLinkedList<String>();
        
        list1.addFirst("node1");
        list1.addLast("node2"); 
        list1.addLast("node3");
        System.out.println("3-element list: " + list1);
        System.out.println("***************************");
        System.out.println("Testing printListBackward");
        list1.printListBackWard();
        System.out.println("***************************");
        System.out.println("\nTesting equals...");
        list0.addFirst("node1");
        list0.addLast("node2"); 
        list0.addLast("node3");
        System.out.println(list1.equals(list0)?"PASSED":"**FAILED**");
        System.out.println("***************************");

        MyLinkedList<String> list4 = new MyLinkedList<String>();
        list4.addLast("node1"); 
        list4.addLast("node2"); 
        list4.addLast("node3"); 
        list4.addLast("node4");
        System.out.println("4-element list: " + list4);
        System.out.println("Testing indexOf...");
        System.out.println(list4.indexOf("node3")==2?"PASSED":"**FAILED**");
        System.out.println("***************************");

        System.out.println("\nTesting set...");
        MyLinkedList<Integer> test = new MyLinkedList<>();
        System.out.println("  empty list test = " + ((test.set(2,2) == null)?"PASSED":"**FAILED**"));
        
        System.out.println("  return value test = " + ((list4.set(1,"NoneChanged")).equals("node2")?"PASSED":"**FAILED**"));
        System.out.println("  non-empty test = " +  (list4.get(1).equals("NoneChanged") ?"PASSED":"**FAILED**"));
        System.out.println("***************************");

        System.out.println("\nTesting addAfter...");
        MyLinkedList<String> other = new MyLinkedList<String>();
        other.addLast("one");
        other.addLast("two");
        other.addLast("three");
        other.addLast("four");
        System.out.println(other.size() + " " + other);
        other.addAfter(2,"three.5");
        System.out.println((other.get(3).equals("three.5")?"PASSED":"**FAILED**"));
        System.out.println(other.size() + " " + other);
        System.out.println("***************************");

        System.out.println("\nTesting Constructor...");
        Integer[] myList = {5,2,6,2,7,8,2,9};
        test = new MyLinkedList<>(myList);
        System.out.println(test);
        System.out.println("\nTesting lastIndex...");
        System.out.println((test.lastIndex(2)==6)?"PASSED":"**FAILED**");
        test.addFirst(1);
        System.out.println((test.lastIndex(1)==0)?"PASSED":"**FAILED**");
        
        System.out.println("***************************");

        System.out.println("\nTesting removeAll...");
        test.removeAll(2);
        System.out.println(test);
        System.out.println("\nTesting contains...");
        System.out.println((test.contains(2)==false)?"PASSED":"**FAILED**");
        System.out.println("***************************");

        System.out.println("\nTesting split...");
        MyLinkedList<String> result;
        
        MyLinkedList<String> list5 = new MyLinkedList<String>();
        list5.addLast("node1"); 
        list5.addLast("node2"); 
        list5.addLast("node3"); 
        list5.addLast("node4");
        list5.addLast("node5");
        MyLinkedList<String> list6 = new MyLinkedList<String>();
        list6.addLast("node1"); 
        list6.addLast("node2"); 
        list6.addLast("node3");
        list6.addLast("node4");
        list6.addLast("node5");
        list6.addLast("node6");
        System.out.print("SPLIT ");
        System.out.println(list5.size() + " " + list5);
        result = list5.split();
        System.out.println("  list " + list5.size() + " " + list5);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list6.size() + " " + list6);
        result = list6.split();
        System.out.println("  list " + list6.size() + " " + list6);
        System.out.println("  result " + result.size() + " " + result);
        System.out.println("\nTesting removeElement...");
        MyLinkedList<String> list7 = new MyLinkedList<String>();
        list7.addLast("node1"); 
        list7.addLast("node2"); 
        list7.addLast("node3");
        list7.addLast("node4");
        list7.addLast("node5");
        list7.addLast("node6");
        System.out.println((list7.removeElement("node3")==true)?"PASSED":"**FAILED**");
        System.out.println((list7.removeElement("node1")==true)?"PASSED":"**FAILED**");
        System.out.println((list7.removeElement("node6")==true)?"PASSED":"**FAILED**");
        System.out.println((list7.removeElement("node7")==false)?"PASSED":"**FAILED**");
        System.out.println("List7 -->"+list7);
        System.out.println("***************************");
        System.out.println("\nTesting remove...");
        MyLinkedList<String> list8 = new MyLinkedList<String>();
        list8.addLast("node1"); 
        list8.addLast("node2"); 
        list8.addLast("node3");
        list8.addLast("node4");
        list8.addLast("node5");
        list8.addLast("node6");
        System.out.println((list8.remove(2)=="node3")?"PASSED":"**FAILED**");
        System.out.println((list8.remove(0)==("node1")==true)?"PASSED":"**FAILED**");
        System.out.println((list8.remove(3)==("node6")==true)?"PASSED":"**FAILED**");
        System.out.println((list8.remove(7)==null)?"PASSED":"**FAILED**");
        System.out.println("list8 -->"+list8);
        System.out.println("***************************");

	}

}
