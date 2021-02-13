package com.example.geterogen.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*


@Entity
@Table(name = "mark")
data class Mark(
        @Id
        @JsonProperty("id")
        @Column(name = "id")
        val id: Int = 0,
        @JsonProperty("name")
        @Column(name = "name")
        val name: String = "",
        @JsonProperty("value")
        @Column(name = "value")
        val value: String = ""
)