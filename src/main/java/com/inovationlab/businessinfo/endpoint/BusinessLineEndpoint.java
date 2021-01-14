package com.inovationlab.businessinfo.endpoint;

import com.inovationlab.businessinfo.dto.BaseListReponseDto;
import com.inovationlab.businessinfo.dto.CreateBusinessLineRequestDto;
import com.inovationlab.businessinfo.entity.BusinessLine;
import com.inovationlab.businessinfo.service.BusinessLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business_line")
public class BusinessLineEndpoint extends AbstractEndpoint {
    @Autowired
    private BusinessLineService businessLineService;

    @GetMapping
    public ResponseEntity<?> get(@RequestParam(name = "page", required = false) Integer page) {
        BaseListReponseDto<BusinessLine> response = businessLineService.get(page);
        return getResponseEntity(response);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateBusinessLineRequestDto createRequestDto) {
        businessLineService.create(createRequestDto);
        return getOkResponseEntity();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CreateBusinessLineRequestDto updateRequestDto) {
        businessLineService.update(updateRequestDto);
        return getOkResponseEntity();
    }

}
