
public class App {
    public static void main(String[] args) throws Exception {
        
        //simple test for Stack data structure
        Stack stack = new Stack<Integer>();
        stack.Push(1);
        stack.Push(2);
        stack.Pop();
        System.out.println(stack.Top());

        //circular queue

        Queue queue = new Queue<Integer>();
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);

        queue.Dequeue();

        System.out.println(queue.Front());

        //Linked list

        LinkedList linkedList = new LinkedList<Integer>();
        
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        linkedList.addFirst(4);

        linkedList.removeLast();

        linkedList.printList();

        //Hash Table

        Hash HashMap = new Hash<String, Integer>(10);
        
        HashMap.add("person age 1", 19);
        HashMap.add("person age 2", 23);
        HashMap.add("person age 3", 28);

        HashMap.remove("person age 2", 23);

        System.out.println(HashMap.getValue("person age 1"));

        //binary tree 

        Tree tree = new Tree<Integer>();

        tree.add(10);
        tree.add(20);
        tree.add(5);
        tree.add(30);
        System.out.println(tree.contains(5));


        //Max Heap Tree

        Heap heap = new Heap(10)<Integer>();

        heap.add(10);
        heap.add(20);
        heap.add(5);
        heap.add(30);

        // AVL Tree

        AVLTree avlTree = new AVLTree<Integer>();

        avlTree.add(10);
        avlTree.add(41);
        avlTree.add(4);
        avlTree.add(32);
        avlTree.add(15);

        avlTree.prettyPrint();

    }
}
