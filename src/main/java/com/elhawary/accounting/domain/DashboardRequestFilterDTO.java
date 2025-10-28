package com.elhawary.accounting.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * DTO for filtering dashboard/control panel requests
 */
public class DashboardRequestFilterDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "From date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date from;

    @NotNull(message = "To date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date to;

    private String status;
    private String requestType;
    private int page = 0;
    private int size = 10;
    private String sortBy = "createdDate";
    private String sortDirection = "DESC";

    // Constructors
    public DashboardRequestFilterDTO() {
    }

    public DashboardRequestFilterDTO(Date from, Date to) {
        this.from = from;
        this.to = to;
    }

    // Getters and Setters
    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    @Override
    public String toString() {
        return "DashboardRequestFilterDTO{" +
                "from=" + from +
                ", to=" + to +
                ", status='" + status + '\'' +
                ", requestType='" + requestType + '\'' +
                ", page=" + page +
                ", size=" + size +
                ", sortBy='" + sortBy + '\'' +
                ", sortDirection='" + sortDirection + '\'' +
                '}';
    }
}
