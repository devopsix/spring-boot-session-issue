# Spring Boot / Spring Session Issue

The 2 modules `spring-boot-2.7` and `spring-boot-3.0` contain test applications which are identical except for the Spring Boot version (2.7.6 vs. 3.0.0).

While applying `PostgreSqlJdbcIndexedSessionRepositoryCustomizer` works as expected with Spring Boot 2.7
(SQL query for creating session attributes is modified to handle conflicting inserts) it does seem to be ignored
with Spring Boot 3.0.

## Spring Boot 2.7

```
mvn -f spring-boot-2.7/pom.xml verify
```

Will print something like this:

```
2022-12-05 15:08:07.234 DEBUG 6284 --- [o-auto-1-exec-1] o.s.jdbc.core.JdbcTemplate               : Executing prepared SQL statement [INSERT INTO SPRING_SESSION_ATTRIBUTES (SESSION_PRIMARY_ID, ATTRIBUTE_NAME, ATTRIBUTE_BYTES) VALUES
 (?, ?, ?) ON CONFLICT (SESSION_PRIMARY_ID, ATTRIBUTE_NAME) DO UPDATE SET ATTRIBUTE_BYTES = EXCLUDED.ATTRIBUTE_BYTES]
```

The _presence_ of `ON CONFLICT ...` means the modified SQL query is being used.

## Spring Boot 3.0

```
mvn -f spring-boot-3.0/pom.xml verify
```

Will print something like this:

```
2022-12-05T15:08:52.170+01:00 DEBUG 13560 --- [o-auto-1-exec-1] o.s.jdbc.core.JdbcTemplate               : Executing prepared SQL statement [INSERT INTO SPRING_SESSION_ATTRIBUTES (SESSION_PRIMARY_ID, ATTRIBUTE_NAME, ATTRIBUTE_BYTES)
VALUES (?, ?, ?)
]

```

The _absence_ of `ON CONFLICT ...` means the modified SQL query is _not_ being used.
