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
 * Tests for JwtTokenException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
class JwtTokenExceptionTest {

    @Test
    void testDefaultConstructor() {
        // Given & When
        JwtTokenException exception = new JwtTokenException();

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(JwtTokenException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(JwtTokenException.MESSAGE);
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "generation failed";

        // When
        JwtTokenException exception = new JwtTokenException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(JwtTokenException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("JWT token failed: generation failed");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithCause() {
        // Given
        Throwable cause = new IllegalArgumentException("Missing secret source");

        // When
        JwtTokenException exception = new JwtTokenException(cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(JwtTokenException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(JwtTokenException.MESSAGE);
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstructorWithSubMessageAndCause() {
        // Given
        Throwable cause = new IllegalStateException("Signing failed");
        String subMessage = "system error";

        // When
        JwtTokenException exception = new JwtTokenException(subMessage, cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(JwtTokenException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("JWT token failed: system error");
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(JwtTokenException.CODE).isEqualTo(128);
        Assertions.assertThat(JwtTokenException.MESSAGE).isEqualTo("JWT token failed");
    }
}

