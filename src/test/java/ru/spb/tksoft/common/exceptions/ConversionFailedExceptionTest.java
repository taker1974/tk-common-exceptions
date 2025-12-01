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
 * Tests for ConversionFailedException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
class ConversionFailedExceptionTest {

    @Test
    void testDefaultConstructor() {
        // Given & When
        ConversionFailedException exception = new ConversionFailedException();

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ConversionFailedException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(ConversionFailedException.MESSAGE);
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "String to Integer conversion failed";

        // When
        ConversionFailedException exception = new ConversionFailedException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ConversionFailedException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Conversion failed: String to Integer conversion failed");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithCause() {
        // Given
        Throwable cause = new NumberFormatException("Invalid number");

        // When
        ConversionFailedException exception = new ConversionFailedException(cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ConversionFailedException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(ConversionFailedException.MESSAGE);
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstructorWithSubMessageAndCause() {
        // Given
        Throwable cause = new IllegalArgumentException("Unsupported type");
        String subMessage = "JSON to Object conversion failed";

        // When
        ConversionFailedException exception = new ConversionFailedException(subMessage, cause);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ConversionFailedException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Conversion failed: JSON to Object conversion failed");
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(ConversionFailedException.CODE).isEqualTo(893);
        Assertions.assertThat(ConversionFailedException.MESSAGE).isEqualTo("Conversion failed");
    }
}

