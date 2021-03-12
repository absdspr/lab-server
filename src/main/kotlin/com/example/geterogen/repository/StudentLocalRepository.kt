package com.example.geterogen.repository

import com.example.geterogen.model.StudentLocal
import org.springframework.data.repository.CrudRepository

interface StudentLocalRepository: CrudRepository<StudentLocal, Int> {
}