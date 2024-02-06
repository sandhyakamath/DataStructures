import com.godel.ds.implementation.ArrayQueue;
import com.godel.ds.implementation.ArrayStack;
import com.godel.ds.interfaces.GenericQueue;
import com.godel.ds.interfaces.GenericStack;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        GenericStack<Integer> stack = new ArrayStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(40);
        stack.push(50);
        stack.push(10);
        stack.push(20);
        stack.push(40);
        stack.push(50);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        GenericQueue<Integer> queue = new ArrayQueue<>();
        queue.add(10);
        queue.add(20);
        queue.add(40);

        queue.remove();
        queue.remove();
        queue.remove();
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.remove();
        queue.remove();
        queue.remove();


    }

}