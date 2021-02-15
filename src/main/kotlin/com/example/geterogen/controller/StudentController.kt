package com.example.geterogen.controller

import com.example.geterogen.model.Student
import com.example.geterogen.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/student")
class StudentController(private val service: StudentService) {

    @GetMapping
    fun index() = service.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) = service.findById(id)

    @GetMapping("/group/{id}")
    fun getByGroupId(@PathVariable id: Int) = service.getStudents(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody student: Student) = service.create(student)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = service.delete(id)

}