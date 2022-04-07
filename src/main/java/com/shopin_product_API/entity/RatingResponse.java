package com.shopin_product_API.entity;

public class RatingResponse {
    private Long count;
    private Double avg;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public RatingResponse(Long count, Double avg) {
        this.count = count;
        this.avg = avg;
    }
}
