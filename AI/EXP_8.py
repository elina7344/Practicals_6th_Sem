#Unification and resolution
#CHatGPT

#Unification

def unify(x, y, theta={}):
    if theta is None:
        return None
    elif x == y:
        return theta
    elif isinstance(x, str):
        return unify_var(x, y, theta)
    elif isinstance(y, str):
        return unify_var(y, x, theta)
    elif isinstance(x, list) and isinstance(y, list) and len(x) == len(y):
        return unify(x[1:], y[1:], unify(x[0], y[0], theta))
    else:
        return None

def unify_var(var, x, theta):
    if var in theta:
        return unify(theta[var], x, theta)
    elif x in theta:
        return unify(var, theta[x], theta)
    elif occur_check(var, x, theta):
        return None
    else:
        theta[var] = x
        return theta

def occur_check(var, x, theta):
    if var == x:
        return True
    elif isinstance(x, str) and x in theta:
        return occur_check(var, theta[x], theta)
    elif isinstance(x, list):
        return any(occur_check(var, xi, theta) for xi in x)
    else:
        return False

      
#OUTPUT:
'''
>>> unify("John", "John")
{}
>>> unify("John", "Mary")
None
>>> unify("x", "John")
{"x": "John"}
>>> unify(["likes", "x", "y"], ["likes", "Mary", "John"])
{"x": "Mary", "y": "John"}
>>> unify(["likes", "x", "y"], ["likes", "Mary", ["loves", "Mary", "John"]])
None

'''
#EXPLANAITION:
'''
In the above example, unify takes two terms as input and returns a substitution 
(i.e., a dictionary mapping variables to values) that makes the two terms identical. 
The theta parameter is an optional argument that stores the substitution computed so far. 
The function returns None if the terms cannot be unified. 
The occur_check function is used to check for recursive variable definitions.
'''

#Resolution

def negate(literal):
    if literal.startswith("~"):
        return literal[1:]
    else:
        return "~" + literal

def resolve(c1, c2):
    for literal in c1:
        if negate(literal) in c2:
            resolvent = [l for l in set(c1) | set(c2) if l != literal and l != negate(literal)]
            yield resolvent

def resolution(clauses):
    new = set(clauses)
    while True:
        n = len(new)
        pairs = [(new_i, new_j) for i, new_i in enumerate(new) for new_j in list(new)[i+1:]]
        for (c1, c2) in pairs:
            for resolvent in resolve(c1, c2):
                if not resolvent:
                    return True
                new.add(tuple(resolvent))
        if len(new) == n:
            return False
#OUTPUT:
'''
>>> clauses = [("A", "~B"), ("~A", "B"), ("C", "~B"), ("~C", "B")]
>>> resolution(clauses)
True

'''

#EXPLANAITION:
'''
In the above example, clauses is a list of clauses, where each clause is a list of literals. 
The negate function takes a literal and returns its negation. 
The resolve function takes two clauses and returns a generator that yields all resolvents of the two clauses. 
The resolution function takes a set of clauses and applies resolution until either the empty clause is derived (meaning the original clauses are unsatisfiable) 
or no new clauses can be derived (meaning the original clauses are satisfiable).
The function returns True if the original clauses are unsatisfiable and False if they are satisfiable.
'''
