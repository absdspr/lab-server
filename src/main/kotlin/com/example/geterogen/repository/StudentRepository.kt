package com.example.geterogen.repository

import com.example.geterogen.model.Student
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface StudentRepository: CrudRepository<Student, Int> {
    fun findAllByGroupName(groupName: String): Iterable<Student>

    @Query(value = "SELECT * FROM student", nativeQuery = true)
    fun findAllQuery(): Iterable<Student>
}