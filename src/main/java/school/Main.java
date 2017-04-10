package school;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        Examinator examinator = Examinator.builder()
                .exerciseGenerator(new SecondDegreeMinusExerciseGenerator())
                .exerciseGenerator(new SecondDegreePlusExerciseGenerator()).build();

        for (int i = 0; i < 10; i++) {
            System.out.println(examinator.createExercise());
        }
    }
}
