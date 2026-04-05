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

import java.util.Objects;

/**
 * Null or empty argument exception.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2026
 */
public class NullOrEmptyArgumentException extends TkBaseException {

    /** Error code. */
    public static final int CODE = 226;

    /** Error message. */
    public static final String MESSAGE = "Argument must not be null or empty";

    /**
     * Constructor.
     * 
     * @param subMessage - additional message.
     */
    public NullOrEmptyArgumentException(String subMessage) {

        super(CODE, MESSAGE + ": " + (Objects.isNull(subMessage) ? "" : subMessage));
    }

    /**
     * Constructor with cause.
     * 
     * @param cause - cause of the exception.
     */
    public NullOrEmptyArgumentException(Throwable cause) {

        super(CODE, MESSAGE, cause);
    }

    /**
     * Constructor with additional message and cause.
     * 
     * @param subMessage - additional message.
     * @param cause - cause of the exception.
     */
    public NullOrEmptyArgumentException(String subMessage, Throwable cause) {

        super(CODE, MESSAGE + ": " + subMessage, cause);
    }
}
