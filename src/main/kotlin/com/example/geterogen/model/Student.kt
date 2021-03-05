package com.example.geterogen.model

import com.fasterxml.jackson.annotation.JsonBackReference

import javax.persistence.*

@Entity
@Table(name = "student")
class Student(
        var name: String,
        var surname: String,
        var secondName: String,

        @ManyToOne()
        @JoinColumn(name = "study_group_id",)
//        @JsonBackReference
        var group: StudyGroup
): BaseEntity<Int>()