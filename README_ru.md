# tk-common-exceptions: общие исключения TKSoft

## Что это

Небольшая библиотека непроверяемых исключений с числовыми кодами, общими сообщениями и структурированным логированием при создании экземпляра (см. JavaDoc у `TkBaseException`).

Требуется **Java 21**. Поставляется как JPMS-модуль (`module ru.spb.tksoft.common.exceptions`).

### Классы исключений

У каждого конкретного типа исключения объявлена публичная константа `CODE` (число, передаваемое в `TkBaseException` и доступное через `getCode()`). У базового класса фиксированного кода нет.

| Класс | `CODE` | Файл |
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

### Зависимости (runtime)

- **SLF4J** (`org.slf4j:slf4j-api`) — API логирования.
- **tk-log-utils** — обёртки для структурированного лога, используются в `TkBaseException`.

В приложении нужна привязка SLF4J (например Logback). Зависимость `logback-classic` в артефакте **опциональна** и используется в тестах; в runtime не обязательна.

### Контракт логирования

При каждом создании подкласса `TkBaseException` вызывается структурированная запись уровня **error** через SLF4J (через `tk-log-utils`). Это ожидаемое поведение: исключение одновременно сигнал и точка трассировки. Не создавайте такие исключения только ради строки в логе.

## Быстрый старт

```bash
mvn clean install
```

В `pom.xml` приложения:

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

В `module-info.java`:

```java
requires ru.spb.tksoft.common.exceptions;
```

В коде:

```java
import ru.spb.tksoft.common.exceptions.UserNotFoundException;

var owner = userRepository.findByUserId(request.getUserId())
        .orElseThrow(UserNotFoundException::new);
```

## Лицензирование

Модуль распространяется по лицензии Apache 2.0. Подробности см. в файле LICENSE.

## Автор

Константин Терских  
Email: `kostus.online.1974@yandex.ru`, `kostus.online@gmail.com`  
Санкт-Петербург 2025-2026

Англоязычная версия: [README.md](README.md).
