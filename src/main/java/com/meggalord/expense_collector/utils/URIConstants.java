package com.meggalord.expense_collector.utils;

public class URIConstants {
    public static final String API_V1_PREFIX = "/api/v1";

    public static String getVersionedRoute(String route) {
        String aggregatedRoute = route != null ? route : "/";
        return API_V1_PREFIX + aggregatedRoute;
    }
}
