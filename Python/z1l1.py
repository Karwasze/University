from random import choice
import sys


def rzut_kostka():
    tab = [1, 2, 3, 4, 5, 6]
    return choice(tab)


def gra(n):
    p1z = 0
    p2z = 0
    for i in range(int(n)):
        p1w = rzut_kostka() + rzut_kostka()
        p2w = rzut_kostka() + rzut_kostka()
        print("Gracz 1 wyrzucił " + str(p1w))
        print("Gracz 2 wyrzucił " + str(p2w))
        if p1w > p2w:
            p1z += 1
            print("Gracz 1 wygrał")
            print()
        elif p1w == p2w:
            p1z += 1
            p2z += 1
            print("Remis")
            print()
        else:
            p2z += 1
            print("Gracz 2 wygrał")
            print()
        print("Gracz 1 wygrał " + str(p1z) + " razy ")
        print("Gracz 2 wygrał " + str(p2z) + " razy")
    while (p1z == p2z):
        print("DOGRYWKA")
        p1w = rzut_kostka() + rzut_kostka()
        p2w = rzut_kostka() + rzut_kostka()
        print("Gracz 1 wyrzucił " + str(p1w))
        print("Gracz 2 wyrzucił " + str(p2w))
        if p1w > p2w:
            p1z += 1
            print("Gracz 1 wygrał")
            print()
        elif p1w < p2w:
            p2z += 1
            print("Gracz 2 wygrał")
            print()


gra(sys.argv[1])
