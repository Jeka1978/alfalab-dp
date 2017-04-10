package multipleInheritance;

/**
 * Created by Evegeny on 09/04/2017.
 */
public class Son implements Mother,Father {
    @Override
    public void говорить() {
        Mother.super.говорить();
    }
}
