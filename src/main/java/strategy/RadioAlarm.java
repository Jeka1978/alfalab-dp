package strategy;

import lombok.*;
import lombok.experimental.Delegate;

/**
 * Created by Evegeny on 09/04/2017.
 */
@RequiredArgsConstructor

public class RadioAlarm implements Radio, Alarm {
    @Delegate
    private final Alarm alarm;
    @Delegate
    private final Radio radio;



}



