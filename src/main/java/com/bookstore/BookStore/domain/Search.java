package com.bookstore.BookStore.domain;

public class Search {
    private long page;
    private String sortedBy;
    private String order;
    private String contains;
    private long totalPages;

    public Search(long page, String sortedBy, String order, String contains, long totalPages) {
        this.page = page;
        this.sortedBy = sortedBy;
        this.order = order;
        this.contains = contains;
        this.totalPages = totalPages;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public String getSortedBy() {
        return sortedBy;
    }

    public void setSortedBy(String sortedBy) {
        this.sortedBy = sortedBy;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getContains() {
        return contains;
    }

    public void setContains(String contains) {
        this.contains = contains;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}
