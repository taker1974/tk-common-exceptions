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
 * Tests for DuplicateObjectException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
class DuplicateObjectExceptionTest {

    @Test
    void testDefaultConstructor() {
        // Given & When
        DuplicateObjectException exception = new DuplicateObjectException();

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(DuplicateObjectException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(DuplicateObjectException.MESSAGE);
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "User with email already exists";

        // When
        DuplicateObjectException exception = new DuplicateObjectException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(DuplicateObjectException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Duplicate object: User with email already exists");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithCause() {
        // Given
        Throwable cause = new IllegalArgumentException("Duplicate key");

        // When
        DuplicateObjectException exception = new DuplicateObjectException(cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(DuplicateObjectException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(DuplicateObjectException.MESSAGE);
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstructorWithSubMessageAndCause() {
        // Given
        Throwable cause = new IllegalStateException("Constraint violation");
        String subMessage = "Order already processed";

        // When
        DuplicateObjectException exception = new DuplicateObjectException(subMessage, cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(DuplicateObjectException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Duplicate object: Order already processed");
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(DuplicateObjectException.CODE).isEqualTo(7390);
        Assertions.assertThat(DuplicateObjectException.MESSAGE).isEqualTo("Duplicate object");
    }
}

