package com.inovationlab.businessinfo.repository;

import com.inovationlab.businessinfo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT * FROM user WHERE username=(:username)", nativeQuery = true)
    User findUser(@Param("username") String username);
}