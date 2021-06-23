package com.sql.ehr.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtils {
    public static void out(HttpServletResponse response,int statusCode,String text){
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(statusCode);
            PrintWriter out = null;
            out = response.getWriter();
            out.write(text);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
