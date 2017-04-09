package lab1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Evegeny on 09/04/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailInfo {
    private ClientData clientData;
    private int mailCode;
}
