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

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for InternalServerErrorException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
class InternalServerErrorExceptionTest {

    @Test
    void testDefaultConstructor() {
        // Given & When
        InternalServerErrorException exception = new InternalServerErrorException();

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(InternalServerErrorException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(InternalServerErrorException.MESSAGE);
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "Database connection failed";

        // When
        InternalServerErrorException exception = new InternalServerErrorException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(InternalServerErrorException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Internal server error: Database connection failed");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(InternalServerErrorException.CODE).isEqualTo(500);
        Assertions.assertThat(InternalServerErrorException.MESSAGE).isEqualTo("Internal server error");
    }
}

