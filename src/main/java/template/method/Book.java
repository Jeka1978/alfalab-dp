package template.method;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Evegeny on 10/04/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Component {
   private int cost;

}
