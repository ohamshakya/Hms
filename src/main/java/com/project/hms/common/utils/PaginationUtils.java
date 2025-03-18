package com.project.hms.common.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public class PaginationUtils {
    public static Pageable preparePagination(Optional<Integer> page,
                                             int defaultSize,
                                             String sortBy,
                                             String sortOrder){
        int currentPage = page.orElse(1) - 1;
        Sort sort = sortOrder.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return PageRequest.of(currentPage,defaultSize,sort);
    }
}
