package com.example.geterogen.exceptions

import org.hibernate.exception.ConstraintViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException
import java.io.PrintWriter
import java.io.StringWriter
import javax.naming.AuthenticationException
import javax.persistence.EntityNotFoundException
import javax.persistence.NoResultException

@ControllerAdvice
class ControllerExceptionsHandler {

    @ExceptionHandler(
            ConstraintViolationException::class,
            HttpClientErrorException.BadRequest::class,
            MethodArgumentNotValidException::class,
            MissingServletRequestParameterException::class,
            IllegalArgumentException::class
    )
    fun constraintViolationException(e: Exception): ResponseEntity<ErrorResponse> {
        return generateErrorResponse(HttpStatus.BAD_REQUEST, "Bad request", e)
    }

    @ExceptionHandler(AuthenticationException::class)
    fun forbiddenException(e: Exception): ResponseEntity<ErrorResponse> {
        return generateErrorResponse(HttpStatus.UNAUTHORIZED, "You are not allowed to do this operation", e)
    }

    @ExceptionHandler(
            EntityNotFoundException::class,
            NoSuchElementException::class,
            NoResultException::class,
            EmptyResultDataAccessException::class,
            IndexOutOfBoundsException::class,
            KotlinNullPointerException::class
    )
    fun notFoundException(e: Exception): ResponseEntity<ErrorResponse> {
        return generateErrorResponse(HttpStatus.NOT_FOUND, "Resource not found", e)
    }

    @ExceptionHandler(
            Exception::class
    )
    fun internalServerErrorException(e: Exception): ResponseEntity<ErrorResponse> {
        return generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Generic internal error", e)
    }

    private fun generateErrorResponse(
            status: HttpStatus,
            message: String,
            e: Exception
    ): ResponseEntity<ErrorResponse> {

        val sw = StringWriter()
        val pw = PrintWriter(sw)
        e.printStackTrace(pw)
        val stackTrace = sw.toString()
        val stackTraceMessage =
                when (System.getenv("ENV").toUpperCase()) {
                    "STAGING" -> stackTrace
                    "PRODUCTION" -> null
                    else -> stackTrace
                }

        return ResponseEntity(ErrorResponse(status, message, stackTraceMessage), status)
    }

}