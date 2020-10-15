package com.clone.reddit.respnse;


import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SingleResultResponse implements Serializable {

    private Object data;
    private boolean errorStatus;
    private Integer responseStatus;
    private String message;


}
