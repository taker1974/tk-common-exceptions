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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.Getter;
import ru.spb.tksoft.utils.log.LogEx;

/**
 * Abstract base for TKSoft unchecked exceptions.
 *
 * <p><strong>Logging contract:</strong> each constructor records a structured error log entry when
 * the exception instance is created. Logging uses the {@linkplain org.slf4j.Logger SLF4J} logger
 * for {@code TkBaseException} together with {@link ru.spb.tksoft.utils.log.LogEx} (see
 * {@link LogEx#EXCEPTION_THROWN}). This is intentional: constructing the exception performs a
 * logging side effect for traceability. Do not instantiate these exceptions only to emit logs;
 * throw them when the corresponding failure condition actually occurs (and handle duplicates in
 * upper layers if the same event must not be logged twice).</p>
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025-2026
 */
public abstract class TkBaseException extends RuntimeException {

    private static final Logger log = LoggerFactory.getLogger(TkBaseException.class);

    /** Application-specific numeric error code carried by this exception. */
    @Getter
    private final int code;

    /**
     * Base constructor.
     *
     * @param code numeric error code
     * @param message detail message passed to {@link RuntimeException#RuntimeException(String)}
     */
    protected TkBaseException(final int code, final String message) {

        super(message);
        this.code = code;
        LogEx.error(log, LogEx.me(), LogEx.EXCEPTION_THROWN, this.code, this);
    }

    /**
     * Base constructor with cause.
     *
     * @param code numeric error code
     * @param message detail message passed to {@link RuntimeException#RuntimeException(String, Throwable)}
     * @param cause the cause (may be {@code null})
     */
    protected TkBaseException(final int code, final String message, final Throwable cause) {

        super(message, cause);
        this.code = code;
        LogEx.error(log, LogEx.me(), LogEx.EXCEPTION_THROWN, this.code, this, cause);
    }
}
