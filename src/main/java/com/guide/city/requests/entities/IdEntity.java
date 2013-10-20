package com.guide.city.requests.entities;

import com.guide.city.annotations.NotNull;

/**
 * User: mkontarev
 * Date: 10/20/13
 * Time: 9:58 AM
 */
public class IdEntity {
    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
