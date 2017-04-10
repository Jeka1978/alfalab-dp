package myReflections;

/**
 * Created by Evegeny on 09/04/2017.
 */
public class Main {




    public static void main(String[] args) {
        TestRunner testRunner = new TestRunner();
        testRunner.runAllTestsMethods(new MyTest());
        double d = 1.1;
        double s = 1.3;
        System.out.println(d+s);
    }


}
