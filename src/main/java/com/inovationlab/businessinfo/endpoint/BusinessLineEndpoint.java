package com.inovationlab.businessinfo.endpoint;

import com.inovationlab.businessinfo.dto.BaseListReponseDto;
import com.inovationlab.businessinfo.entity.BusinessLine;
import com.inovationlab.businessinfo.repository.BusinessLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/business_line")
public class BusinessLineEndpoint extends AbstractEndpoint {
    @Value("${endpoint.defaultPageSize}")
    private int pageSize;
    @Autowired
    private BusinessLineRepository businessLineRepository;

    @GetMapping
    public ResponseEntity<?> get(@RequestParam(name="page", required = false) Integer page) {
        int startPage = page == null || page == 0 ? 0 : page.intValue() - 1;
        PageRequest pageRequest = PageRequest.of(startPage, pageSize);
        Page<BusinessLine> pageResult = businessLineRepository.findAll(pageRequest);
        int totalPage = pageResult.getTotalPages();
        List<BusinessLine> list = pageResult.getContent();
        int returnPage = page == null || page == 1 ? 1 : page.intValue();
        BaseListReponseDto<BusinessLine> response = new BaseListReponseDto<>(returnPage, totalPage, list);
        return getResponseEntity(response);
    }

}
