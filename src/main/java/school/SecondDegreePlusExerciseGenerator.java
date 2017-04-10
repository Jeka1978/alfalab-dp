package school;

import java.util.Random;

import static school.Operator.PLUS;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class SecondDegreePlusExerciseGenerator implements ExerciseGenerator {
    private final ExerciseGeneratorAssistant assistant;

    public SecondDegreePlusExerciseGenerator() {
        assistant = new RangeOperandsGeneratorAssistant(300);
    }
    @Override
    public Exercise generate() {
        Exercise exercise = assistant.generateTemplate();
        exercise.setOperator(PLUS);
        exercise.setAnswer(exercise.getA()+exercise.getB());
        return exercise;
    }
}
