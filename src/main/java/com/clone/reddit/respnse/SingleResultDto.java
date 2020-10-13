package com.clone.reddit.respnse;


import com.clone.reddit.dto.BaseDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SingleResultDto {

    private BaseDto baseDto;
    private boolean errorStatus;
    private Integer responseStatus;
    private String message;


}
