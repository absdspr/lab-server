package com.example.geterogen.model


import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "study_group")
class StudyGroup(
        @Column(unique = true)
        var name: String,

): BaseEntity<Int>()