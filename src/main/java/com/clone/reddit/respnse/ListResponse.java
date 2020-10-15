package com.clone.reddit.respnse;


import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListResponse implements Serializable {

    private List data = new ArrayList<>();
    private Long totalElements;
    private int numberOfPages;
    private boolean errorStatus;
    private Integer responseStatus;
    private String message;

}
