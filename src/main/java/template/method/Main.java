package template.method;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        Book book = new Book(30);
        Book book1 = new Book(40);
        Shelf shelf = new Shelf();
        shelf.addComponent(book);
        shelf.addComponent(book1);
        Cupboard cupboard = new Cupboard();
        cupboard.addComponent(shelf);
        System.out.println(cupboard.getCost());
    }
}
