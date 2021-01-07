package com.inovationlab.businessinfo.repository;

import com.inovationlab.businessinfo.domain.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, String> {

}