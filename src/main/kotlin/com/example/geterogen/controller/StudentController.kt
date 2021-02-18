package com.example.geterogen.controller

import com.example.geterogen.model.Student
import com.example.geterogen.model.StudyGroup
import com.example.geterogen.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/student")
class StudentController(private val service: StudentService) {

    @GetMapping
    fun index(@RequestParam(required = false) group: String?): Iterable<Student> {
        group?.let {
            return service.findByGroup(group)
        }
       return service.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) = service.findById(id)


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody student: Student) = service.create(student)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = service.delete(id)

    @PutMapping("/{id}")
    fun edit(@PathVariable id: Int, @RequestBody student: Student) = service.edit(id, student)
}