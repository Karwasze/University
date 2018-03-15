def zaszyfruj(tekst, klucz):
	if klucz < 0 or klucz > 255:
		print("Zły przedział klucza")
		return 0

	tekst = ['{:08b}'.format(ord(c)) for c in tekst]

	klucz = '{:08b}'.format(klucz)

	zaszyfrowany = ""
	tekst2 = []
	for i in tekst:
		for j in range(len(i)):
			if(i[j] == '1' and klucz[j] == '1'):
				zaszyfrowany+='0'
			elif(i[j] == '0' and klucz[j] == '1'):
				zaszyfrowany+='1'
			elif(i[j] == '1' and klucz[j] == '0'):
				zaszyfrowany+='1'
			elif(i[j] == '0' and klucz[j] == '0'):
				zaszyfrowany+='0'
		tekst2.append(zaszyfrowany)
		zaszyfrowany = ""
	
	tekst2 = [chr(int(c,2)) for c in tekst2]

	return "".join(tekst2)


print(zaszyfruj("Python", 7))