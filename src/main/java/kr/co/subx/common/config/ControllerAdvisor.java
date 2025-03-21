package kr.co.subx.common.config;

import kr.co.subx.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvisor {

    /**
     * RequestBody Validation
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        return ResponseEntity.unprocessableEntity().body(new ErrorResponse("422", bindingErrorResponse(bindingResult)));
    }

    /**
     * Parameter Validation
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleBindException(BindException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        return ResponseEntity.unprocessableEntity().body(new ErrorResponse("422", bindingErrorResponse(bindingResult)));
    }

    /**
     * make error response
     *
     * @param bindingResult
     * @return
     */
    private String bindingErrorResponse(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(",")) + " 필드가 누락되었습니다.";
    }

}
