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

package ru.spb.tksoft.common.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    }

    @Test
    void testDefaultConstructor() {
        // Given & When
        TestException exception = new TestException();

        // Then
        assertThat(exception.getCode()).isEqualTo(9999);
        assertThat(exception.getMessage()).isEqualTo("Test exception");
        assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "Additional details";

        // When
        TestException exception = new TestException(subMessage);

        // Then
        assertThat(exception.getCode()).isEqualTo(9999);
        assertThat(exception.getMessage()).isEqualTo("Test exception: Additional details");
        assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testInheritance() {
        // Given & When
        TestException exception = new TestException();

        // Then
        assertThat(exception).isInstanceOf(TkBaseException.class);
    }
}

