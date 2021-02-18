package com.example.geterogen.exceptions

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus
import java.util.*

class ErrorResponse(
        status: HttpStatus,
        val message: String,
        var stackTrace: String? = null
) {

    val code: Int = status.value()
    val status: String = status.name
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
    val timestamp: Date = Date()
}