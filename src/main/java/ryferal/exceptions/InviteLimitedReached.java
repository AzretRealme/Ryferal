package ryferal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.LOCKED)
public class InviteLimitedReached extends RuntimeException{

    public InviteLimitedReached(String message) {
        super(message);
    }
}
