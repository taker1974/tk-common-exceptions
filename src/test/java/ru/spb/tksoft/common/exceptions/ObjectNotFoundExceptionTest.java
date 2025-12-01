/*
 * Copyright 2025 Konstantin Terskikh
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package ru.spb.tksoft.common.exceptions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for ObjectNotFoundException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
class ObjectNotFoundExceptionTest {

    @Test
    void testDefaultConstructor() {
        // Given & When
        ObjectNotFoundException exception = new ObjectNotFoundException();

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ObjectNotFoundException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(ObjectNotFoundException.MESSAGE);
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "Project with id 123 not found";

        // When
        ObjectNotFoundException exception = new ObjectNotFoundException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ObjectNotFoundException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Object not found: Project with id 123 not found");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithCause() {
        // Given
        Throwable cause = new IllegalArgumentException("Missing object");

        // When
        ObjectNotFoundException exception = new ObjectNotFoundException(cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ObjectNotFoundException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(ObjectNotFoundException.MESSAGE);
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstructorWithSubMessageAndCause() {
        // Given
        Throwable cause = new IllegalStateException("Lookup failure");
        String subMessage = "User not found";

        // When
        ObjectNotFoundException exception = new ObjectNotFoundException(subMessage, cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ObjectNotFoundException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo("Object not found: User not found");
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(ObjectNotFoundException.CODE).isEqualTo(8874);
        Assertions.assertThat(ObjectNotFoundException.MESSAGE).isEqualTo("Object not found");
    }
}

