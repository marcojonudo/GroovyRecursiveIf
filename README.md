# Groovy recursive if...elseif...else
Groovy implementation to avoid repeating a long list of if, else if and else statements.

Using recursion, this usual piece of code can be optimized to make it more scalable and look cleaner.

## Usage example
Traditional structure:

    String getNValue(int n) {
        String value
        
        if (n == 1) {
            value = 'I am the if!'
        }
        else if (n == 2) {
            value = 'I am the else if!'
        }
        else {
            value = 'I am the else!'
        }
            
        return value
    }

Recursive if structure:

    // Closures without parameters
    String getNValue(int n) {
        List conditions = [
            { n == 1 ? 'I am the if!' : null },
            { n == 2 ? 'I am the else if!' : null },
            { 'I am the else!' }
        ]
        
        String value = Utils.recursiveIf(conditions)
        
        return value
    }
    
    // Closures with a single parameter
    String getNValue(int n) {
        ArrayList<Closure> paramsConditions = [
            { int n -> n == 1 ? 'x' : null },
            { int n -> n == 2 ? 'y' : null },
            { z }
        ]
        
        String value = Utils.recursiveIf(paramsConditions, n)
        
        return value
    }
    
    // Closures with several parameters
    String getNValue(int n) {
        ArrayList<Closure> listParamsConditions = [
            { int n1, int n2 -> n1 == 1 && n2 == 1 ? 'x' : null },
            { int n1, int n2 -> n1 == 2 && n2 == 2 ? 'y' : null },
            { z }
        ]
        ArrayList<Integer> params = [n, n]
        
        String value = Utils.recursiveIf(listParamsConditions, params)
        
        return value
    }
    