package com.example.geterogen.model

import javax.persistence.JoinColumn
import javax.persistence.ManyToOne


class StudentBus (
    var name: String,
    var surname: String,
    var secondName: String,
    var study_group_id: Int,
)