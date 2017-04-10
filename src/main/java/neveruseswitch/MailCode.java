package neveruseswitch;/**
 * Created by Evegeny on 09/04/2017.
 */

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface MailCode {
    int value();
}
