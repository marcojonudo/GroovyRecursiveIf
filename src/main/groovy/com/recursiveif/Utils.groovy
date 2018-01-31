package com.recursiveif

class Utils {

    /**
     * Method to simulate a list of if-elseif-else in a smart way
     * While the closures returned object is null, the execution of the loop will
     * go on until index reaches list size value
     * If one of the closures return an object, method execution will finish and
     * that object will be returned
     *
     * @param conditionList List with closures where the conditions are defined
     *
     * if (n == 1) return 'x'
     * else if (n == 2) return 'y'
     * else return 'z'
     *
     * List<Closure> conditionList = [
     *     { n == 1 ? 'x' : null },
     *     { n == 2 ? 'y' : null },
     *     { z }
     * ]
     *
     * @param conditionList List<Closure> with the conditions
     * @param index         Default 0, used in the recursive algorithm
     * @return              Returned object depending on the conditions
     */
    static recursiveIf(List<Closure> conditionList, int index = 0) {
        def returnObject = conditionList.get(index++)()
        if (!returnObject && index < conditionList.size())
            returnObject = recursiveIf(conditionList, index)

        return returnObject
    }

}
