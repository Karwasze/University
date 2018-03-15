from copy import deepcopy
zdania = ["asd", "Asd", "asd.", "Asd. ", "asd. "]
def korekta(zdanie):
    zdanie = zdanie.rstrip()
    if zdanie[0].islower() and zdanie[-1] != ".":
        return zdanie[0].upper() + zdanie[1:] + "."
    
    if zdanie[0].islower():
        return zdanie[0].upper() + zdanie[1:]

    if zdanie[-1] != ".":
        return zdanie + "."
    return zdanie

class Iterator:
    def __init__(self):
        self.X = open("tekst", "r").read().replace("\n", "")
        self.i = 0
        self.n = len(self.X)
        self.string = ""
        self.strcp = ""

    def __iter__(self):
        return self

    def __next__(self):
        while self.i < self.n and self.X[self.i] != ".":
            self.string += self.X[self.i]
            self.i += 1
        if self.X[self.i] == ".":
            self.string+="."
            self.i += 1
            self.strcp = deepcopy(self.string)
            self.string = ""
            return self.strcp
        else:
            raise StopIteration()

c = Iterator()
# for x in c:
    # print(x)

print(list(map(korekta,c)))