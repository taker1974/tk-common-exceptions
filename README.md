# tk-common-exceptions: Common Exceptions from TKSoft

## What is this

Common exceptions.
This module includes the following exception classes:

- [`BadRequestException`](src/main/java/ru/spb/tksoft/common/exception/BadRequestException.java)
- [`RequestFailedException`](src/main/java/ru/spb/tksoft/common/exception/RequestFailedException.java)
- [`ConfigurationMismatchException`](src/main/java/ru/spb/tksoft/common/exception/ConfigurationMismatchException.java)
- [`ConversionFailedException`](src/main/java/ru/spb/tksoft/common/exception/ConversionFailedException.java)
- [`DuplicateObjectException`](src/main/java/ru/spb/tksoft/common/exception/DuplicateObjectException.java)
- [`NullArgumentException`](src/main/java/ru/spb/tksoft/common/exception/NullArgumentException.java)
- [`ObjectAlreadyExistsException`](src/main/java/ru/spb/tksoft/common/exception/ObjectAlreadyExistsException.java)
- [`ObjectNotFoundException`](src/main/java/ru/spb/tksoft/common/exception/ObjectNotFoundException.java)
- [`UserNotFoundException`](src/main/java/ru/spb/tksoft/common/exception/UserNotFoundException.java)
- [`TkBaseException`](src/main/java/ru/spb/tksoft/common/exception/TkBaseException.java)

## Quick Start

```bash
mvn clean install
```

In your application, in pom.xml:

```xml
<properties>
    ...
    <tk-common-exceptions.version>1.0.0</tk-common-exceptions.version>
</properties>

<dependencies>
    <dependency>
        <groupId>ru.spb.tksoft</groupId>
        <artifactId>tk-common-exceptions</artifactId>
        <version>${tk-common-exceptions.version}</version>
    </dependency>
    ...
</dependencies>
```

In your code:

```java
// Import class
import ru.spb.tksoft.common.exception.UserNotFoundException;

// Use exception
UserEntity owner = userRepository.findByUserId(request.getUserId())
        .orElseThrow(UserNotFoundException::new);
```

## Licensing

This module is distributed under the Apache 2.0 license. See the LICENSE file for details.

## Author

Konstantin Terskikh
Email: <kostus.online.1974@yandex.ru>, <kostus.online@gmail.com>
Saint Petersburg, 2025
