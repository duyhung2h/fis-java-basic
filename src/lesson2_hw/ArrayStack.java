package lesson2_hw;

import java.util.*;
public class ArrayStack < E > {

    public static final int CAPACITY = 1000; // default array capacity
    private int topIndex; // index of the top element in stack
    private E[] data; // generic array used for storage


    public ArrayStack() {
        this(CAPACITY);
    } // constructs stack with default capacity

    public ArrayStack(int capacity) { // constructs stack with given capacity
        System.out.println("ArrayStack");
        System.out.println(capacity);
        topIndex = -1;
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

    public int size() {
        return (topIndex + 1);
    }

    public boolean empty() {
        return (topIndex == -1);
    }

    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++topIndex] = e; // increment topIndex before storing new item
    }

    public E peek() throws EmptyStackException {
        if (empty()) throw new EmptyStackException();
        return data[topIndex];
    }

    public E pop() throws EmptyStackException {
        if (empty()) throw new EmptyStackException();
        E answer = data[topIndex];
        data[topIndex] = null; // dereference to help garbage collection
        topIndex--;
        return answer;
    }

    static class Person {

    }
    class Student extends Person {

    }
    class Teacher extends Person {

    }
    public static void main(String args[]) {
        ArrayStack mystack = new ArrayStack<>();
        mystack.push(9);
        mystack.push(3);
        mystack.push("abc");
//        Person per = new Person();
        mystack.push(new Person());
        System.out.println("Element at the top is :" + mystack.peek());
        System.out.println("Stack data :  " + Arrays.toString(mystack.data));
        System.out.println("Element removed is : " + mystack.pop());
        System.out.println("Stack data :  " + Arrays.toString(mystack.data));
        System.out.println("The size of the stack is : " + mystack.size());
        System.out.println("Element removed is : " + mystack.pop());
        System.out.println("Element at the top is : " + mystack.peek());
        mystack.push(10);
        System.out.println("Stack is empty :  " + mystack.empty());
        System.out.println("Stack data :  " + Arrays.toString(mystack.data));
    /*Note: In output charecters of the comments are written to correspond the
    output, they won't be printed.*/
    }
}
