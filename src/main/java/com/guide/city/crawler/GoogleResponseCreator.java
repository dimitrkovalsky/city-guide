package com.guide.city.crawler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

public class GoogleResponseCreator {

    public static JSONObject getDetailsAboutPlace(Map<String, String> params) throws IOException, JSONException {
        return getResponse(params, GoogleHelper.GOOGLE_PLACE_DETAILS_URL);
    }

    public static JSONObject getTextSearchPlace (Map<String, String> params) throws IOException, JSONException {
        return getResponse(params, GoogleHelper.GOOGLE_TEXT_SEARCH_URL);
    }

    private static JSONObject getResponse(Map<String, String> params, String googleUrl) throws IOException, JSONException {
        String url = googleUrl + "?" + GoogleHelper.encodeParams(params);
        JSONObject response = GoogleHelper.read(url);

        return response;
    }
}
