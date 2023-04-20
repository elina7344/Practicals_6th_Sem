#Constraint Satisfaction Problem
# https://stackabuse.com/constraint-programming-with-python-constraint/

#QUES: Find all (x,y) where x ∈ {1,2,3} and 0 <= y < 10, and x + y >= 5

import constraint

problem = constraint.Problem()

problem.addVariable('x', [1,2,3])
problem.addVariable('y', range(10))

def our_constraint(x, y):
    if x + y >= 5:
        return True

problem.addConstraint(our_constraint, ['x','y'])

solutions = problem.getSolutions()

# Easier way to print and see all solutions
# for solution in solutions:
#    print(solution)

# Prettier way to print and see all solutions
length = len(solutions)
print("(x,y) ∈ {", end="")
for index, solution in enumerate(solutions):
    if index == length - 1:
        print("({},{})".format(solution['x'], solution['y']), end="")
    else:
        print("({},{}),".format(solution['x'], solution['y']), end="")
print("}")

#OUTPUT:
'''
x,y) ∈ {(3,9),(3,8),(3,7),(3,6),(3,5),(3,4),(3,3),(3,2),(2,9),(2,8),(2,7),(2,6),(2,5),(2,4),(2,3),(1,9),(1,8),(1,7),(1,6),(1,5),(1,4)}
'''
