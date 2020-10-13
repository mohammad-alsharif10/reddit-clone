package com.clone.reddit.respnse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {

    private boolean errorStatus;
    private String responseStatus;
    private String message;


    public BaseResponse(boolean errorStatus, String responseStatus, String message) {
        this.errorStatus = errorStatus;
        this.responseStatus = responseStatus;
        this.message = message;
    }

    public BaseResponse() {
    }


}
