package com.example.geterogen.repository

import com.example.geterogen.model.Mark
import org.springframework.data.repository.CrudRepository

interface MarkRepository : CrudRepository<Mark, Int>