package com.guide.city.crawler;

import com.google.common.collect.Maps;
import com.guide.city.entities.Location;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class CrawlingTest {

    //@Test
    public void TestDeatailsAboutPlace() throws IOException, JSONException {
        final Map<String, String> params = Maps.newHashMap();
        params.put("reference",
                "CqQBkwAAAGmCBSqsYbvczqm-aNnHXxjw2Yry-B4Htk-c8MRHD_-pmCXo-M8rnkIx-eFj25SeFXvxZu-ktfGjHEarWwsGxYjkHFyUUxcx1FzggB1AcCmNxychhbURAePmBNqik39vOLsQryOvyMFm3sU4NmGQiaNcgQyqvEVsSMvKUbXAp2nWro1NRfR08p6JubaaREj-lVMhThBQsNUSVtLLsCqyp54SEOHVEhapqesmzlJldJBYVJsaFI4XKzwDgfBY68_13r9DAq-TJ_Ot");
        params.put("sensor", "false");
        params.put("key", GoogleHelper.GOOGLE_APPLICATION_KEY);
        JSONObject jsonObject = GoogleResponseCreator.getDetailsAboutPlace(params);
        System.out.println(jsonObject.toString());
    }

    //    @Test
    public void TestTextSearchPlace() throws IOException, JSONException {
        final Map<String, String> params = Maps.newHashMap();
        params.put("query", "улица Василия Порика, 7");
        params.put("sensor", "false");
        params.put("key", GoogleHelper.GOOGLE_APPLICATION_KEY);
        JSONObject jsonObject = GoogleResponseCreator.getTextSearchPlace(params);
        System.out.println(jsonObject.toString());
    }

    @Test
    public void TestFindStreetByLocation() throws Exception {
        System.out.println(GoogleHelper.getStreetName(new Location(49.2293288, 28.4236293)));
    }
}
