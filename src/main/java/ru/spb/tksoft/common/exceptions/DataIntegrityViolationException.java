/*
 * Copyright 2026 Konstantin Terskikh
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

/**
 * Data integrity violation.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2026
 */
public class DataIntegrityViolationException extends TkBaseException {

    /** Application error code (not the HTTP status). */
    public static final int CODE = 409;

    /** Message: Data integrity violation. */
    public static final String MESSAGE = "Data integrity violation";

    /**
     * Default constructor.
     */
    public DataIntegrityViolationException() {
        super(CODE, MESSAGE);
    }

    /**
     * Constructor with sub-message.
     * 
     * @param subMessage - sub-message.
     */
    public DataIntegrityViolationException(final String subMessage) {
        super(CODE, MESSAGE + ": " + subMessage);
    }

    /**
     * Constructor with cause.
     * 
     * @param cause - cause.
     */
    public DataIntegrityViolationException(final Throwable cause) {
        super(CODE, MESSAGE, cause);
    }

    /**
     * Constructor with sub-message and cause.
     * 
     * @param subMessage - sub-message.
     * @param cause - cause.
     */
    public DataIntegrityViolationException(final String subMessage, final Throwable cause) {
        super(CODE, MESSAGE + ": " + subMessage, cause);
    }
}
