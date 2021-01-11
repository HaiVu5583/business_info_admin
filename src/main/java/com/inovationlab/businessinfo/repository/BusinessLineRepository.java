package com.inovationlab.businessinfo.repository;

import com.inovationlab.businessinfo.entity.BusinessLine;;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BusinessLineRepository extends PagingAndSortingRepository<BusinessLine, String>, JpaSpecificationExecutor<BusinessLine> {

}