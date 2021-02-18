package com.example.geterogen.repository

import com.example.geterogen.model.Student
import org.springframework.data.repository.CrudRepository


interface StudentRepository: CrudRepository<Student, Int> {
    fun findAllByGroupName(groupName: String): Iterable<Student>
}