package com.adiputrastwn.viatrip.data.mock

import com.adiputrastwn.viatrip.data.ViaTripApi
import com.adiputrastwn.viatrip.models.Highlight
import java.util.*

class MockApi : ViaTripApi {
    override suspend fun fetchLatestHighlight(): List<Highlight> {
        return listOf(
            Highlight(
                UUID.randomUUID().toString(),
                "Senggigi Beach",
                "Lombok, Indonesia",
                "https://www.travelercantik.com/wp-content/uploads/2019/04/pantai-hotel-Kila-Senggigi.jpg"
            ),
            Highlight(
                UUID.randomUUID().toString(),
                "Kuta Beach",
                "Bali, Indonesia",
                "https://www.indonesia.travel/content/dam/indtravelrevamp/en/destinations/bali-nusa-tenggara/bali/kuta/point-of-interest/kuta-beach/6b1ff037123bb1ad2387bdadcac21bc1a8e94b4b-b6bc7.jpg"
            ),
            Highlight(
                UUID.randomUUID().toString(),
                "Jimbaran Beach",
                "Bali, Indonesia",
                "https://media.tacdn.com/media/attractions-splice-spp-674x446/07/18/1c/ac.jpg"
            )
        )
    }
}