package com.brgarcia

import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
data class Greeting(
        @field:[Id Min(value = 1) Max(value = 10)]
        val id: Long = 0,
        val content: String = ""
)