package com.appskimo.app.sample.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by dominic.lee on 2017. 11. 23..
 */
@Getter
@Setter
@ToString(of = {"q"})
@NoArgsConstructor
public class Page implements Serializable {
    private static final long serialVersionUID = 5594847775172025956L;

    @ApiModelProperty(hidden = true)
    private Map<String, Object> q;
}
