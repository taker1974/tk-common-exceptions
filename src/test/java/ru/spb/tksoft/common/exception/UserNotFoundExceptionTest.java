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
        assertThat(exception.getCode()).isEqualTo(UserNotFoundException.CODE);
        assertThat(exception.getMessage()).isEqualTo(UserNotFoundException.MESSAGE);
        assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "User with email 'test@example.com' not found";

        // When
        UserNotFoundException exception = new UserNotFoundException(subMessage);

        // Then
        assertThat(exception.getCode()).isEqualTo(UserNotFoundException.CODE);
        assertThat(exception.getMessage())
                .isEqualTo("User not found: User with email 'test@example.com' not found");
        assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstants() {
        // Then
        assertThat(UserNotFoundException.CODE).isEqualTo(892);
        assertThat(UserNotFoundException.MESSAGE).isEqualTo("User not found");
    }
}

