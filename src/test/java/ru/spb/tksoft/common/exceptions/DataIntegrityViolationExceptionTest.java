/*
 * Copyright 2026 Konstantin Terskikh
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
 * Tests for DataIntegrityViolationException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2026
 */
class DataIntegrityViolationExceptionTest {

    @Test
    void testDefaultConstructor() {
        // Given & When
        DataIntegrityViolationException exception = new DataIntegrityViolationException();

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(DataIntegrityViolationException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo(DataIntegrityViolationException.MESSAGE);
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "Unique constraint violation";

        // When
        DataIntegrityViolationException exception = new DataIntegrityViolationException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(DataIntegrityViolationException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Data integrity violation: Unique constraint violation");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithNullSubMessage() {
        DataIntegrityViolationException exception = new DataIntegrityViolationException((String) null);
        Assertions.assertThat(exception.getMessage()).isEqualTo("Data integrity violation: null");
        Assertions.assertThat(exception.getCode()).isEqualTo(DataIntegrityViolationException.CODE);
    }

    @Test
    void testConstructorWithCause() {
        // Given
        Throwable cause = new IllegalArgumentException("Invalid payload");

        // When
        DataIntegrityViolationException exception = new DataIntegrityViolationException(cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(DataIntegrityViolationException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo(DataIntegrityViolationException.MESSAGE);
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstructorWithSubMessageAndCause() {
        // Given
        Throwable cause = new IllegalStateException("Broken state");
        String subMessage = "Foreign key constraint violation";

        // When
        DataIntegrityViolationException exception =
                new DataIntegrityViolationException(subMessage, cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(DataIntegrityViolationException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Data integrity violation: Foreign key constraint violation");
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(DataIntegrityViolationException.CODE).isEqualTo(409);
        Assertions.assertThat(DataIntegrityViolationException.MESSAGE)
                .isEqualTo("Data integrity violation");
    }

    @Test
    void constructorEmitsErrorThroughSlf4jLoggerForTkBaseException() {
        TkBaseExceptionLoggingAssertions.assertErrorLoggedWhenConstructorRuns(
                DataIntegrityViolationException::new);
    }
}

