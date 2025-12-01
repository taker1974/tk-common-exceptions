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
 * Base exception abstract class.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
public abstract class TkBaseException extends RuntimeException {

    private static final Logger log = LoggerFactory.getLogger(TkBaseException.class);

    /** Error code. */
    @Getter
    private final int code;

    /**
     * Base constructor.
     * 
     * @param code - error code.
     * @param message - error message.
     */
    protected TkBaseException(int code, String message) {

        super(message);
        this.code = code;
        LogEx.error(log, LogEx.me(), LogEx.EXCEPTION_THROWN, this.code, this);
    }

    /**
     * Base constructor with cause.
     * 
     * @param code - error code.
     * @param message - error message.
     * @param cause - cause of the exception.
     */
    protected TkBaseException(int code, String message, Throwable cause) {

        super(message, cause);
        this.code = code;
        LogEx.error(log, LogEx.me(), LogEx.EXCEPTION_THROWN, this.code, this, cause);
    }
}
