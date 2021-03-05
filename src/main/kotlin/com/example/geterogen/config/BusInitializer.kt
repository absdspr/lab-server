package com.example.geterogen.config

import com.example.geterogen.model.Student
import com.example.geterogen.model.StudentBus
import com.example.geterogen.repository.StudentRepository
import net.progruzovik.bus.replication.Replicator
import org.springframework.context.annotation.DependsOn
import org.springframework.stereotype.Component
import java.io.IOException
import javax.annotation.PostConstruct
import kotlin.jvm.Throws


@Component
@DependsOn("busHandler")
class BusInitializer(private val replicator: Replicator, private val repository: StudentRepository) {
    @PostConstruct
    @Throws(IOException::class)
    fun init() {
        val students: Iterable<Student> = repository.findAllQuery()
        var studentsToBus: MutableList<StudentBus> = mutableListOf()
        for (student in students) {
            val student2 = student.group.id?.let { StudentBus(student.name, student.surname, student.secondName, it) }
            if (student2 != null) {
                studentsToBus.add(student2)
            }
        }
        initEntity("student", studentsToBus)
    }

    @Throws(IOException::class)
    private fun <T> initEntity(name: String, data: Iterable<T>) {
        replicator.initializeEntity(name)
        for (row in data) {
            // Workaround because orm parses study group as object, instead of i
            replicator.addRow(name, row)
        }
    }

}