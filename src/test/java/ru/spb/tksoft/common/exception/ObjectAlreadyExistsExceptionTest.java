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
 * Tests for ObjectAlreadyExistsException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
class ObjectAlreadyExistsExceptionTest {

    @Test
    void testDefaultConstructor() {
        // Given & When
        ObjectAlreadyExistsException exception = new ObjectAlreadyExistsException();

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ObjectAlreadyExistsException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo(ObjectAlreadyExistsException.MESSAGE);
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "Project with name 'TestProject' already exists";

        // When
        ObjectAlreadyExistsException exception = new ObjectAlreadyExistsException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ObjectAlreadyExistsException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Object already exists: Project with name 'TestProject' already exists");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithNullSubMessage() {
        // Given
        String subMessage = null;

        // When
        ObjectAlreadyExistsException exception = new ObjectAlreadyExistsException(subMessage);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(ObjectAlreadyExistsException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo("Object already exists: ");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(ObjectAlreadyExistsException.CODE).isEqualTo(5371);
        Assertions.assertThat(ObjectAlreadyExistsException.MESSAGE)
                .isEqualTo("Object already exists");
    }
}

