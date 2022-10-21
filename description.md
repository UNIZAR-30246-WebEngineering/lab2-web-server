# Description of the contents of this project

## [CORS](https://developer.mozilla.org/es/docs/Web/HTTP/CORS)

### What is CORS?

CORS is a mechanism that uses additional HTTP headers to tell browsers to give a web application running at one origin, access to selected resources from a different origin. A web application executes a cross-origin HTTP request when it requests a resource that has a different origin (domain, protocol, or port) from its own.

### How to enable CORS?

To enable CORS, we need to add the following annotation to the class that contains the controller methods:

```java
@CrossOrigin(origins = "*")
```   

you can find more options in this article: [Spring Boot CORS Configuration](https://reflectoring.io/spring-cors/)

### How to test it?

To test it, first we must ignore the certificate of the server, to do this we have to start the class `IntegrationTest` with the following VM options:

```java
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc(addFilters = false)
```

Then we can test the CORS with the following test:

```java
@Test
  fun testCors() {
    mockMvc.perform(get("/time").header("Origin", "http://localhost:3000"))
      .andExpect(header().string("Access-Control-Allow-Origin", "http://localhost:3000"))
  }
```