# Groovy recursive if...elseif...else
Groovy implementation to avoid repeating a long list of if, else if and else statements.

Using recursion, this usual piece of code can be optimized to make it more scalable and look cleaner.

## Usage example
Traditional structure:

    String getNValue(int n) {
        String value
        
        if (n == 1)
            value = 'I am the if!'
        else if (n == 2)
            value = 'I am the else if!'
        else
            value = 'I am the else!'
            
        return value
    }

Recursive if structure:

    String getNValue(int n) {
        List conditionList = [
                { n == 1 ? 'I am the if!' : null },
                { n == 2 ? 'I am the else if!' : null },
                { 'I am the else!' }
        ]
        
        String value = Utils.recursiveIf(conditionList)
        
        return value
    }
    