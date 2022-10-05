import org.example.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Some tests for check the correctness of my stack realization.
 */
public class StackTests {
    /**
     * Unit test for push function.
     * push adds one element to the top of stack
     */
    @Test
    public void testPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
    }

    /**
     * Unit test for pushStack.
     * pushStack adds one stack to the top of another stack
     */
    @Test
    public void testPushStack() {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        Stack<Integer> stack2 = new Stack<>();
        stack2.pushStack(stack1);
        Assertions.assertEquals(stack1, stack2);
    }

    /**
     * Unit test for pop function.
     * pop returns top element of stack
     */
    @Test
    public void testPop() {
        Stack<String> stack = new Stack<>();
        stack.push("Unit");
        stack.push("Tests");
        String str;
        str = stack.pop();
        Assertions.assertEquals(str, "Tests");
        str = stack.pop();
        Assertions.assertEquals(str, "Unit");
    }

    /**
     * Unit test for popStack.
     * popStack return one stack with n last elements of another stack
     */
    @Test
    public void testPopStack() {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(20);
        stack1.push(1);
        stack1.push(20);
        Stack<Integer> stack2 = new Stack<>();
        stack2.pushStack(stack1.popStack(2));
        Assertions.assertEquals(stack1, stack2);
    }

    /**
     * Unit test for count function.
     * count returns the number of stack elements
     */
    @Test
    public void testCount() {
        Stack<Long> stack = new Stack<>();
        stack.push(1L);
        stack.push(2L);
        stack.push(3L);
        Assertions.assertEquals(stack.count(), 3);
        stack.pop();
        Assertions.assertEquals(stack.count(), 2);
    }

    /**
     * This test check the work of push & pop functions.
     */
    @Test
    public void testPushPop() {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(11);
        stack1.push(11);
        stack1.push(33);
        stack1.push(22);
        stack1.push(22);
        stack1.push(22);
        stack1.push(22);
        stack1.push(22);
        stack1.push(22);
        Stack<Integer> helpStack1 = new Stack<>();
        helpStack1.pushStack(stack1.popStack(5));
        Integer num1;
        Integer num2;
        Integer num3;
        num1 = stack1.pop();
        num2 = stack1.pop();
        num3 = stack1.pop();
        stack1.push(num1);
        stack1.push(num2);
        stack1.push(num3);
        Stack<Integer> helpStack2 = new Stack<>();
        helpStack2.push(11);
        helpStack2.push(22);
        helpStack2.push(33);
        helpStack2.push(11);
        Assertions.assertEquals(helpStack2, stack1);
        Stack<Integer> helpStack3 = new Stack<>();
        helpStack3.push(22);
        helpStack3.push(22);
        helpStack3.push(22);
        helpStack3.push(22);
        helpStack3.push(22);
        Assertions.assertEquals(helpStack1, helpStack3);
        Assertions.assertEquals(helpStack1.count(), 5);
    }

    /**
     * This test checked count function.
     * And checked a case when number of stack elements more than start capacity.
     */
    @Test
    public void testCountAndOverflow() {
        Stack<String> st1 = new Stack<>();
        st1.push("one");
        st1.push("two");
        st1.push("three");
        st1.pushStack(st1);
        Assertions.assertEquals(st1.count(), 6);
        Stack<String> st2 = new Stack<>();
        Assertions.assertEquals(st2.count(), 0);
        st2.pushStack(st1.popStack(3));
        Assertions.assertEquals(st1, st2);
        Assertions.assertEquals(st1.count(), st2.count());
        Assertions.assertEquals(st2.count(), 3);
    }

    /**
     * Test with empty stacks.
     */
    @Test
    public void testEmptyStacks() {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Assertions.assertEquals(st1, st2);
        Assertions.assertEquals(st1.count(), 0);
    }

    /**
     * Test for increasing coverage.
     */
    @Test
    public void testFloat() {
        Stack<Float> st1 = new Stack<>();
        st1.push(1.0f);
        Assertions.assertEquals(st1, st1);
        Float fl = 2.0f;
        Assertions.assertTrue(!st1.equals(fl));
        Stack<Float> st2 = new Stack<>();
        st2.push(2.0f);
        Assertions.assertTrue(!st1.equals(st2));
        st1.pushStack(st2.popStack(1));
        Assertions.assertEquals(st1.count(), 2);
        Assertions.assertEquals(st2.count(), 0);
        st1.pop();
        st1.pop();
        st1.pop();
        int hash = st1.hashCode();
    }
}
