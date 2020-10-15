package com.clone.reddit.utils;

import com.clone.reddit.dto.BaseDto;
import com.clone.reddit.respnse.SingleResultResponse;

public class Common {


    public static <T extends BaseDto> SingleResultResponse getSingleResultDto(T t, String message, boolean error, Integer responseStatus) {
        return SingleResultResponse.builder()
                .data(t)
                .responseStatus(responseStatus)
                .message(message)
                .errorStatus(error)
                .build();
    }

//    public static <T extends BaseDto> ListResponse<BaseDto> getListResponse(Page<T> data, String message, boolean error, Integer responseStatus) {
//        List<BaseDto>list=data.get().collect(Collectors.toList());
//        return ListResponse.builder()
//                .data(list)
//                .numberOfPages(data.getTotalPages())
//                .totalElements(data.getTotalElements())
//                .errorStatus(error)
//                .responseStatus(responseStatus)
//                .message(message)
//                .build();
//    }
}
