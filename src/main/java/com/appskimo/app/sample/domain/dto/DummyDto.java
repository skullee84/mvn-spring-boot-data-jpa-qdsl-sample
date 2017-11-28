package com.appskimo.app.sample.domain.dto;

import com.appskimo.app.sample.domain.entity.Dummy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by dominic.lee on 2017. 11. 23..
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DummyDto implements Serializable {
    private static final long serialVersionUID = -2017403832441731481L;

    private String name;
    private String phone;

    @JsonIgnore
    public Dummy getInstance() {
        Dummy dummy = new Dummy();
        dummy.setName(name);
        dummy.setPhone(phone);

        return dummy;
    }

}
