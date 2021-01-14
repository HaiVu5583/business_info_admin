package com.inovationlab.businessinfo.service;

import com.inovationlab.businessinfo.dto.BaseListReponseDto;
import com.inovationlab.businessinfo.dto.CreateBusinessLineRequestDto;
import com.inovationlab.businessinfo.entity.BusinessLine;
import com.inovationlab.businessinfo.exception.InvalidParamException;
import com.inovationlab.businessinfo.exception.RecordExistsException;
import com.inovationlab.businessinfo.repository.BusinessLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessLineService {
    @Value("${endpoint.defaultPageSize}")
    private int pageSize;
    @Autowired
    BusinessLineRepository businessLineRepository;

    public BaseListReponseDto<BusinessLine> get(Integer page) {
        int startPage = page == null || page == 0 ? 0 : page.intValue() - 1;
        PageRequest pageRequest = PageRequest.of(startPage, pageSize);
        Page<BusinessLine> pageResult = businessLineRepository.findAll(pageRequest);
        int totalPage = pageResult.getTotalPages();
        List<BusinessLine> list = pageResult.getContent();
        int returnPage = page == null || page == 0 ? 1 : page.intValue();
        return new BaseListReponseDto<>(returnPage, totalPage, list);
    }

    public void create(CreateBusinessLineRequestDto createRequestDto) {
        if (createRequestDto.getName() == null || createRequestDto.getName().trim().isEmpty()
                || createRequestDto.getCode() == null || createRequestDto.getCode().trim().isEmpty()
        ) {
            throw new InvalidParamException();
        }
        boolean isExists = businessLineRepository.existsById(createRequestDto.getCode());
        if (isExists) {
            throw new RecordExistsException();
        }
        BusinessLine businessLine = new BusinessLine();
        businessLine.setCode(createRequestDto.getCode());
        businessLine.setName(createRequestDto.getName());
        businessLineRepository.save(businessLine);
    }

    public void update(CreateBusinessLineRequestDto createRequestDto) {
        if (createRequestDto.getName() == null || createRequestDto.getName().trim().isEmpty()
                || createRequestDto.getCode() == null || createRequestDto.getCode().trim().isEmpty()
        ) {
            throw new InvalidParamException();
        }
        BusinessLine businessLine = new BusinessLine();
        businessLine.setCode(createRequestDto.getCode());
        businessLine.setName(createRequestDto.getName());
        businessLineRepository.save(businessLine);
    }


}
