#Propositional Logic
#https://ggc-discrete-math.github.io/logic.html#:~:text=Propositional%20logic%20consists%20of%20a,functions%20for%20each%20propositional%20rule.


print('---------Negation---------')
def negation(p):
    return not p
	
print("p    a")
for p in [True, False]:
    a = negation(p)
    print(p, a)


print('---------Conjunction---------')
def conjunction(p, q):
    return p and q

print("p    q    a")
for p in [True, False]:
    for q in [True, False]:
        a = conjunction(p, q)
        print(p, q, a)


print('---------Disjunction---------')
def disjunction(p, q):
    return p or q
	
print("p    q    a")
for p in [True, False]:
    for q in [True, False]:
        a = disjunction(p, q)
        print(p, q, a)
        
        
#OUTPUT:
'''
---------Negation---------
p    a
True False
False True
---------Conjunction---------
p    q    a
True True True
True False False
False True False
False False False
---------Disjunction---------
p    q    a
True True True
True False True
False True True
False False False
'''
