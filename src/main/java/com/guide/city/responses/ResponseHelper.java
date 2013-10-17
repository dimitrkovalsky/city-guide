package com.guide.city.responses;

import com.guide.city.helpers.JsonMapper;
import com.guide.city.helpers.Views;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseHelper {
    public static void sendResponse(GenericResponse appResponse, HttpServletResponse httpResponse)
    {
        try {
            JsonMapper mapper = new JsonMapper();
            mapper.writerWithView(Views.Public.class).writeValue(httpResponse.getOutputStream(), appResponse);
        }
        catch (IOException e) {
            httpResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }
}
