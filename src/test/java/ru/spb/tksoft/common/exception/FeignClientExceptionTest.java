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
 * Tests for FeignClientException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
class FeignClientExceptionTest {

    @Test
    void testDefaultConstructor() {
        // Given & When
        FeignClientException exception = new FeignClientException();

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(FeignClientException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(FeignClientException.MESSAGE);
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        // Given
        String subMessage = "Connection timeout";

        // When
        FeignClientException exception = new FeignClientException(subMessage, 500);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(FeignClientException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Feign client failed: Connection timeout");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithNullSubMessage() {
        // Given
        String subMessage = null;

        // When
        FeignClientException exception = new FeignClientException(subMessage, 500);

        // Then
        Assertions.assertThat(exception.getCode()).isEqualTo(FeignClientException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo("Feign client failed: ");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstants() {
        // Then
        Assertions.assertThat(FeignClientException.CODE).isEqualTo(8943);
        Assertions.assertThat(FeignClientException.MESSAGE).isEqualTo("Feign client failed");
    }
}

