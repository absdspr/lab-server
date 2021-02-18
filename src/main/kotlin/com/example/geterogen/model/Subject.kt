package com.example.geterogen.model

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "subject")
class Subject(
        var name: String,
        var short_name: String
): BaseEntity<Int>()