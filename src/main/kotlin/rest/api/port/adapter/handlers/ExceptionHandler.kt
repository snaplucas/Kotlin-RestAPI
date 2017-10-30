package rest.api.port.adapter.handlers

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import rest.api.application.exceptions.EntityNotFoundException
import java.util.concurrent.TimeoutException


@ControllerAdvice
open class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(RuntimeException::class)
    open fun handleRuntimeException(excecao: RuntimeException, request: WebRequest): ResponseEntity<Any> {
        val mensagem = "Runtime exception capturada"
        return handleExceptionInternal(excecao, mensagem, HttpHeaders(), HttpStatus.CONFLICT, request)
    }

    @ExceptionHandler(TimeoutException::class)
    open fun handleTimeoutException(excecao: TimeoutException, request: WebRequest): ResponseEntity<Any> {
        val mensagem = "Timeout exception capturada"
        return handleExceptionInternal(excecao, mensagem, HttpHeaders(), HttpStatus.ACCEPTED, request)
    }

    @ExceptionHandler(EntityNotFoundException::class)
    open fun handleEntityNotFoundException(excecao: EntityNotFoundException, request: WebRequest): ResponseEntity<Any> {
        return handleExceptionInternal(excecao, excecao.message, HttpHeaders(), HttpStatus.ACCEPTED, request)
    }
}