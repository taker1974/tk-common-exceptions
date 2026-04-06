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
 * Tests for NullOrEmptyArgumentException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025-2026
 */
class NullOrEmptyArgumentExceptionTest {

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "userId parameter";

        // When
        NullOrEmptyArgumentException exception = new NullOrEmptyArgumentException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(NullOrEmptyArgumentException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Argument must not be null or empty: userId parameter");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithNullSubMessage() {
        // Given
        String subMessage = null;

        // When
        NullOrEmptyArgumentException exception = new NullOrEmptyArgumentException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(NullOrEmptyArgumentException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Argument must not be null or empty: null");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithCause() {
        // Given
        Throwable cause = new IllegalArgumentException("empty value");

        // When
        NullOrEmptyArgumentException exception = new NullOrEmptyArgumentException(cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(NullOrEmptyArgumentException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo(NullOrEmptyArgumentException.MESSAGE);
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstructorWithSubMessageAndCause() {
        // Given
        Throwable cause = new IllegalStateException("invalid state");
        String subMessage = "customerId";

        // When
        NullOrEmptyArgumentException exception = new NullOrEmptyArgumentException(subMessage, cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(NullOrEmptyArgumentException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Argument must not be null or empty: customerId");
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(NullOrEmptyArgumentException.CODE).isEqualTo(226);
        Assertions.assertThat(NullOrEmptyArgumentException.MESSAGE)
                .isEqualTo("Argument must not be null or empty");
    }

    @Test
    void constructorEmitsErrorThroughSlf4jLoggerForTkBaseException() {
        TkBaseExceptionLoggingAssertions.assertErrorLoggedWhenConstructorRuns(
                () -> new NullOrEmptyArgumentException("logged-on-construct"));
    }
}

