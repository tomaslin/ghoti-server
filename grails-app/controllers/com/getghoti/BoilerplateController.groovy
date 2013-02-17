package com.getghoti

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class BoilerplateController {
    static scaffold = true
}
