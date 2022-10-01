import org.example.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Some tests for check the correctness of my stack realization.
 */
public class StackTests {
    /**
     * This test check the work of push & pop functions.
     */
    @Test
    public void testPushPop() {
        Stack<Integer> Stack1 = new Stack<>(10);
        Stack1.push(11);
        Stack1.push(11);
        Stack1.push(33);
        Stack1.push(22);
        Stack1.push(22);
        Stack1.push(22);
        Stack1.push(22);
        Stack1.push(22);
        Stack1.push(22);
        Stack<Integer> helpStack1 = new Stack<>(10);
        helpStack1.pushStack(Stack1.popStack(5));
        Integer num1, num2, num3;
        num1 = Stack1.pop();
        num2 = Stack1.pop();
        num3 = Stack1.pop();
        Stack1.push(num1);
        Stack1.push(num2);
        Stack<Integer> helpStack2 = new Stack<>(10);
        helpStack2.push(11);
        helpStack2.push(22);
        helpStack2.push(33);
        Assertions.assertEquals(helpStack2, Stack1);
        Stack<Integer> helpStack3 = new Stack<>(10);
        helpStack3.push(22);
        helpStack3.push(22);
        helpStack3.push(22);
        helpStack3.push(22);
        helpStack3.push(22);
        Assertions.assertEquals(helpStack1, helpStack3);
    }

    /**
     * This test checked count function & a case when number of stack elements more than start capacity.
     */
    @Test
    public void testCountAndOverflow() {
        Stack<String> st1 = new Stack<>(0);
        Stack<String> st2 = new Stack<>(0);
        st1.push("one");
        st1.push("two");
        st1.push("three");
        st1.pushStack(st1);
        Assertions.assertEquals(st1.count(), 6);
        Assertions.assertEquals(st2.count(), 0);
        st2.pushStack(st1.popStack(3));
        String str = ";;;";
        st2.push(str);
        st2.push(str);
        str = st2.pop();
        str = st2.pop();
        Assertions.assertEquals(st1, st2);
        Assertions.assertEquals(st1.count(),st2.count());
        Assertions.assertEquals(st2.count(), 3);
    }

    /**
     * Test with empty stacks.
     */
    @Test
    public void testEmptyStacks() {
        Stack<Integer> st1 = new Stack<>(0);
        Stack<Integer> st2 = new Stack<>(10);
        Assertions.assertEquals(st1,st2);
        Integer num = 0;
        st1.push(num);
        num = st1.pop();
        Assertions.assertEquals(st1,st2);
    }
}
