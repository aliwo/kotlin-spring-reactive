package com.wesang.common.util

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.time.ZoneOffset
import java.util.TimeZone

/* *
 * 2024-04-09 DNU 의 JacksonUtil 을 가져왔다.
 */
object JacksonUtil {
    private fun createObjectMapper(): ObjectMapper {
        val kotlinModule = KotlinModule.Builder().build()
        return JsonMapper.builder().addModule(kotlinModule).disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).build()
    }

    fun createSnakeCaseObjectMapper(): ObjectMapper = createObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)

    fun createSnakeCaseAndTimeZoneObjectMapper(): ObjectMapper =
        createSnakeCaseObjectMapper()
            .setTimeZone(TimeZone.getTimeZone(ZoneOffset.UTC))
            .registerModule(JavaTimeModule())
}
