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

/**
 * Invalid key exception: cryptographic key validation failed etc.
 *
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025-2026
 */
public class InvalidKeyException extends TkBaseException {

    /** Error code. */
    public static final int CODE = 129;

    /** Error message. */
    public static final String MESSAGE = "Invalid key";

    /**
     * Default constructor.
     */
    public InvalidKeyException() {

        super(CODE, MESSAGE);
    }

    /**
     * Constructor with additional message.
     *
     * @param subMessage - additional message.
     */
    public InvalidKeyException(final String subMessage) {

        super(CODE, MESSAGE + ": " + subMessage);
    }

    /**
     * Constructor with cause.
     *
     * @param cause - cause of the exception.
     */
    public InvalidKeyException(final Throwable cause) {

        super(CODE, MESSAGE, cause);
    }

    /**
     * Constructor with additional message and cause.
     *
     * @param subMessage - additional message.
     * @param cause - cause of the exception.
     */
    public InvalidKeyException(final String subMessage, final Throwable cause) {

        super(CODE, MESSAGE + ": " + subMessage, cause);
    }
}
