package school;

import java.util.Random;

import static school.Operator.MINUS;
import static school.Operator.PLUS;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class SecondDegreeMinusExerciseGenerator implements ExerciseGenerator {

    private final ExerciseGeneratorAssistant assistant;

    public SecondDegreeMinusExerciseGenerator() {
        assistant = new RangeOperandsGeneratorAssistant(1000);
    }

    @Override
    public Exercise generate() {
        Exercise exercise = assistant.generateTemplate();
        exercise.setOperator(MINUS);
        exercise.setAnswer(exercise.getA()-exercise.getB());
        return exercise;
    }
}
