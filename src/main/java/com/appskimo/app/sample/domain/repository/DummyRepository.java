package com.appskimo.app.sample.domain.repository;

import com.appskimo.app.sample.domain.entity.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by dominic.lee on 2017. 11. 23..
 */
public interface DummyRepository extends JpaRepository<Dummy, Long>, QueryDslPredicateExecutor<Dummy> {
}
