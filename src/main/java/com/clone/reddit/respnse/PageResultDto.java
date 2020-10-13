package com.clone.reddit.respnse;


import com.clone.reddit.dto.BaseDto;
import java.io.Serializable;
import java.util.List;

public class PageResultDto<ID extends Serializable, T extends BaseDto<ID>> extends BaseResponse implements Serializable {

    private List<T> data;
    private Long totalElements;
    private int numberOfPages;

    public PageResultDto(boolean errorStatus, String responseMessage, String errorCode, List<T> data, Long totalElements, int numberOfPages) {
        super(errorStatus, responseMessage, errorCode);
        this.data = data;
        this.totalElements = totalElements;
        this.numberOfPages = numberOfPages;
    }


    public PageResultDto(List<T> data, Long totalElements, int numberOfPages) {
        this.data = data;
        this.totalElements = totalElements;
        this.numberOfPages = numberOfPages;
    }

    public PageResultDto(boolean errorStatus, String responseStatus, String message, List<T> data) {
        super(errorStatus, responseStatus, message);
        this.data = data;
    }

    public PageResultDto() {
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
