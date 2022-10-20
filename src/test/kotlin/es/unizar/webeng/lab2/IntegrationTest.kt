package es.unizar.webeng.lab2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

/**
 * Integration test for the class src/main/kotlin/es/unizar/webeng/lab2/TimeComponent.kt
 *
 * Collection of integration tests to check the operation of the server.
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
class IntegrationTest {

    /**
     * The annotation [LocalServerPort] tells the test runner that
     * it must inject in [port] the HTTP port that got allocated at runtime.
     * Useful for building URI when the [web environment][SpringBootTest.webEnvironment]
     * is set to use a [random port][WebEnvironment.RANDOM_PORT].
     */
    @LocalServerPort
    private var port: Int = 0

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
