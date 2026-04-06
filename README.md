# tk-common-exceptions: Common Exceptions from TKSoft

## What is this

Small Java library of unchecked exceptions with numeric error codes, shared messages, and structured logging on construction (see `TkBaseException` JavaDoc).

Requires **Java 21**. Published as a JPMS module (`module ru.spb.tksoft.common.exceptions`).

### Exception classes

Each concrete exception type defines a public `CODE` constant (the numeric value passed to `TkBaseException` and exposed via `getCode()`). The base class has no fixed code.

| Class | `CODE` | File |
| --- | ---: | --- |
| `TkBaseException` | — | [`TkBaseException.java`](src/main/java/ru/spb/tksoft/common/exceptions/TkBaseException.java) |
| `BadRequestException` | 400 | [`BadRequestException.java`](src/main/java/ru/spb/tksoft/common/exceptions/BadRequestException.java) |
| `ConfigurationMismatchException` | 2583 | [`ConfigurationMismatchException.java`](src/main/java/ru/spb/tksoft/common/exceptions/ConfigurationMismatchException.java) |
| `ConversionFailedException` | 893 | [`ConversionFailedException.java`](src/main/java/ru/spb/tksoft/common/exceptions/ConversionFailedException.java) |
| `DataIntegrityViolationException` | 409 | [`DataIntegrityViolationException.java`](src/main/java/ru/spb/tksoft/common/exceptions/DataIntegrityViolationException.java) |
| `DuplicateObjectException` | 7390 | [`DuplicateObjectException.java`](src/main/java/ru/spb/tksoft/common/exceptions/DuplicateObjectException.java) |
| `FeignClientException` | 8943 | [`FeignClientException.java`](src/main/java/ru/spb/tksoft/common/exceptions/FeignClientException.java) |
| `ForbiddenException` | 1325 | [`ForbiddenException.java`](src/main/java/ru/spb/tksoft/common/exceptions/ForbiddenException.java) |
| `InternalServerErrorException` | 500 | [`InternalServerErrorException.java`](src/main/java/ru/spb/tksoft/common/exceptions/InternalServerErrorException.java) |
| `JwtTokenException` | 128 | [`JwtTokenException.java`](src/main/java/ru/spb/tksoft/common/exceptions/JwtTokenException.java) |
| `NotImplementedException` | 3348 | [`NotImplementedException.java`](src/main/java/ru/spb/tksoft/common/exceptions/NotImplementedException.java) |
| `NullArgumentException` | 225 | [`NullArgumentException.java`](src/main/java/ru/spb/tksoft/common/exceptions/NullArgumentException.java) |
| `NullOrEmptyArgumentException` | 226 | [`NullOrEmptyArgumentException.java`](src/main/java/ru/spb/tksoft/common/exceptions/NullOrEmptyArgumentException.java) |
| `NullOrNegativeArgumentException` | 6284 | [`NullOrNegativeArgumentException.java`](src/main/java/ru/spb/tksoft/common/exceptions/NullOrNegativeArgumentException.java) |
| `ObjectAlreadyExistsException` | 5371 | [`ObjectAlreadyExistsException.java`](src/main/java/ru/spb/tksoft/common/exceptions/ObjectAlreadyExistsException.java) |
| `ObjectNotFoundException` | 8874 | [`ObjectNotFoundException.java`](src/main/java/ru/spb/tksoft/common/exceptions/ObjectNotFoundException.java) |
| `RequestFailedException` | 8942 | [`RequestFailedException.java`](src/main/java/ru/spb/tksoft/common/exceptions/RequestFailedException.java) |
| `UnauthorizedException` | 1324 | [`UnauthorizedException.java`](src/main/java/ru/spb/tksoft/common/exceptions/UnauthorizedException.java) |
| `UserNotFoundException` | 892 | [`UserNotFoundException.java`](src/main/java/ru/spb/tksoft/common/exceptions/UserNotFoundException.java) |

### Dependencies (runtime)

- **SLF4J** (`org.slf4j:slf4j-api`) — logging API.
- **tk-log-utils** — structured logging helpers used by `TkBaseException`.

Your application must provide an SLF4J binding (e.g. Logback). The `logback-classic` dependency in this artifact is **optional** and is only used for tests (e.g. `ListAppender`); it is not required at runtime.

### Logging contract

Every time a `TkBaseException` subclass is constructed, a structured **error** log is emitted via SLF4J (through `tk-log-utils`). This is intentional: the exception is both the signal and a traceability hook. Do not throw these types only to “force” a log line.

## Quick start

```bash
mvn clean install
```

In your application `pom.xml`:

```xml
<properties>
    <tk-common-exceptions.version>2.0.9</tk-common-exceptions.version>
</properties>

<dependencies>
    <dependency>
        <groupId>ru.spb.tksoft</groupId>
        <artifactId>tk-common-exceptions</artifactId>
        <version>${tk-common-exceptions.version}</version>
    </dependency>
</dependencies>
```

`module-info.java`:

```java
requires ru.spb.tksoft.common.exceptions;
```

In code:

```java
import ru.spb.tksoft.common.exceptions.UserNotFoundException;

var owner = userRepository.findByUserId(request.getUserId())
        .orElseThrow(UserNotFoundException::new);
```

## Licensing

This module is distributed under the Apache 2.0 license. See the LICENSE file for details.

## Author

Konstantin Terskikh  
Email: `kostus.online.1974@yandex.ru`, `kostus.online@gmail.com`  
Saint Petersburg

Russian documentation: [README_ru.md](README_ru.md).
