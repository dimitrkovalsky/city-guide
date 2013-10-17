package com.guide.city.helpers;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class JsonMapper extends ObjectMapper {
    public JsonMapper() {
        configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
    }
}
