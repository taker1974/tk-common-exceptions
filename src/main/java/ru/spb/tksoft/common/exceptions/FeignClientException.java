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
import lombok.Getter;

/**
 * Feign client exception.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
public class FeignClientException extends TkBaseException {

    /** Error code. */
    public static final int CODE = 8943;

    /** Error message. */
    public static final String MESSAGE = "Feign client failed";

    /** Status code. */
    @Getter
    private final int statusCode;

    /** Default constructor. */
    public FeignClientException() {

        super(CODE, MESSAGE);
        this.statusCode = 0;
    }

    /**
     * Constructor with additional message.
     * 
     * @param subMessage - additional message.
     */
    public FeignClientException(String subMessage, int statusCode) {

        super(CODE, MESSAGE + ": " + (Objects.isNull(subMessage) ? "" : subMessage));
        this.statusCode = statusCode;
    }

    /**
     * Constructor with cause.
     * 
     * @param cause - cause of the exception.
     */
    public FeignClientException(Throwable cause) {

        super(CODE, MESSAGE, cause);
        this.statusCode = 0;
    }

    /**
     * Constructor with additional message and cause.
     * 
     * @param subMessage - additional message.
     * @param cause - cause of the exception.
     */
    public FeignClientException(String subMessage, Throwable cause) {

        super(CODE, MESSAGE + ": " + subMessage, cause);
        this.statusCode = 0;
    }
}

