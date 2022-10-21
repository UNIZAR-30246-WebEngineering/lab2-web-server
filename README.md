# Web Engineering 2022-2023 / Lab2 Web Server

Please, go to the [GUIDE](docs/GUIDE.md) in order to get the instructions for this assignment.

Some ideas for obtaining a :gift: if you are the first that:

- **Test-it**: Provides a JUnit-based validation of the tasks.
- **Other server is possible**: Uses a web server different from Tomcat and uses a JUnit-based test to prove it.
- **Compress-me**: Enables HTTP Response compression and uses a JUnit-based test to prove it.
- **I-like-XML**: Enables content negotiation in `/time` and provides a JUnit-based test to prove it.
- **CORS what?**: Enables [CORS](https://developer.mozilla.org/es/docs/Web/HTTP/CORS) support and provides a JUnit-based test to prove it.
- **No more static**: Replace the `error.html` file by a `ControllerAdvice` and provides a JUnit-based test to prove it.

Repository | NIA    | GitHub Action | Has gift
----------|--------|---------------|-----
[GueorguiKachan](https://github.com/GueorguiKachan/lab2-web-server/tree/work) |794999 | [![Build Status](https://github.com/GueorguiKachan/lab2-web-server/actions/workflows/CI.yml/badge.svg?branch=work&event=push)](https://github.com/GueorguiKachan/lab2-web-server/actions/workflows/CI.yml) | 
[HugoLazaro](https://github.com/HugoLazaro/lab2-web-server/tree/work) | 801758 | [![Build Status](https://github.com/HugoLazaro/lab2-web-server/actions/workflows/CI.yml/badge.svg?branch=work&event=push)](https://github.com/HugoLazaro/lab2-web-server/actions/workflows/CI.yml)
[ibon2](https://github.com/Ibon2/lab2-web-server/tree/work) | 776561 | [![Build Status](https://github.com/Ibon2/lab2-web-server/actions/workflows/CI.yml/badge.svg?branch=work&event=push)](https://github.com/Ibon2/lab2-web-server/actions/workflows/CI.yml)
[jbuil](https://github.com/jbuil/lab2-web-server/tree/work) | 797285 | [![Build Status](https://github.com/jbuil/lab2-web-server/actions/workflows/CI.yml/badge.svg?branch=work&event=push)](https://github.com/jbuil/lab2-web-server/actions/workflows/CI.yml) |
[Hec7or-Uni](https://github.com/Hec7or-Uni/lab2-web-server/tree/work)|798095|  [![Build Status](https://github.com/Hec7or-Uni/lab2-web-server/actions/workflows/CI.yml/badge.svg?branch=work&event=push)](https://github.com/Hec7or-Uni/lab2-web-server/actions/workflows/CI.yml)

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