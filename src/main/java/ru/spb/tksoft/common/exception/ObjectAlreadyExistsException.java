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


import java.util.Objects;

/**
 * Object already exists.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
public class ObjectAlreadyExistsException extends TkBaseException {

    /** Error code. */
    public static final int CODE = 5371;

    /** Error message. */
    public static final String MESSAGE = "Object already exists";

    /**
     * Default constructor.
     */
    public ObjectAlreadyExistsException() {

        super(CODE, MESSAGE);
    }

    /**
     * Constructor with additional message.
     * 
     * @param subMessage - additional message.
     */
    public ObjectAlreadyExistsException(String subMessage) {

        super(CODE, MESSAGE + ": " + (Objects.isNull(subMessage) ? "" : subMessage));
    }
}
