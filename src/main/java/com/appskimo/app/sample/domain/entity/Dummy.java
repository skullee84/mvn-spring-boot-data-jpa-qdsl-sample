package com.appskimo.app.sample.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
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
@Entity
@Table(name = "`Dummy`")
public class Dummy implements Serializable {
    private static final long serialVersionUID = -8614701049089239094L;

    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`name`", length = 20, nullable = false)
    private String name;

    @Column(name = "`registTime`", nullable = false)
    private Date registTime;

    @PrePersist
    public void onCreate() {
        this.registTime = new Date();
    }

}
