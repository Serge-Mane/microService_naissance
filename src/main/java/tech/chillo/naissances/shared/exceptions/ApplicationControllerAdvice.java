package tech.chillo.naissances.shared.exceptions;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ResponseStatus(value = NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public @ResponseBody ErrorEntity entityNotFoundExceptionHandler(EntityNotFoundException exception){
        log.error("erreur {}", exception.getMessage(), exception);
        return new ErrorEntity(
                LocalDateTime.now(),
                NOT_FOUND.value(),
                null,
                exception.getMessage()
        );
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody ErrorEntity runtimeExceptionHandler(RuntimeException exception) {
        log.error("erreur {}", exception.getMessage(), exception);
        return new ErrorEntity(
                LocalDateTime.now(),
                BAD_REQUEST.value(),
                null,
                exception.getMessage()
        );
    }
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public @ResponseBody ErrorEntity dataIntegrityViolationExceptionHandler(DataIntegrityViolationException exception) {
        log.error("erreur {}", exception.getMessage(), exception);
        return new ErrorEntity(
                LocalDateTime.now(),
                BAD_REQUEST.value(),
                null,
                "Une donnée que vous avez sasi est invalide"
        );
    }
}
