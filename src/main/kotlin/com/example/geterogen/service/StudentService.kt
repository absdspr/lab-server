package com.example.geterogen.service

import com.example.geterogen.model.Student
import com.example.geterogen.repository.StudentRepository
import com.example.geterogen.repository.StudyGroupRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
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

    /**
     * Редактирование информации о студенте
     */
    fun edit(id: Int, student: Student): Student{
        val oldStudent = repository.findById(id).get()
        oldStudent.name = student.name
        oldStudent.surname = student.surname
        oldStudent.secondName = student.secondName
        oldStudent.group = student.group
        return repository.save(oldStudent)

    }

}