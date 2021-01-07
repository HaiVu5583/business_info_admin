package com.inovationlab.businessinfo.repository;

import com.inovationlab.businessinfo.entity.Partner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends CrudRepository<Partner, String> {
    @Query(value = "SELECT * FROM partner WHERE partner_code=(:partnerCode) AND partner_secret= (:partnerSecret)", nativeQuery = true)
    List<Partner> findPartnerByCodeAndSecret(@Param("partnerCode") String partnerCode, @Param("partnerSecret") String partnerSecret);
}
