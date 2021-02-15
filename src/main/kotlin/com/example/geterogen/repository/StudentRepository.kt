package com.example.geterogen.repository

import com.example.geterogen.model.Student
import com.example.geterogen.model.StudyGroup
import org.springframework.data.repository.CrudRepository

interface StudentRepository: CrudRepository<Student, Int> {
    fun findAllByGroup(group: StudyGroup)
}