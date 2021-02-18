package com.example.geterogen.service


import com.example.geterogen.model.Journal
import com.example.geterogen.repository.JournalRepository
import org.springframework.stereotype.Service

@Service
class JournalService(private val repository: JournalRepository) {
    fun findById(id: Int) = repository.findById(id)

    fun findAll() = repository.findAll()

    fun create(journal: Journal): Journal = repository.save(journal)

    fun findByGroup(group: String) = repository.findAllByStudentGroupName(group)

    fun findByStudentId(id: Int) = repository.findAllByStudentId(id)
}
