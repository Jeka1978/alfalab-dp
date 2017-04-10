/*
package enumLearning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * Created by Evegeny on 09/04/2017.
 *//*

@Getter
@AllArgsConstructor
public enum  MaritalStatus {
    SINGLE(1, new SingleHandler()),
    MARRIED(2,new SingleHandler()),
    DIVORCED(3,new SingleHandler()) ;

    private Handler handler;
    private  int dbCode;

    private static Map<Integer, MaritalStatus> map = new HashMap<>();
    static {
        MaritalStatus[] statuses = values();
        for (MaritalStatus status : statuses) {
            map.put(status.dbCode, status);
        }
    }



    @SneakyThrows
    public static MaritalStatus findByDbCode(int dbCode) {
        MaritalStatus maritalStatus = map.get(dbCode);
        new FileOutputStream("");

        return maritalStatus;
    }















}
*/
