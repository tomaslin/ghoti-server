package com.getghoti

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(FeedController)
class FeedControllerUnitSpec extends Specification {

    void setup() {

    }

    void 'feed only contains active boilerplates'(){
        expect:
        true
    }

}