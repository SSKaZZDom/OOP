package org.example;

import java.util.Arrays;
import java.util.Objects;

/**
 * My realization of stack.
 * 1 constructor, 5 functions
 */
public class Stack<T> {
    private int size;
    private int limit;
    private T[] array;

    /**
     * Constructor of stack.
     */
    public Stack(int capacity){
        limit = capacity;
        array = (T[]) new Object[limit];
        size = 0;
    }

    /**
     * Auxiliary function.
     * It increases capacity of stack
     */
    private void realloc(int doubleLimit) {
        array = Arrays.copyOf(array, doubleLimit);
    }

    /**
     * This function add one element to the top of stack.
     */
    public void push(T a) {
        if (size == limit){
            if (limit == 0){
                limit = 2;
            }
            limit *= 2;
            realloc(limit);
        }
        size++;
        array[size-1] = a;
    }

    /**
     * This function add some stack to the top of other stack.
     */
    public void pushStack(Stack<T> stack) {
        int finish = stack.count();
        for (int i = 0; i < finish; i++){
            push(stack.array[i]);
        }
    }

    /**
     * This function take an element from the top of stack.
     */
    public T pop() {
        if (size > 0) {
            size--;
            T res = array[size];
            array[size] = null;
            return res;
        }
        else {
            System.out.println("Stack is empty");
        }
        return null;
    }

    /**
     * This function take n elements from the top of stack.
     */
    public Stack<T> popStack(int a) {
        if (size == 0){
            System.out.println("Stack is empty");
        }
        else {
            Stack<T> Out = new Stack<>(a);
            if (size < a){
                for (int i = size - 1; i >= 0; i--) {
                    Out.array[i] = pop();
                    Out.size++;
                }
            }
            else {
                for (int i = a - 1; i >= 0; i--) {
                    Out.array[i] = pop();
                    Out.size++;
                }
            }
            return Out;
        }
        return null;
    }

    /**
     * This function return number of stack elements.
     */
    public int count(){
        return size;
    }

    /**
     * My version of equals method.
     * now we can to compare two stacks.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Stack)){
            return false;
        }
        Stack<?> eqStack = (Stack<?>) o;
        boolean var = size == eqStack.size;
        if (var) {
            for (int i = 0; i < size; i++){
                if (array[i] != eqStack.array[i]){
                    var = false;
                    break;
                }
            }
        }
        return var;
    }

    /**
     * Function which returned object's hashcode.
     */
    @Override
    public int hashCode() {
        int res = Objects.hash(size);
        res = 31 * res + Arrays.hashCode(array);
        return res;
    }
}