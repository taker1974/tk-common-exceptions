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
 * Tests for NotImplementedException.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025-2026
 */
class NotImplementedExceptionTest {

    @Test
    void testDefaultConstructor() {
        NotImplementedException exception = new NotImplementedException();
        Assertions.assertThat(exception.getCode()).isEqualTo(NotImplementedException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(NotImplementedException.MESSAGE);
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithSubMessage() {
        String subMessage = "PATCH /widgets not supported";
        NotImplementedException exception = new NotImplementedException(subMessage);
        Assertions.assertThat(exception.getCode()).isEqualTo(NotImplementedException.CODE);
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Not implemented: PATCH /widgets not supported");
        Assertions.assertThat(exception).isInstanceOf(TkBaseException.class);
    }

    @Test
    void testConstructorWithNullSubMessage() {
        NotImplementedException exception = new NotImplementedException((String) null);
        Assertions.assertThat(exception.getMessage()).isEqualTo("Not implemented: null");
        Assertions.assertThat(exception.getCode()).isEqualTo(NotImplementedException.CODE);
    }

    @Test
    void testConstructorWithCause() {
        Throwable cause = new UnsupportedOperationException("No backend");
        NotImplementedException exception = new NotImplementedException(cause);
        Assertions.assertThat(exception.getCode()).isEqualTo(NotImplementedException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo(NotImplementedException.MESSAGE);
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstructorWithSubMessageAndCause() {
        Throwable cause = new IllegalStateException("Feature flag off");
        String subMessage = "Export to PDF";
        NotImplementedException exception = new NotImplementedException(subMessage, cause);
        Assertions.assertThat(exception.getCode()).isEqualTo(NotImplementedException.CODE);
        Assertions.assertThat(exception.getMessage()).isEqualTo("Not implemented: Export to PDF");
        Assertions.assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    void testConstants() {
        Assertions.assertThat(NotImplementedException.CODE).isEqualTo(3348);
        Assertions.assertThat(NotImplementedException.MESSAGE).isEqualTo("Not implemented");
    }

    @Test
    void constructorEmitsErrorThroughSlf4jLoggerForTkBaseException() {
        TkBaseExceptionLoggingAssertions.assertErrorLoggedWhenConstructorRuns(NotImplementedException::new);
    }
}
