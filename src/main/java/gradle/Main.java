package gradle;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        Compile compile = new Compile();
        TestCompile testCompile = new TestCompile();
        Package aPackage = new Package();
        Build build = new Build();
        build.addTask(aPackage);
        aPackage.addTask(testCompile);
        testCompile.addTask(compile);

        build.execute();
    }
}
