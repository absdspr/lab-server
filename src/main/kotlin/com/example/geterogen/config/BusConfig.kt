package com.example.geterogen.config

import com.fasterxml.jackson.databind.ObjectMapper
import net.progruzovik.bus.dao.EntityDao
import net.progruzovik.bus.dao.EntityJdbc
import net.progruzovik.bus.dao.InstanceDao
import net.progruzovik.bus.dao.InstanceJdbc
import net.progruzovik.bus.message.*
import net.progruzovik.bus.replication.ReplicationService
import net.progruzovik.bus.replication.Replicator
import net.progruzovik.bus.util.CharBufferNameConverter
import net.progruzovik.bus.util.EntityNameConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.client.RestTemplate


@Configuration
@EnableScheduling
@PropertySource("classpath:bus.properties")
class BusConfig {
    @Value("\${bus.instance.address}")
    private val address: String? = null

    @Value("\${bus.dean.address}")
    private val deanAddress: String? = null

    @Value("\${bus.integration.url}")
    private val integrationUrl: String? = null

    @Bean
    fun replicator(mapper: ObjectMapper?, writer: Writer?, instanceDao: InstanceDao?, entityDao: EntityDao?): Replicator {
        return ReplicationService(mapper, writer, instanceDao, entityDao)
    }

    @Bean
    fun restReceiver(restTemplate: RestTemplate?, busHandler: BusHandler?): RestReceiver {
        return BusRestReceiver(integrationUrl!!, restTemplate!!, busHandler!!)
    }

    @Bean
    fun busHandler(mapper: ObjectMapper?, writer: Writer?, instanceDao: InstanceDao?, entityDao: EntityDao?): BusHandler {
        return MessageHandler(mapper, writer, instanceDao, entityDao,
                deanAddress)
    }

    @Bean
    fun writer(mapper: ObjectMapper?, messageSender: MessageSender?,
               instanceDao: InstanceDao?): Writer {
        return MessageWriter(mapper, messageSender, instanceDao)
    }

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun messageSender(restTemplate: RestTemplate?): MessageSender {
        return RestSender(address!!, integrationUrl!!, restTemplate!!)
    }

    @Bean
    fun entityNameConverter(): EntityNameConverter {
        return CharBufferNameConverter()
    }

    @Bean
    fun instanceDao(entityNameConverter: EntityNameConverter?,
                    jdbcTemplate: JdbcTemplate?): InstanceDao {
        return InstanceJdbc(entityNameConverter, jdbcTemplate)
    }

    @Bean
    fun entityDao(entityNameConverter: EntityNameConverter?, jdbcTemplate: JdbcTemplate?): EntityDao {
        return EntityJdbc(entityNameConverter, jdbcTemplate)
    }
}