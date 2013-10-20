package com.guide.city.entities;

import com.google.code.morphia.annotations.Embedded;
import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

/**
 * User: dkovalskyi
 * Date: 20.10.13
 * Time: 8:59
 */
@Embedded
public class VisitedEmbedded {

    @JsonView(Views.Key.class)
    private Integer id;
    @JsonView(Views.Key.class)
    private Long timestamp;

    public VisitedEmbedded(Integer id) {
        this.id = id;
    }

    public VisitedEmbedded() {}

    public VisitedEmbedded(Integer id, Long timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VisitedEmbedded that = (VisitedEmbedded) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
