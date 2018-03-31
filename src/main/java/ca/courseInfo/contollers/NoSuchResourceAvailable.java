/**
 * Class only made to deal with exceptions.
 * This class extends RuntimeException class and it deals with the exceptions related to concerns where the client
 * is trying to access something which doesn't exist.
 * @author Raghav Mittal.
 */
package ca.courseInfo.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.NOT_FOUND)
public class NoSuchResourceAvailable extends RuntimeException {

    public NoSuchResourceAvailable(String message) {
        super(message);
    }
}
