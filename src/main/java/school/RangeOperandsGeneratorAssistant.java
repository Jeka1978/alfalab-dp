package school;

import lombok.RequiredArgsConstructor;

import java.util.Random;

/**
 * Created by Evegeny on 10/04/2017.
 */
@RequiredArgsConstructor
public class RangeOperandsGeneratorAssistant implements ExerciseGeneratorAssistant {
    private Random random = new Random();
    private final int max;

    @Override
    public Exercise generateTemplate() {
        Exercise exercise = new Exercise();
        exercise.setA(random.nextInt(max));
        exercise.setB(random.nextInt(max));
        return exercise;
    }
}
