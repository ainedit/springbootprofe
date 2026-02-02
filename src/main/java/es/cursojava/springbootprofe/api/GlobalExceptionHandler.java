package es.cursojava.springbootprofe.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiError> notFound(NoSuchElementException ex) {
        ApiError err = new ApiError(404, "NOT_FOUND", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> badRequest(MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult().getFieldErrors().isEmpty()
                ? "Datos inválidos"
                : ex.getBindingResult().getFieldErrors().get(0).getField() + ": " +
                  ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();

        ApiError err = new ApiError(400, "BAD_REQUEST", msg);
        return ResponseEntity.badRequest().body(err);
    }
}
