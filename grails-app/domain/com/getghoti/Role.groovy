package com.getghoti

class Role {

    String authority

    static mapping = {
        cache true
        table "ghoti_role"
    }

    static constraints = {
        authority blank: false, unique: true
    }
}
