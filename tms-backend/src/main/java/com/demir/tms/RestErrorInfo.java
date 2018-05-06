package com.demir.tms;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: muratdemir
 * Date: 6.05.2018
 * Time: 19:02
 */

@XmlRootElement
public class RestErrorInfo implements Serializable {

    private final String detail;
    private final String message;

    public RestErrorInfo(Exception ex, String detail) {
        this.message = ex.getLocalizedMessage();
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public String getMessage() {
        return message;
    }
}
