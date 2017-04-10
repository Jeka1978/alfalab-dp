package multipleInheritance;

/**
 * Created by Evegeny on 09/04/2017.
 */
public interface Father {
    default void говорить(){
        System.out.println("сынок иди кушать");
    }
}
