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

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

import org.assertj.core.api.Assertions;
import org.slf4j.LoggerFactory;

/**
 * Attaches a Logback {@link ListAppender} to the SLF4J logger used by {@link TkBaseException} and
 * asserts an ERROR event when a subclass instance is constructed (same contract as production:
 * {@code LogEx} → SLF4J).
 */
final class TkBaseExceptionLoggingAssertions {

    private TkBaseExceptionLoggingAssertions() {}

    static void assertErrorLoggedWhenConstructorRuns(final Runnable constructException) {
        Logger tkBaseLogger = (Logger) LoggerFactory.getLogger(TkBaseException.class);
        ListAppender<ILoggingEvent> appender = new ListAppender<>();
        appender.start();
        tkBaseLogger.addAppender(appender);
        try {
            constructException.run();
            Assertions.assertThat(appender.list)
                    .as("LogEx should delegate to SLF4J at ERROR when the exception is created")
                    .anyMatch(e -> Level.ERROR.equals(e.getLevel()));
        } finally {
            tkBaseLogger.detachAppender(appender);
            appender.stop();
        }
    }
}
