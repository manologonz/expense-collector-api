package com.meggalord.expense_collector.utils.pagination;

import java.util.List;

public record PaginatedResponse<T>(
        List<T> data,
        Integer totalPages,
        boolean hasNext,
        boolean hasPrevious) {

    public static <T> PaginatedResponse<T> of(List<T> data, int page, int limit, Integer totalPages) {
        boolean hasNext = page < totalPages;
        boolean hasPrevious = page > 1;

        return new PaginatedResponse<>(data, totalPages, hasNext, hasPrevious);
    }

}
