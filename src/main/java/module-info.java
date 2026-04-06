/**
 * Module descriptor for tk-common-exceptions.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025-2026
 */
module ru.spb.tksoft.common.exceptions {

    requires org.slf4j;
    requires static lombok;
    requires static ch.qos.logback.classic;
    requires static ch.qos.logback.core;

    requires ru.spb.tksoft.utils.log;

    exports ru.spb.tksoft.common.exceptions;
}

