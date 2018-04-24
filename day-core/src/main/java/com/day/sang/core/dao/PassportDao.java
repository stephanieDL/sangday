package com.day.sang.core.dao;

import com.day.sang.core.po.PassportPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportDao extends JpaRepository<PassportPO, Integer>, JpaSpecificationExecutor<PassportPO> {
}
