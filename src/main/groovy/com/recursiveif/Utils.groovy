package com.recursiveif

@SuppressWarnings("GroovyAssignabilityCheck")
class Utils {

    /**
     * Method to simulate a list of if-elseif-else in a smart way
     * While the closures returned object is null, the execution of the loop will
     * go on until index reaches list size value
     * If one of the closures return an object, method execution will finish and
     * that object will be returned
     *
     * @param conditions List with closures where the conditions are defined
     *
     * if (n == 1) return 'x'
     * else if (n == 2) return 'y'
     * else return 'z'
     *
     * ArrayList<Closure> conditions = [
     *     { n == 1 ? 'x' : null },
     *     { n == 2 ? 'y' : null },
     *     { z }
     * ]
     *
     * ArrayList<Closure> paramsConditions = [
     *     { int n -> n == 1 ? 'x' : null },
     *     { int n -> n == 2 ? 'y' : null },
     *     { z }
     * ]
     *
     * ArrayList<Closure> listParamsConditions = [
     *     { int n1, int n2 -> n1 == 1 && n2 == 1 ? 'x' : null },
     *     { int n1, int n2 -> n1 == 2 && n2 == 2 ? 'y' : null },
     *     { z }
     * ]
     *
     * @param conditions List<Closure> with the conditions
     * @param params Object or List with the closures params
     * @param index Default 0, used in the recursive algorithm
     * @return Returned object depending on the conditions
     */
    static recursiveIf(ArrayList<Closure> conditions, params = null, int index = 0) {
        def returnObject = conditions.get(index++)(params)
        if (!returnObject && index < conditions.size()) {
            returnObject = recursiveIf(conditions, params, index)
        }

        return returnObject
    }

}
