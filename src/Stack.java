public class Stack<E> {
    public static final int MAX_SIZE = 5;
    private E[] s;
    private int top;
    private int FlowCount = 1;

    @SuppressWarnings("unchecked")
    Stack(){
        s = (E[]) new Object[MAX_SIZE];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return (top + 1 == MAX_SIZE);
    }

    @SuppressWarnings("unchecked")
    public void Push(E n){
        if(isFull()){
            E[] tmp = s.clone();
            s = (E[]) new Object[++FlowCount * MAX_SIZE];

            for(int i = 0; i < tmp.length ; i++){
                s[i] = tmp[i];
            }

        }
        s[++top] = n;
    }

    public E Pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }
        E tmp = s[top];
        top--;
        return tmp;
    }

    public E Top(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }
        return s[top];
    }


}
