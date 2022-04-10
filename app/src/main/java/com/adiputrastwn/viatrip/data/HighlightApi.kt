package com.adiputrastwn.viatrip.data

import com.adiputrastwn.viatrip.models.Highlight
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

interface ViaTripApi {
    suspend fun fetchLatestHighlight(): List<Highlight>
}

class ViaTripApiImpl : ViaTripApi {
    override suspend fun fetchLatestHighlight(): List<Highlight> {
        return listOf()
    }
}