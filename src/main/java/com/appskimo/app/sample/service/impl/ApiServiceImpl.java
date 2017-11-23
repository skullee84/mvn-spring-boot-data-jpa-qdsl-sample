package com.appskimo.app.sample.service.impl;

import com.appskimo.app.sample.domain.dto.Page;
import com.appskimo.app.sample.domain.entity.Dummy;
import com.appskimo.app.sample.domain.entity.QDummy;
import com.appskimo.app.sample.domain.repository.DummyRepository;
import com.appskimo.app.sample.service.ApiService;
import com.querydsl.core.BooleanBuilder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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

    private final DummyRepository dummyRepository;

    private static final QDummy qDummy = QDummy.dummy;

    @Override
    public Map<String, Object> getDummies(Page page) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        map.put("users", dummyRepository.findAll(generateCondition(page.getQ())));

        return map;
    }

    private BooleanBuilder generateCondition(Map<String, Object> q) {
        BooleanBuilder builder = new BooleanBuilder();
        if(Objects.nonNull(q) && Objects.nonNull(q.get("name"))) {
            builder.and(qDummy.name.eq(q.get("name").toString()));
        }
        return builder;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Dummy save(Dummy dummy) {
        return dummyRepository.save(dummy);
    }

}
