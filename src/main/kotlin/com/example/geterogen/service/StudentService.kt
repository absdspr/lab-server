package com.example.geterogen.service

import com.example.geterogen.model.Student
import com.example.geterogen.model.StudyGroup
import com.example.geterogen.repository.StudentRepository
import com.example.geterogen.repository.StudyGroupRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentService(private val repository: StudentRepository,
                     private val groupRepository: StudyGroupRepository
) {

    /**
     * Все студенты
     */
    fun findAll() = repository.findAll()

    /**
     * Студент по id
     */
    fun findById(id: Int) = repository.findById(id)

    /**
     * Студенты в группе по id
     */
    fun getStudents(id: Int): List<Student> {
        val group = groupRepository.findById(id).get()
        return group.students
    }
    /**
     * Создание студента
     */
    fun create(student: Student) = repository.save(student)

    /**
     * Удаление студента
     */
    fun delete(id: Int) = repository.deleteById(id)

}