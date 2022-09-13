package com.codecool.shop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.sql.SQLException;

public class LogService {

    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    public static void log(Exception e) {
        if (e instanceof IOException) {
            logger.error("File not found! {}.", e.getMessage());
        } else if (e instanceof NullPointerException) {
            logger.warn("No data returned! {}", e.getMessage());
        } else if (e instanceof SQLException) {
            logger.error("Cannot reach database! {}", e.getMessage());
        } else if (e instanceof IllegalAccessException) {
            logger.warn("Error {}", e.getMessage());
        }
    }
}
