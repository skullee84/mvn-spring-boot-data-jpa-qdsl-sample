package com.appskimo.app.sample.service.impl;

import com.appskimo.app.sample.domain.dto.Page;
import com.appskimo.app.sample.domain.entity.Dummy;
import com.appskimo.app.sample.domain.entity.QDummy;
import com.appskimo.app.sample.domain.repository.DummyRepository;
import com.appskimo.app.sample.service.ApiService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringPath;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dominic.lee on 2017. 11. 23..
 */
@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiServiceImpl implements ApiService {

    private final EntityManager entityManager;
    private final DummyRepository dummyRepository;

    private final QDummy qDummy = QDummy.dummy;

    @Override
    public Map<String, Object> getDummies(Page page) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        map.put("users", dummyRepository.findAll(generateCondition(page.getQ())));

        return map;
    }

    private BooleanBuilder generateCondition(Map<String, Object> q) {
        BooleanBuilder builder = new BooleanBuilder();
        Optional.ofNullable(q).ifPresent(query ->
            query.forEach((k, v) -> Optional.ofNullable(v).ifPresent(value -> {
                StringPath stringPath = Expressions.stringPath(qDummy, k);
                builder.and(stringPath.eq(v.toString()));
            }))
        );

        return builder;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Dummy save(Dummy dummy) {
        return dummyRepository.save(dummy);
    }

}
