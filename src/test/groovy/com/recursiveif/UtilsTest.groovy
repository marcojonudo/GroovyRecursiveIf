package com.recursiveif

import spock.lang.Specification

class UtilsTest extends Specification {

    ArrayList<Closure> conditions, paramsConditions, listParamsConditions
    int n

    void setup() {
        conditions = [
                { n == 1 ? 'I am the if!' : null },
                { n == 2 ? 'I am the else if!' : null },
                { 'I am the else!' }
        ]
        paramsConditions = [
                { int param -> param == 1 ? 'I am the if!' : null },
                { int param -> param == 2 ? 'I am the else if!' : null },
                { int param -> 'I am the else!' }
        ]
        listParamsConditions = [
                { int param1, int param2 -> param1 == 1 && param2 == 1 ? 'I am the if!' : null },
                { int param1, int param2 -> param1 == 2 && param2 == 2 ? 'I am the else if!' : null },
                { int param1, int param2 -> 'I am the else!' }
        ]
    }

    void "test recursive if 'if branch'"() {
        given:
            n = 1

        when:
            String conditionsResult = Utils.recursiveIf(conditions)

        then:
            conditionsResult == 'I am the if!'
    }

    void "test recursive if 'else if branch'"() {
        given:
            n = 2

        when:
            String conditionsResult = Utils.recursiveIf(conditions)

        then:
            conditionsResult == 'I am the else if!'
    }

    void "test recursive if 'else branch'"() {
        given:
            n = 1234

        when:
            String conditionsResult = Utils.recursiveIf(conditions)

        then:
            conditionsResult == 'I am the else!'
    }

    void "test params recursive if 'if branch'"() {
        given:
            int param = 1

        when:
            String conditionsResult = Utils.recursiveIf(paramsConditions, param)

        then:
            conditionsResult == 'I am the if!'
    }

    void "test params recursive if 'else if branch'"() {
        given:
            int param = 2

        when:
            String conditionsResult = Utils.recursiveIf(paramsConditions, param)

        then:
            conditionsResult == 'I am the else if!'
    }

    void "test params recursive if 'else branch'"() {
        given:
            int param = 1234

        when:
            String conditionsResult = Utils.recursiveIf(paramsConditions, param)

        then:
            conditionsResult == 'I am the else!'
    }

    void "test list params recursive if 'if branch'"() {
        given:
            ArrayList<Integer> params = [1, 1]

        when:
            String conditionsResult = Utils.recursiveIf(listParamsConditions, params)

        then:
            conditionsResult == 'I am the if!'
    }

    void "test list params recursive if 'else if branch'"() {
        given:
            ArrayList<Integer> params = [2, 2]

        when:
            String conditionsResult = Utils.recursiveIf(listParamsConditions, params)

        then:
            conditionsResult == 'I am the else if!'
    }

    void "test list params recursive if 'else branch'"() {
        given:
            ArrayList<Integer> params = [3, 4]

        when:
            String conditionsResult = Utils.recursiveIf(listParamsConditions, params)

        then:
            conditionsResult == 'I am the else!'
    }

}
