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
 * Tests for UserNotFoundException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
class UserNotFoundExceptionTest {

    @Test
    void testDefaultConstructor() {
        // Given & When
        UserNotFoundException exception = new UserNotFoundException();

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(UserNotFoundException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(UserNotFoundException.MESSAGE);
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "User with email 'test@example.com' not found";

        // When
        UserNotFoundException exception = new UserNotFoundException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(UserNotFoundException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("User not found: User with email 'test@example.com' not found");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(UserNotFoundException.CODE).isEqualTo(892);
        Assertions.assertThat(UserNotFoundException.MESSAGE).isEqualTo("User not found");
    }
}

