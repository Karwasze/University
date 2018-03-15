from math import sqrt
from time import time
import matplotlib.pyplot as plt
def pierwsza_skladana(n):
	pierwsze = [x for x in range(2, n) if all(x % y != 0 for y in range(2, int(sqrt(x)) + 1))]
	return pierwsze

def pierwsza_funkcyjna(n):
	f = list(filter(lambda x: all((x % y != 0 for y in range(2, int(sqrt(x)) + 1))), range(2, n)))
	return f

def pierwsza_iterator(n):
	for i in range(2,n):
		for j in range(2, int(sqrt(i) + 1)):
			if i % j == 0:
				break
		else:
			yield(i)
				

def doskonale_skladana(n):
	doskonale = [x for x in range(2, n) if sum(y for y in range(1, x) if x % y == 0) == x]
	return doskonale

def doskonale_funkcyjna(n):
	f = list(filter(lambda x : sum(y for y in range(1, x) if x % y == 0) == x, range(2, n)))
	return f

def doskonale_iterator(n):
	for i in range(2, n):
		sum = 0
		for j in range(1, i):
			if i % j == 0:
				sum += j
		if sum == i:
			yield(i)


if __name__ == "__main__":
	tab_p_funkcyjna = []
	tab_p_skladana = []
	tab_p_iterator = []

	tab_d_funkcyjna = []
	tab_d_skladana = []
	tab_d_iterator = []

	#PIERWSZA SKLADANA
	t = time()
	pierwsza_skladana(10)
	t1 = time() - t
	tab_p_skladana.append(t1)

	t = time()
	pierwsza_skladana(100)
	t1 = time() - t
	tab_p_skladana.append(t1)

	t = time()
	pierwsza_skladana(1000)
	t1 = time() - t
	tab_p_skladana.append(t1)

	#PIERWSZA FUNKCYJNA
	t = time()
	pierwsza_funkcyjna(10)
	t1 = time() - t
	tab_p_funkcyjna.append(t1)

	t = time()
	pierwsza_funkcyjna(100)
	t1 = time() - t
	tab_p_funkcyjna.append(t1)

	t = time()
	pierwsza_funkcyjna(1000)
	t1 = time() - t
	tab_p_funkcyjna.append(t1)

	#PIERWSZA ITERATOR
	t = time()
	[x for x in pierwsza_iterator(10)]
	t1 = time() - t
	tab_p_iterator.append(t1)

	t = time()
	[x for x in pierwsza_iterator(100)]
	t1 = time() - t
	tab_p_iterator.append(t1)

	t = time()
	[x for x in pierwsza_iterator(1000)]
	t1 = time() - t
	tab_p_iterator.append(t1)

	#DOSKONALA SKLADANA
	t = time()
	doskonale_skladana(10)
	t1 = time() - t
	tab_d_skladana.append(t1)

	t = time()
	doskonale_skladana(100)
	t1 = time() - t
	tab_d_skladana.append(t1)

	t = time()
	doskonale_skladana(1000)
	t1 = time() - t
	tab_d_skladana.append(t1)

	#DOSKONALA FUNKCYJNA
	t = time()
	doskonale_funkcyjna(10)
	t1 = time() - t
	tab_d_funkcyjna.append(t1)

	t = time()
	doskonale_funkcyjna(100)
	t1 = time() - t
	tab_d_funkcyjna.append(t1)

	t = time()
	doskonale_funkcyjna(1000)
	t1 = time() - t
	tab_d_funkcyjna.append(t1)

	#DOSKONALA ITERATOR
	t = time()
	[x for x in doskonale_iterator(10)]
	t1 = time() - t
	tab_d_iterator.append(t1)

	t = time()
	[x for x in doskonale_iterator(100)]
	t1 = time() - t
	tab_d_iterator.append(t1)

	t = time()
	[x for x in doskonale_iterator(1000)]
	t1 = time() - t
	tab_d_iterator.append(t1)
	
	print(tab_p_funkcyjna)
	print(tab_p_skladana)
	print(tab_p_iterator)
	print()
	print(tab_d_funkcyjna)
	print(tab_d_skladana)
	print(tab_d_iterator)
	
	plt.plot([10,100,1000],tab_p_funkcyjna)
	plt.plot([10,100,1000],tab_p_skladana)
	plt.plot([10,100,1000],tab_p_iterator)
	plt.show()
	"""
	plt.plot([10,100,1000],tab_d_funkcyjna)
	plt.plot([10,100,1000],tab_d_skladana)
	plt.plot([10,100,1000],tab_d_iterator)
	"""
	plt.show()