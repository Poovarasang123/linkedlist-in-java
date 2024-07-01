public class Demo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.insertAtBeginning(9);
        list.insertAtBeginning(5);
        list.insertAtPos(2, 6);
        list.insertAtLast(7);
        list.reverse();
        list.deleteAtPos(0);
        list.deleteAtLast();
        list.Display();

        for(int a:list){
            System.out.print(a+" ");
        }
    }
}
