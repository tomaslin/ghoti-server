package com.getghoti

import grails.plugins.springsecurity.Secured
import org.springframework.dao.DataIntegrityViolationException

@Secured(['ROLE_ADMIN'])
class ProjectTemplatesController {
    static scaffold = true
}
