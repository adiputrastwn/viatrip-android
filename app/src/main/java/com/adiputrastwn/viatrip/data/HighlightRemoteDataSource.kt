package com.adiputrastwn.viatrip.data

import com.adiputrastwn.viatrip.data.mock.MockApi
import com.adiputrastwn.viatrip.models.Highlight
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HighlightRemoteDataSource @Inject constructor(
    private val viaTripApi: ViaTripApi,
    private val mockApi: MockApi
) {
    val latestHighlight: Flow<List<Highlight>> = flow {
        while (true) {
            val latestHighlight = mockApi.fetchLatestHighlight()
            emit(latestHighlight) // Emits the result of the request to the flow
            delay(5000) // Suspends the coroutine for some time
        }
    }


}