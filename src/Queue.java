

public class Queue<E>{
    public static final int MAX_SIZE = 101;
    private E[] q;
    private int front, rear;

    @SuppressWarnings("unchecked")
    Queue(){
        q = (E[]) new Object[MAX_SIZE];
        front = rear = -1;
    }

    public boolean isEmpty(){
        return (front == -1 && rear == -1);
    }

    public boolean isFull(){
        return ((rear + 1) % MAX_SIZE) == front ? true : false;
    }

    public void Enqueue(E n){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        if(isEmpty()){
            front = rear = 0;
        }
        else{
            rear = (rear + 1) % MAX_SIZE;
        }
        q[rear] = n;
    }

    public E Dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return null;   
        }

        E temp = q[front];

        if(rear == front){
            front = rear = -1;
        }
        else{
            front = (front + 1) % MAX_SIZE;
        }
        return temp;
 
    }

    public E Front(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        return q[front];
    }
}