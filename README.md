# Spring Boot 4 - Demo for possible bug with multiple @EnableJpaRepositories

This project shows a possible bug with multiple @EnableJpaRepositories in Spring Boot 4.

With the Version `3.5.8` this project works as expected.
But with `4.0.0` run with AOT enabled, the application fails with an exception.

## Build and run

```
mvn package -P springAot
```

Then run with `-Dspring.aot.enabled=true`.

IntelliJ run configurations are included.