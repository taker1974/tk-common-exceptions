# tk-common-exceptions: общеприменимые исключения от TKSoft

## Что это

Общеприменимые исключения.  
В данный модуль входят следующие классы исключений:

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

## Быстрый старт

```bash
mvn clean install
```

В вашем приложении, в pom.xml:

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

В вашем коде:

```Java
// Import class
import ru.spb.tksoft.common.exceptions.UserNotFoundException;

// Use exception
UserEntity owner = userRepository.findByUserId(request.getUserId())
        .orElseThrow(UserNotFoundException::new);

```

## Лицензирование

Этот модуль распространяется по лицензии Apache 2.0. Подробности см. в файле LICENSE.

## Автор

Константин Терских
Email: <kostus.online.1974@yandex.ru>, <kostus.online@gmail.com>
Санкт-Петербург, 2025 год
