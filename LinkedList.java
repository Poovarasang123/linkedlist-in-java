import java.util.Iterator;
public class LinkedList<T> implements Iterable<T>{
    Node head;
    class Node{
        T data;
        Node next;
        Node(T val){
            data = val;
            next = null;
        }
    }
    LinkedList(){
        head = null;
    }
    public void insertAtBeginning(T val){
        Node newNode = new Node(val);
        if(head==null){ //when list is empty
            head = newNode;
        }
        else{ //list is not empty;
            newNode.next = head;
            head = newNode;
        }
    }
    public void FindKey(T searchkey){
        Node temp = head; 
        if(head == null) {
            throw new IndexOutOfBoundsException("Search attempted in empty list");
        }
        while(temp != null) {
            if(temp.data == searchkey){
               System.out.println();
               System.out.println("search key found "+temp.data);
               return;
            }
            temp = temp.next;
        }
        System.out.println("search key not found");
    }
    public int countOfList(){
        Node temp = head;
        if(head == null) {
            return 0;
        }
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public void insertAtPos(int pos,T val){
        if(pos==0){
            insertAtBeginning(val);
            return;
        }
        Node newNode  = new Node(val);
        Node temp = head;
        for(int i=1;i<pos;i++){
            temp = temp.next;
            if(temp==null){
                throw new IndexOutOfBoundsException("Invalid position "+pos);
            }
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void insertAtLast(T val){
        Node newNode = new Node(val);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = null;
    
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        return;
    }
    public void deleteAtPos(int pos){
        if(head == null){
           throw new IndexOutOfBoundsException("deletion attempted in empty list"); 
        }
        if(pos ==0){
            head = head.next;
            return;
        }
        Node temp = head;
        Node prev = null;
        for(int i=1;i<=pos;i++){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
    }
    public void deleteAtBeginning(){
        if(head==null)  throw new IndexOutOfBoundsException();
        head = head.next;
    }  
    public void deleteAtLast(){
        if(head == null){
            throw new IndexOutOfBoundsException("deletion attempted in empty list"); 
         }
        Node temp = head;
        Node prev = null;
        while(temp.next!=null){
            prev = temp;
            temp = temp.next;
        }
        prev.next=null;
    }
    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next = curr.next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            Node temp = head;
            public boolean hasNext(){
                return temp!=null;
            }
            public T next() {
                T val = temp.data;
                temp = temp.next;
                return val;
            }
        };
    }
}
