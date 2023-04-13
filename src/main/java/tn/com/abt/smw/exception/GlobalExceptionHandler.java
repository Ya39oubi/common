package tn.com.abt.smw.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> badRequestExceptionHandling(BadRequestException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST.getReasonPhrase(), exception.getMessage(), request.getDescription(false),
				exception.getParams());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<?> noContentExceptionHandling(NoContentException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.NO_CONTENT.value(),
				HttpStatus.NO_CONTENT.getReasonPhrase(), exception.getMessage(), request.getDescription(false),
				exception.getParams());
		return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundExceptionHandling(NotFoundException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage(), request.getDescription(false),
				exception.getParams());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UnavailableForLegalReasonsException.class)
	public ResponseEntity<?> unavailableForLegalReasonsExceptionHandling(UnavailableForLegalReasonsException exception,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS.value(),
				HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS.getReasonPhrase(), exception.getMessage(), request.getDescription(false),
				exception.getParams());
		return new ResponseEntity<>(errorDetails, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
	}

	@ExceptionHandler(NotAcceptableException.class)
	public ResponseEntity<?> notAcceptableExceptionHandling(NotAcceptableException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.NOT_ACCEPTABLE.value(),
				HttpStatus.NOT_ACCEPTABLE.getReasonPhrase(), exception.getMessage(), request.getDescription(false),
				exception.getParams());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exception.getMessage(),
				request.getDescription(false), null);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}