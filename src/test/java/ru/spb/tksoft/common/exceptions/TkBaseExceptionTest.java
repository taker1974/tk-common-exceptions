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
 * Tests for TkBaseException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
class TkBaseExceptionTest {

    /**
     * Test exception for testing TkBaseException.
     */
    private static class TestException extends TkBaseException {

        private static final int CODE = 9999;
        private static final String MESSAGE = "Test exception";

        TestException() {
            super(CODE, MESSAGE);
        }

        TestException(String subMessage) {
            super(CODE, MESSAGE + ": " + subMessage);
        }

        TestException(Throwable cause) {
            super(CODE, MESSAGE, cause);
        }

        TestException(String subMessage, Throwable cause) {
            super(CODE, MESSAGE + ": " + subMessage, cause);
        }
    }

    @Test
    void testDefaultConstructor() {
        // Given & When
        TestException exception = new TestException();

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(9999);
        Assertions.assertThat(exception.getMessage()).isEqualTo("Test exception");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "Additional details";

        // When
        TestException exception = new TestException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(9999);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Test exception: Additional details");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testInheritance() {
        // Given & When
        TestException exception = new TestException();

        // Then
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithCause() {
        // Given
        Throwable cause = new IllegalArgumentException("Invalid input");

        // When
        TestException exception = new TestException(cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(9999);
        Assertions.assertThat(exception.getMessage()).isEqualTo("Test exception");
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstructorWithSubMessageAndCause() {
        // Given
        Throwable cause = new IllegalStateException("State issue");
        String subMessage = "More details";

        // When
        TestException exception = new TestException(subMessage, cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(9999);
        Assertions.assertThat(exception.getMessage()).isEqualTo("Test exception: More details");
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }
}

