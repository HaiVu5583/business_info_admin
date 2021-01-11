package com.inovationlab.businessinfo.service;

import com.inovationlab.businessinfo.repository.BusinessLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessLineService {
    @Autowired
    BusinessLineRepository businessLineRepository;

}
