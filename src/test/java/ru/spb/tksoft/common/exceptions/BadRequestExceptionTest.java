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
 * Tests for BadRequestException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
class BadRequestExceptionTest {

    @Test
    void testDefaultConstructor() {
        // Given & When
        BadRequestException exception = new BadRequestException();

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(BadRequestException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(BadRequestException.MESSAGE);
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "Invalid parameter value";

        // When
        BadRequestException exception = new BadRequestException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(BadRequestException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Bad request: Invalid parameter value");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithCause() {
        // Given
        Throwable cause = new IllegalArgumentException("Invalid payload");

        // When
        BadRequestException exception = new BadRequestException(cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(BadRequestException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(BadRequestException.MESSAGE);
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstructorWithSubMessageAndCause() {
        // Given
        Throwable cause = new IllegalStateException("Broken state");
        String subMessage = "Payload mismatch";

        // When
        BadRequestException exception = new BadRequestException(subMessage, cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(BadRequestException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Bad request: Payload mismatch");
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(BadRequestException.CODE).isEqualTo(400);
        Assertions.assertThat(BadRequestException.MESSAGE).isEqualTo("Bad request");
    }
}

