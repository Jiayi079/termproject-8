import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface TestRunner{}

//TestNg clone

public class CustomTester {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = CustomTester.class.getMethods();
        // make a test instance
        var instance = new CustomTester();

        int totalTests = 0;
        int totalPass = 0;
        for(Method method : methods){
            if(method.isAnnotationPresent(TestRunner.class)){
                //testable method
                totalTests++;
                try{
                    // instance.test1();
                    method.invoke(instance); //manually trigger method -> args could be wrong, types could be wrong
                    totalPass++;
                }catch (Exception e){
                    System.out.println(e.getCause());
                }
            }
        }
        System.out.println("Total tests : " + totalTests + " Total Pass: " + totalPass);
    }

    @TestRunner
    public void test1(){
        System.out.println("Test 1");
        assertEquals(1,1);
    }

    @TestRunner
    public void test2(){
        System.out.println("Test 2");
        assertEquals(1,2);
    }

    void assertEquals(int a, int b){
        if(a != b){
            throw new RuntimeException("Number do not match "
                    + "Got " + a + " Expected " + b);
        }
    }
}
