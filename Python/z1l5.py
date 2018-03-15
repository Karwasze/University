import html.parser
import urllib.request
from bs4 import BeautifulSoup
from urllib.parse import urljoin


def example(html):
	html = BeautifulSoup(urllib.request.urlopen(html).read(), "lxml")
	X = [text for text in html.stripped_strings]
	for i in X:
		if "Python" in i:
			yield i

class Module():
	def __init__(self, html, function, maxdepth):
		try:
			self.html = BeautifulSoup(urllib.request.urlopen(html).read(), "lxml")
		except Exception:
			self.html = None
			print("ERROR")
		self.function = function
		self.maxdepth = maxdepth
		self.url = html
		self.set = set([])
	
	def generate(self):
		if self.html == None:
			pass 
		else:
			for link in self.html.find_all("a"):
				if "http" not in str(link.get("href")):
					self.set.add(str(urljoin(str(self.url), str(link.get("href")))))
				else:
					self.set.add(str(link.get("href")))
				
		print(list(self.function))

		if self.maxdepth > 0:
			for i in self.set:
				x = Module(i, example(i), self.maxdepth - 1)
				x.generate()

new = Module(example("https://www.python.org/"), example("https://www.python.org/"), 1)
new.generate()