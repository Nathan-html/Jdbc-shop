package com.nathan.jdbc.services;

public enum MenuType {
    CREATE_USER("1", "create user"),
    GET_USER_By_ID("2", "get user by id"),
    GET_ALL_USER("3", "get all users"),
    CREATE_PRODUCT("4", "create product"),
    GET_PRODUCT("5", "get product by id"),
    GET_ALL_PRODUCT("6", "get all products"),
    UPDATE_PRODUCT("7", "update products"),
    REMOVE_PRODUCT("8", "remove products"),
    EXIT("0", "exit");

    private String id;
    private String value;

    MenuType(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return id + " > " + value;
    }
}
