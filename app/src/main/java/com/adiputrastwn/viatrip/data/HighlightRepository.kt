package com.adiputrastwn.viatrip.data

import com.adiputrastwn.viatrip.models.Highlight
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Singleton

class HighlightRepository @Inject constructor(
    highlightRemoteDataSource: HighlightRemoteDataSource
) {
    val latestHighlights: Flow<List<Highlight>> =
        highlightRemoteDataSource.latestHighlight
    // Intermediate operation to filter the list of favorite topics
    //.map { news -> news.filter { userData.isFavoriteTopic(it) } }
    // Intermediate operation to save the latest news in the cache
    //.onEach { news -> saveInCache(news) }
}