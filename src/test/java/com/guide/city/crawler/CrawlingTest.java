package com.guide.city.crawler;

import com.google.common.collect.Maps;
import org.codehaus.jackson.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class CrawlingTest {

    //@Test
    public void TestDeatailsAboutPlace() throws IOException, JSONException {
        final Map<String, String> params = Maps.newHashMap();
        params.put("reference", "CqQBkwAAAGmCBSqsYbvczqm-aNnHXxjw2Yry-B4Htk-c8MRHD_-pmCXo-M8rnkIx-eFj25SeFXvxZu-ktfGjHEarWwsGxYjkHFyUUxcx1FzggB1AcCmNxychhbURAePmBNqik39vOLsQryOvyMFm3sU4NmGQiaNcgQyqvEVsSMvKUbXAp2nWro1NRfR08p6JubaaREj-lVMhThBQsNUSVtLLsCqyp54SEOHVEhapqesmzlJldJBYVJsaFI4XKzwDgfBY68_13r9DAq-TJ_Ot");
        params.put("sensor", "false");
        params.put("key", GoogleHelper.GOOGLE_APPLICATION_KEY);
        JSONObject jsonObject = GoogleResponseCreator.getDetailsAboutPlace(params);
        System.out.println(jsonObject.toString());
    }

    @Test
    public void TestTextSearchPlace() throws IOException, JSONException {
        final Map<String, String> params = Maps.newHashMap();
        params.put("query","ул. Соборная, 19 Винница Винницкая область");
        params.put("sensor", "false");
        params.put("key", GoogleHelper.GOOGLE_APPLICATION_KEY);
        JSONObject jsonObject = GoogleResponseCreator.getTextSearchPlace(params);
        System.out.println(jsonObject.toString());
    }
}
