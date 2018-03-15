from tkinter import *
from tkinter import ttk
import sqlite3

db = sqlite3.connect('temp.db')
kursor = db.cursor()
#kursor.execute("create table Numbers (Number text, Name text, Last_call text)")
#kursor.execute("INSERT INTO Numbers VALUES ('691321200','Mama','2006-01-05')")
#kursor.execute("INSERT INTO Numbers VALUES ('691321201','ABC','2006-01-05')")
#kursor.execute("INSERT INTO Numbers VALUES ('691321202','DAAB','2006-01-05')")
db.commit()

class Window():
	def __init__(self):
		self.top = Tk()
		self.listbox = Listbox(self.top, selectmode = SINGLE)
		self.listbox.config(width=0)
		self.add = Button(self.top, text = "Add", command = self.f_add)
		self.display = Button(self.top, text = "Display")
		self.update = Button(self.top, text = "Update", command = self.f_update)
		self.remove = Button(self.top, text = "Remove", command = self.f_remove)
		self.search = Button(self.top, text = "Search", command = self.f_search)
		self.display_db()
		
		self.add.pack()
		self.update.pack()
		self.remove.pack()
		self.search.pack()
		self.listbox.pack()
		self.top.mainloop()


	def display_db(self):
		self.listbox.delete(0, self.listbox.size())
		for index, row in enumerate(kursor.execute("SELECT * FROM Numbers")):
			self.listbox.insert(index, row)

	def f_add(self):
		self.window = Toplevel(self.top)

		self.entry_number = Entry(self.window)
		self.entry_name = Entry(self.window)
		self.entry_last_call = Entry(self.window)

		self.button = Button(self.window, text = "Ok", command = self.add_entry_get)
		self.entry_number.pack()
		self.entry_name.pack()
		self.entry_last_call.pack()
		self.button.pack()

	def add_entry_get(self):
		self.new_number = self.entry_number.get()
		self.new_name = self.entry_name.get()
		self.new_last_call = self.entry_last_call.get()

		kursor.execute('''INSERT INTO Numbers(Number, Name, Last_call)
				  VALUES(?,?,?)''', (self.new_number,self.new_name, self.new_last_call))
		self.display_db()
		db.commit()
		self.window.destroy()

	def f_update(self):
		self.window = Toplevel(self.top)
		#curselection()

		self.entry_number = Entry(self.window)
		self.entry_name = Entry(self.window)
		self.entry_last_call = Entry(self.window)

		self.button = Button(self.window, text = "Ok", command = self.update_entry_get)
		self.entry_number.pack()
		self.entry_name.pack()
		self.entry_last_call.pack()
		self.button.pack()

	def update_entry_get(self):
		self.new_number = self.entry_number.get()
		self.new_name = self.entry_name.get()
		self.new_last_call = self.entry_last_call.get()
		
		self.index = self.listbox.curselection()
		self.old_string = self.listbox.get(self.index)
		
		
		self.old_number = self.old_string[0]

		kursor.execute("UPDATE Numbers SET Number = ?, Name = ?, Last_call = ? WHERE Number = ?", (self.new_number, self.new_name, self.new_last_call, self.old_number)) 
		self.display_db()
		db.commit()
		self.window.destroy()

	def f_remove(self):
		self.window = Toplevel(self.top)
		self.label = Label(self.window, text="Do you really want to remove the entry")
		self.button = Button(self.window, text = "Ok", command = self.f_remove_ok)
		self.button1 = Button(self.window, text = "Cancel", command = self.window.destroy)
		self.label.pack()
		self.button1.pack()
		self.button.pack()

	def f_remove_ok(self):
		if not self.listbox.curselection():
			self.window.destroy()
		else:
			self.index = self.listbox.curselection()
			self.old_string = self.listbox.get(self.index)
			
			self.old_number = self.old_string[0]
			
			kursor.execute("DELETE FROM Numbers WHERE Number = ?", (self.old_number,))

			self.display_db()
			db.commit()
			self.window.destroy()

	def f_search(self):
		self.window = Toplevel(self.top)
		self.entry_name = Entry(self.window)
		self.button = Button(self.window, text = "Ok", command=self.search_ok)
		self.entry_name.pack()
		self.button.pack()

	def search_ok(self):
		self.name = self.entry_name.get()
		self.window.destroy()
		self.window = Toplevel(self.top)
		self.listbox = Listbox(self.window, selectmode = SINGLE)
		self.listbox.config(width=0)
		for index, row in enumerate(kursor.execute("SELECT * FROM Numbers WHERE Name = ?", (self.name,))):
			self.listbox.insert(index, row)
		self.exitbutton = Button(self.window, text = "OK", command = self.window.destroy)
		self.listbox.pack()
		self.exitbutton.pack()

if __name__ == '__main__':
	Window()



