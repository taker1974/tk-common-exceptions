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
 * User not found.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
public class UserNotFoundException extends TkBaseException {

    /** Error code. */
    public static final int CODE = 892;

    /** Error message. */
    public static final String MESSAGE = "User not found";

    /**
     * Default constructor.
     * 
     */
    public UserNotFoundException() {

        super(CODE, MESSAGE);
    }

    /**
     * Constructor with additional message.
     * 
     * @param subMessage - additional message.
     */
    public UserNotFoundException(String subMessage) {

        super(CODE, MESSAGE + ": " + subMessage);
    }

    /**
     * Constructor with cause.
     * 
     * @param cause - cause of the exception.
     */
    public UserNotFoundException(Throwable cause) {

        super(CODE, MESSAGE, cause);
    }

    /**
     * Constructor with additional message and cause.
     * 
     * @param subMessage - additional message.
     * @param cause - cause of the exception.
     */
    public UserNotFoundException(String subMessage, Throwable cause) {

        super(CODE, MESSAGE + ": " + subMessage, cause);
    }
}
