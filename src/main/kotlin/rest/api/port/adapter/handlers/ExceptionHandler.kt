package rest.api.port.adapter.handlers

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import rest.api.application.exceptions.EntityNotFoundException
import javax.persistence.PersistenceException


@ControllerAdvice
open class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(PersistenceException::class)
    open fun handleTimeoutException(ex: PersistenceException, request: WebRequest): ResponseEntity<Any> {
        return handleExceptionInternal(ex, ex.message, HttpHeaders(), HttpStatus.ACCEPTED, request)
    }

    @ExceptionHandler(EntityNotFoundException::class)
    open fun handleEntityNotFoundException(ex: EntityNotFoundException, request: WebRequest): ResponseEntity<Any> {
        return handleExceptionInternal(ex, ex.message, HttpHeaders(), HttpStatus.ACCEPTED, request)
    }
}