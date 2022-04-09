package com.adiputrastwn.viatrip.data.mock

import com.adiputrastwn.viatrip.data.ViaTripApi
import com.adiputrastwn.viatrip.models.Highlight
import java.util.*

class MockApi : ViaTripApi {
    override suspend fun fetchLatestHighlight(): List<Highlight> {
        return listOf(
            Highlight(UUID.randomUUID().toString()),
            Highlight(UUID.randomUUID().toString()),
            Highlight(UUID.randomUUID().toString())
        )
    }
}