package com.example.geterogen.service

import net.progruzovik.bus.message.RestReceiver
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.io.IOException
import java.time.Instant
import kotlin.jvm.Throws


@Service
internal class MessageChecker(private val restReceiver: RestReceiver) {
    @Volatile
    private var lastCheckTime: Instant? = null

    @Scheduled(fixedDelay = 3000)
    @Synchronized
    fun checkMessages() {
        lastCheckTime = restReceiver.receiveMessages(lastCheckTime)
    }

}