package com.example.geterogen.model

import javax.persistence.Entity

@Entity
class StudentLocal (
    var name: String,
    var surname: String,
    var secondName: String,
    var study_group_id: Int,
): BaseEntity<Int>()