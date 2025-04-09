package com.project.hms.controller;

import com.project.hms.common.utils.Messages;
import com.project.hms.common.utils.PaginationUtils;
import com.project.hms.common.utils.ResponseWrapper;
import com.project.hms.dto.DepartmentDto;
import com.project.hms.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
@Slf4j
@CrossOrigin(origins = "*")
public class DepartmentController {

    private final DepartmentService departmentService;

    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final String SORT_BY = "updatedAt";
    private static final String SORT_ORDER = "DESC";

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseWrapper<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        log.info("inside save department : controller");
        DepartmentDto response = departmentService.save(departmentDto);
        return new ResponseWrapper<>(response, Messages.DEPARTMENT_ADDED_SUCCESSFULLY, HttpStatus.CREATED.value());
    }

    @PutMapping("/update/{id}")
    public ResponseWrapper<DepartmentDto> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDto departmentDto) {
        log.info("inside update department : controller");
        DepartmentDto updateResponse = departmentService.update(departmentDto, id);
        return new ResponseWrapper<>(updateResponse,Messages.DEPARTMENT_UPDATED_SUCCESSFULLY, HttpStatus.OK.value());
    }

    @GetMapping("/get/{id}")
    public ResponseWrapper<DepartmentDto> getDepartment(@PathVariable Integer id) {
        log.info("inside get department by id : controller");
        DepartmentDto response = departmentService.getById(id);
        return new ResponseWrapper<>(response,Messages.DEPARTMENT_RETRIEVED_SUCCESSFULLY, HttpStatus.OK.value());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseWrapper<Object> deleteDepartment(@PathVariable Integer id) {
        log.info("inside delete department : controller");
        departmentService.delete(id);
        return new ResponseWrapper<>(null,Messages.DEPARTMENT_DELETED_SUCCESSFULLY, HttpStatus.OK.value());
    }

    @GetMapping
    public  ResponseWrapper<List<DepartmentDto>> getAllDepartment() {
        log.info("inside get all department : controller");
        List<DepartmentDto> response = departmentService.getAll();
        return new ResponseWrapper<>(response,Messages.DEPARTMENT_DELETED_SUCCESSFULLY, HttpStatus.OK.value());
    }

    @GetMapping("/search")
    public ResponseWrapper<Object> search(@RequestParam("query") Optional<String> query,
                                                       @RequestParam("page")Optional<Integer> page,
                                                       @RequestParam("size")Optional<Integer> size,
                                                       @RequestParam("sortBy")Optional<String> sortBy,
                                                       @RequestParam("sortOrder")Optional<String> sortOrder) {
        log.info("inside search department : controller");

        Pageable pageable = PaginationUtils.preparePagination(
                page,
                size.orElse(DEFAULT_PAGE_SIZE),
                sortBy.orElse(SORT_BY),
                sortOrder.orElse(SORT_ORDER)
        );
        String q;
        Object response;
        if(query.isPresent()) {
            q = query.get();
            response = departmentService.search(q, pageable);
        }else{
            response = departmentService.getAll();
        }
        return new ResponseWrapper<>(response,Messages.DEPARTMENT_RETRIEVED_SUCCESSFULLY, HttpStatus.OK.value());
    }
}
