package com.example.geterogen.controller


import com.example.geterogen.model.Student
import com.example.geterogen.model.StudyGroup
import com.example.geterogen.service.StudyGroupService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/group")
class StudyGroupController(private val service: StudyGroupService) {

    @GetMapping
    fun index() = service.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) = service.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody studyGroup: StudyGroup) = service.create(studyGroup)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = service.delete(id)

}