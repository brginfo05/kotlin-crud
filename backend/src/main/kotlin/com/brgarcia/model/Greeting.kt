package com.brgarcia.model

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

data class Greeting(
        @field:[NotNull Min(value = 1) Max(value = 10)]
        val id: Long = 0,

        @field:NotNull
        val content: String? = null
)