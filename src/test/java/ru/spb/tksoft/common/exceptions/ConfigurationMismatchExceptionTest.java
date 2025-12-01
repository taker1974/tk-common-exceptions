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
 * Tests for ConfigurationMismatchException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
class ConfigurationMismatchExceptionTest {

    @Test
    void testDefaultConstructor() {
        // Given & When
        ConfigurationMismatchException exception = new ConfigurationMismatchException();

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ConfigurationMismatchException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo(ConfigurationMismatchException.MESSAGE);
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "Database URL mismatch";

        // When
        ConfigurationMismatchException exception = new ConfigurationMismatchException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ConfigurationMismatchException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Configuration mismatch: Database URL mismatch");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithNullSubMessage() {
        // Given
        String subMessage = null;

        // When
        ConfigurationMismatchException exception = new ConfigurationMismatchException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ConfigurationMismatchException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo("Configuration mismatch: ");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithCause() {
        // Given
        Throwable cause = new IllegalArgumentException("Invalid config value");

        // When
        ConfigurationMismatchException exception = new ConfigurationMismatchException(cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ConfigurationMismatchException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo(ConfigurationMismatchException.MESSAGE);
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstructorWithSubMessageAndCause() {
        // Given
        Throwable cause = new IllegalStateException("Conflicting config");
        String subMessage = "Incompatible values";

        // When
        ConfigurationMismatchException exception =
                new ConfigurationMismatchException(subMessage, cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ConfigurationMismatchException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Configuration mismatch: Incompatible values");
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(ConfigurationMismatchException.CODE).isEqualTo(2583);
        Assertions.assertThat(ConfigurationMismatchException.MESSAGE)
                .isEqualTo("Configuration mismatch");
    }
}

