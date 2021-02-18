package com.example.geterogen.repository

import com.example.geterogen.model.StudyGroup
import org.springframework.data.repository.CrudRepository

interface StudyGroupRepository: CrudRepository<StudyGroup, Int> {
}