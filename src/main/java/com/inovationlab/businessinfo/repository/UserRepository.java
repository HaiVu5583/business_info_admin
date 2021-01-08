package com.inovationlab.businessinfo.repository;

import com.inovationlab.businessinfo.entity.Partner;
import com.inovationlab.businessinfo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT * FROM partner WHERE username=(:username) AND password= (:password)", nativeQuery = true)
    List<Partner> findUser(@Param("username") String username, @Param("password") String password);
}