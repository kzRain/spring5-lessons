package com.codeforce.product.security;

public enum UserPermission {
    STATE_READ("admin:read"),
    STATE_WRITE("admin:write"),
    PACK_READ("user:read"),
    PACK_WRITE("user:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
