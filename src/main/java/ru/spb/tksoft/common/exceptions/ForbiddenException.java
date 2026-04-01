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
 * Authenticated or semi-authenticated client is not allowed to perform the operation (HTTP 403).
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2026
 */
public class ForbiddenException extends TkBaseException {

    /** Application error code (not the HTTP status). */
    public static final int CODE = 1325;

    /** Message: Forbidden. */
    public static final String MESSAGE = "Forbidden";

    /**
     * Default constructor.
     */
    public ForbiddenException() {
        super(CODE, MESSAGE);
    }

    /**
     * Constructor with sub-message.
     * 
     * @param subMessage - sub-message.
     */
    public ForbiddenException(final String subMessage) {
        super(CODE, MESSAGE + ": " + subMessage);
    }

    /**
     * Constructor with cause.
     * 
     * @param cause - cause.
     */
    public ForbiddenException(final Throwable cause) {
        super(CODE, MESSAGE, cause);
    }

    /**
     * Constructor with sub-message and cause.
     * 
     * @param subMessage - sub-message.
     * @param cause - cause.
     */
    public ForbiddenException(final String subMessage, final Throwable cause) {
        super(CODE, MESSAGE + ": " + subMessage, cause);
    }
}
