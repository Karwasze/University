import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk, GdkPixbuf
import glob


class MyWindow(Gtk.Window):
    def __init__(self):
        Gtk.Window.__init__(self, title="Image Viewer")

        self.folder = "/Users/karolkedzierski/Desktop/"
        self.plik = ""

        self.grid = Gtk.Grid()
        self.add(self.grid)

        self.image = Gtk.Image()
        self.image.show()
        
        self.grid.add(self.image)
        self.add(self.image)
        
        self.entry = Gtk.Entry()
        self.add(self.entry)
        self.entry.set_text("/Users/karolkedzierski/Desktop/")

        self.button = Gtk.Button.new_with_label("Open")
        self.button.connect("clicked", self.on_click_me_clicked)

        self.previous = Gtk.Button.new_with_label("Previous")
        self.previous.connect("clicked", self.on_click_previous)

        self.next = Gtk.Button.new_with_label("Next")
        self.next.connect("clicked", self.on_click_next)

        self.grid.attach(self.previous, 0 ,3 ,1, 1)
        self.grid.attach(self.next, 0, 4, 1, 1)
        self.grid.attach(self.entry, 0, 1, 2, 1)
        self.grid.attach(self.button, 0, 2, 2, 1)
    
    def on_click_me_clicked(self, button):
        self.folder = self.entry.get_text()
        self.lista = glob.glob(self.folder + "*.png")
        self.lista += glob.glob(self.folder + "*.jpg")
        self.lista += glob.glob(self.folder + "*.bmp")
        self.dlugosc = len(self.lista)-1
        self.index = 0
        self.image.set_from_file(self.lista[self.index])

    def on_click_previous(self, button):
        if(self.index == 0):
            self.index = self.dlugosc
            self.image.set_from_file(self.lista[self.index])
        else:
            self.index -= 1
            self.image.set_from_file(self.lista[self.index])

    def on_click_next(self, button):
        if(self.index == self.dlugosc):
            self.index = 0
            self.image.set_from_file(self.lista[self.index])
        else:
            self.index += 1
            self.image.set_from_file(self.lista[self.index])
        


if __name__ == "__main__":
    win = MyWindow()
    win.connect("delete-event", Gtk.main_quit)
    win.show_all()
    Gtk.main()