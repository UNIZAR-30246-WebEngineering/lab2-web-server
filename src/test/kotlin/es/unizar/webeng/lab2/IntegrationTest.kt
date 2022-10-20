package es.unizar.webeng.lab2

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header

/**
 * Integration test for the class src/main/kotlin/es/unizar/webeng/lab2/TimeComponent.kt
 *
 * Collection of integration tests to check the operation of the server.
 */
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc(addFilters = false)
class IntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    /**
     * Test to validate that the cors are active running.
     */
    @Test
    fun testCors() {
        mockMvc.perform(get("/time").header("Origin", "http://localhost:3000"))
            .andExpect(header().string("Access-Control-Allow-Origin", "http://localhost:3000"))
    }
}
