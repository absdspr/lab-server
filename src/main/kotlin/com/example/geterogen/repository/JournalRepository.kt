package com.example.geterogen.repository

import com.example.geterogen.model.Journal
import com.example.geterogen.model.Mark
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface JournalRepository : CrudRepository<Journal, Int> {
    fun findAllByStudentId(id: Int): Iterable<Journal>

    fun findAllByStudentGroupName(group: String): Iterable<Journal>

    @Modifying
    @Query("update Journal j set j.mark = :mark where j.id = :id")
    fun setMarkForJournal(@Param("mark") mark: Mark, @Param("id") id: Int)
}