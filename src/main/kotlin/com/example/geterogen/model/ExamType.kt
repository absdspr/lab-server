package com.example.geterogen.model


import javax.persistence.*

@Entity
@Table(name = "exam_type")
class ExamType(
        var type: String,
): BaseEntity<Int>()