package com.example.geterogen.model

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "journal")
class Journal(
        @ManyToOne
        var student: Student,
        @ManyToOne
        var studyPlan: StudyPlan,
        var inTime: Boolean,
        var count: Int,
        @ManyToOne
        var mark: Mark
): BaseEntity<Int>()