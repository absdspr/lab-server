package com.example.geterogen.model


import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "study_group")
class StudyGroup(
        @Column(unique = true)
        var name: String,

//        @OneToMany(
//                mappedBy = "group",
//                fetch = FetchType.LAZY,
//                orphanRemoval = true,
//                cascade = [CascadeType.ALL]
//        )
//        @JsonManagedReference
//        var students: MutableList<Student> = mutableListOf()
): BaseEntity<Int>() {
//        fun addStudent(student: Student) {
//                students.add(student)
//        }
//        fun removeStudent(student: Student) {
//                students.remove(student)
//        }
}
