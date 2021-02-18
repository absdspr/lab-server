package com.example.geterogen.model

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "study_plan")
class StudyPlan(
        @ManyToOne
        var examType: ExamType,
        @ManyToOne
        var subject: Subject
): BaseEntity<Int>()