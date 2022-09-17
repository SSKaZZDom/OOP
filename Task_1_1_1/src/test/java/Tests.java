import org.example.Heapsort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    public void test1(){
        //simple test
        int result[] = {1,2,3,4,5,6,7,8,9,10};
        int test[] = {3,10,7,6,9,4,1,8,2,5};
        Heapsort.heapsort(test,0);
        Assertions.assertEquals(result,test);
    }
    @Test
    public void test2(){
        //test for the repetitive numbers
        int result[] = {1,2,3,4,5,5,5,5,5};
        int test[] = {3,5,4,5,1,5,5,2,5};
        Heapsort.heapsort(test,0);
        Assertions.assertEquals(result,test);
    }
    @Test
    public void test3(){
        //reverse array test
        int result[] = {1,2,3,4,5,324,5647,3245678,345678909};
        int test[] = {345678909,3245678,5647,324,5,4,3,2,1};
        Heapsort.heapsort(test,0);
        Assertions.assertEquals(result,test);
    }
}
