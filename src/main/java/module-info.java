/**
 * Module descriptor for tk-common-exceptions.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
module ru.spb.tksoft.common.exception {

    requires org.slf4j;
    requires jakarta.validation;
    requires static lombok;

    requires ru.spb.tksoft.utils.log;

    exports ru.spb.tksoft.common.exception;
}

