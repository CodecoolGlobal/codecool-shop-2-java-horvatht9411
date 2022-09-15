package com.codecool.shop.controller;

import com.codecool.shop.service.LogService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class ControllerUtil {
    static int retrieveProductId(HttpServletRequest req) {
        String pathInfo = req.getPathInfo();
        if (pathInfo.startsWith("/")) {
            pathInfo = pathInfo.substring(1);
        }
        return Integer.parseInt(pathInfo);
    }

    static void initResponse(HttpServletResponse response, String answer) {
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String json = new Gson().toJson(answer);
            out.println(json);
            out.flush();
        } catch (IOException e) {
            LogService.log(e);
        }
    }

    static void initResponse(HttpServletResponse response, int answer) {
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String json = new Gson().toJson(answer);
            out.println(json);
            out.flush();
        } catch (IOException e) {
            LogService.log(e);
        }
    }

    static void initResponse(HttpServletResponse response, int[] answer) {
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String json = new Gson().toJson(answer);
            out.println(json);
            out.flush();
        } catch (IOException e) {
            LogService.log(e);
        }
    }

    static String inputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
        return scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
    }

    static List<String> getDataList(String jsonData) {
        Type jsonDataListType = new TypeToken<List<String>>() {
        }.getType();
        Gson gson = new Gson();
        List<String> dataList = gson.fromJson(String.valueOf(jsonData), jsonDataListType);
        return dataList;
    }
}
