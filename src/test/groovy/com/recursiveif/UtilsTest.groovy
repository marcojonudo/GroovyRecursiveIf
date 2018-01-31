package com.recursiveif

import spock.lang.Specification

class UtilsTest extends Specification {

    List<Closure> conditionList
    int n

    void setup() {
        conditionList = [
                { n == 1 ? 'I am the if!' : null },
                { n == 2 ? 'I am the else if!' : null },
                { 'I am the else!' }
        ]
    }

    void "test recursive if 'if branch'"() {
        given:
            n = 1

        when:
            String conditionsResult = Utils.recursiveIf(conditionList)

        then:
            conditionsResult == 'I am the if!'
    }

    void "test recursive if 'else if branch'"() {
        given:
            n = 2

        when:
            String conditionsResult = Utils.recursiveIf(conditionList)

        then:
            conditionsResult == 'I am the else if!'
    }

    void "test recursive if 'else branch'"() {
        given:
            n = 1234

        when:
            String conditionsResult = Utils.recursiveIf(conditionList)

        then:
            conditionsResult == 'I am the else!'
    }

}
