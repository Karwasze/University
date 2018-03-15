#!/usr/bin/env python3
# coding: utf8

from math import sqrt
from time import time


def pierwsza_skladana(n):
    pierwsze = [x for x in range(2, n) 
    if all(x % y != 0 for y in range(2, int(sqrt(x)) + 1))]
    return pierwsze


def pierwsza_funkcyjna(n):
    f = list(filter(lambda x: all((x % y != 0 for y in range(2, int(sqrt(x)) + 1))), range(2, n)))
    return f


def doskonale_skladana(n):
    doskonale = [x for x in range(2, n) if sum(y for y in range(1, x) if x % y == 0) == x]
    return doskonale

def doskonale_funkcyjna(n):
    f = list(filter(lambda x : sum(y for y in range(1, x) if x % y == 0) == x, range(2, n)))
    return f

if __name__ == "__main__":
    print("Pierwsza składana")
    t = time()
    print(pierwsza_skladana(1000))
    t1 = time() - t
    print(t1)

    print("Pierwsza funkcyjna")
    t = time()
    print(pierwsza_funkcyjna(1000))
    t1 = time() - t
    print(t1)

    print("Doskonałe składana")
    t = time()
    print(doskonale_skladana(10001))
    t1 = time() - t
    print(t1)

    print("Doskonałe funkcyjna")
    t = time()
    print(doskonale_funkcyjna(10001))
    t1 = time() - t
    print(t1)
