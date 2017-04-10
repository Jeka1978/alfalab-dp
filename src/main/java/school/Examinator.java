package school;

import lombok.*;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.List;
import java.util.Random;

/**
 * Created by Evegeny on 10/04/2017.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Examinator {
    @Singular
    private  List<ExerciseGenerator> exerciseGenerators ;
    private DataFactory dataFactory = new DataFactory();
    public Exercise createExercise() {
        ExerciseGenerator generator = dataFactory.getItem(exerciseGenerators);
        return generator.generate();
    }

}



