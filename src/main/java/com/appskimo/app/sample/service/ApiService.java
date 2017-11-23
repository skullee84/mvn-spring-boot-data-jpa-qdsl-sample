package com.appskimo.app.sample.service;

import com.appskimo.app.sample.domain.dto.Page;
import com.appskimo.app.sample.domain.entity.Dummy;
import java.util.Map;

/**
 * Created by dominic.lee on 2017. 11. 23..
 */
public interface ApiService {

    Map<String, Object> getDummies(Page page);

    Dummy save(Dummy dummy);

}
