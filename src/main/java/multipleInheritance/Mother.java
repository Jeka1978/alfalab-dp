package multipleInheritance;

/**
 * Created by Evegeny on 09/04/2017.
 */
public interface Mother {
    default void говорить(){
        System.out.println("СЫНОК ИДИ КУШАТЬ!!!");
    }
}
