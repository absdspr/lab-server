package com.example.geterogen.model


import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "mark")
class Mark(
        var name: String,
        var value: String,

): BaseEntity<Int>()