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
        assertThat(exception.getCode()).isEqualTo(ConversionFailedException.CODE);
        assertThat(exception.getMessage()).isEqualTo(ConversionFailedException.MESSAGE);
        assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "String to Integer conversion failed";

        // When
        ConversionFailedException exception = new ConversionFailedException(subMessage);

        // Then
        assertThat(exception.getCode()).isEqualTo(ConversionFailedException.CODE);
        assertThat(exception.getMessage())
                .isEqualTo("Conversion failed: String to Integer conversion failed");
        assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstants() {
        // Then
        assertThat(ConversionFailedException.CODE).isEqualTo(893);
        assertThat(ConversionFailedException.MESSAGE).isEqualTo("Conversion failed");
    }
}

