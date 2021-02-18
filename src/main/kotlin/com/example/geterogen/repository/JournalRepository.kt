package com.example.geterogen.repository

import com.example.geterogen.model.Journal
import org.springframework.data.repository.CrudRepository

interface JournalRepository : CrudRepository<Journal, Int> {
    fun findAllByStudentId(id: Int): Iterable<Journal>

    fun findAllByStudentGroupName(group: String): Iterable<Journal>
}