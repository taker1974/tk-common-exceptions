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
 * Tests for InvalidKeyException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
class InvalidKeyExceptionTest {

    @Test
    void testDefaultConstructor() {
        // Given & When
        InvalidKeyException exception = new InvalidKeyException();

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(InvalidKeyException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(InvalidKeyException.MESSAGE);
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "key length mismatch";

        // When
        InvalidKeyException exception = new InvalidKeyException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(InvalidKeyException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Invalid key: key length mismatch");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithNullSubMessage() {
        InvalidKeyException exception = new InvalidKeyException((String) null);
        Assertions.assertThat(exception.getMessage()).isEqualTo("Invalid key: null");
        Assertions.assertThat(exception.getCode()).isEqualTo(InvalidKeyException.CODE);
    }

    @Test
    void testConstructorWithCause() {
        // Given
        Throwable cause = new IllegalArgumentException("Unsupported key algorithm");

        // When
        InvalidKeyException exception = new InvalidKeyException(cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(InvalidKeyException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(InvalidKeyException.MESSAGE);
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstructorWithSubMessageAndCause() {
        // Given
        Throwable cause = new IllegalStateException("Signing failed");
        String subMessage = "HMAC secret invalid";

        // When
        InvalidKeyException exception = new InvalidKeyException(subMessage, cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(InvalidKeyException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Invalid key: HMAC secret invalid");
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(InvalidKeyException.CODE).isEqualTo(129);
        Assertions.assertThat(InvalidKeyException.MESSAGE).isEqualTo("Invalid key");
    }

    @Test
    void constructorEmitsErrorThroughSlf4jLoggerForTkBaseException() {
        TkBaseExceptionLoggingAssertions.assertErrorLoggedWhenConstructorRuns(InvalidKeyException::new);
    }
}
