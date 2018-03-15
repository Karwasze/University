from itertools import product


def tautology(formula, variables):
    tab = list(product([0, 1], repeat = len(variables)))
    for i in tab:
        if a.calculate((dict(zip(variables, i)))) == 0:
            return 0
    return 1


class Formula():
    def calculate(self, variables):
        return -1


class Variable(Formula):
    def __init__ (self, x):
        self.x = x
    def calculate(self, variables):
        return variables[self.x]
    def __str__(self):
        return str(self.x)


class Neg(Formula):
    def __init__ (self, x):
        self.x = x
    def calculate(self, variables):
        if variables[str(self.x)] == 1:
            return 0
        else:
            return 1
    def __str__(self):
        return str("~(")+str(self.x)+str(")")


class And(Formula):
    def __init__ (self, x, y):
        self.x = x
        self.y = y
    def calculate(self, variables):
        if((self.x.calculate(variables) == 1) and (self.y.calculate(variables) == 1)):
            return 1
        else: 
            return 0
    def __str__(self):
        return str(self.x) + str(" ^ ") + str(self.y)


class Or(Formula):
    def __init__ (self, x, y):
        self.x = x
        self.y = y
    def calculate(self, variables):
        if(self.x.calculate(variables) == 1 or self.y.calculate(variables) == 1):
            return 1
        else: 
            return 0
    def __str__(self):
        return str(self.x) + str(" \/ ") + str(self.y)


class Impl(Formula):
    def __init__ (self, x, y):
        self.x = x
        self.y = y
    def calculate(self, variables):
        if self.x.calculate(variables) == 1 and self.y.calculate(variables) == 0:
            return 0
        else: 
            return 1
    def __str__(self):
        return str(self.x) + str(" => ") + str(self.y)


class Rown(Formula):
    def __init__ (self, x, y):
        self.x = x
        self.y = y
    def calculate(self, variables):
        if(self.x.calculate(variables) == self.y.calculate(variables)):
            return 1
        else: 
            return 0
    def __str__(self):
        return str(self.x) + str(" <=> ") + str(self.y)


class True1(Formula):
    def __init__(self):
        self.x = 1
    def calculate(self, variables):
        return 1
    def __str__(self):
        return str("true")


class False1(Formula):
    def __init__(self):
        self.x = 0
    def calculate(self, variables):
        return 0
    def __str__(self):
        return str("false")
  
        
x = Variable("x")
#y = Variable("y")
b = Impl(Variable("x"), (And(Variable("y"), True1())))
a = Or(Variable("x"), Neg(Variable("x")))
#print(a.calculate({"x":1,"y":0}))
#print(Rown(Neg(x),Variable("y")))
#print(a)
print(tautology(a,["x","y"]))