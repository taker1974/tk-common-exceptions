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
 * Tests for NullArgumentException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
class NullArgumentExceptionTest {

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "userId parameter";

        // When
        NullArgumentException exception = new NullArgumentException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(NullArgumentException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Argument must not be null: userId parameter");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithNullSubMessage() {
        // Given
        String subMessage = null;

        // When
        NullArgumentException exception = new NullArgumentException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(NullArgumentException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo("Argument must not be null: ");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(NullArgumentException.CODE).isEqualTo(225);
        Assertions.assertThat(NullArgumentException.MESSAGE).isEqualTo("Argument must not be null");
    }
}

