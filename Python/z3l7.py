import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk
from gi.repository import GObject

class MyWindow(Gtk.Window):
    def __init__(self):
        Gtk.Window.__init__(self, title="")
        timeRemaining = "0:00:00"


        self.set_border_width(10)
        
        grid = Gtk.Grid()
        grid.set_row_spacing(6)
        self.add(grid)
        
        hourAdjustment = Gtk.Adjustment(0, 0, 24, 1, 10, 0)
        minuteAdjustment = Gtk.Adjustment(0, 0, 59, 1, 10, 0)
        secondAdjustment = Gtk.Adjustment(0, 0, 59, 1, 10, 0)

        self.hour = Gtk.SpinButton()
        self.hour.set_adjustment(hourAdjustment)
        self.hour.set_numeric(True)

        self.minute = Gtk.SpinButton()
        self.minute.set_adjustment(minuteAdjustment)
        self.minute.set_numeric(True)

        self.second = Gtk.SpinButton()
        self.second.set_adjustment(secondAdjustment)
        self.second.set_numeric(True)

        self.label = Gtk.Label(timeRemaining)

        self.button = Gtk.Button.new_with_label("Start")
        self.button.connect("clicked", self.on_click_me_clicked)

        grid.add(self.hour)
        grid.add(self.minute)
        grid.add(self.second)
        grid.attach(self.label, 0, 1, 3, 1)
        grid.attach(self.button, 0, 2, 3, 1)

    def on_click_me_clicked(self, button):
        if self.button.get_label() == "Start":
            self.button.set_label("Stop")
            self.init()
            self.timer()
        else:
            self.button.set_label("Start")

    def init(self):
        self.hourTime = self.hour.get_value_as_int()
        self.minuteTime = self.minute.get_value_as_int()
        self.secondTime = self.second.get_value_as_int()

    def settext(self):
        self.label.set_text(str(self.hourTime)+":"+str(self.minuteTime)+":"+str(self.secondTime))

    def timer(self):        
        self.settext()
        if self.secondTime > 0:
            self.label.set_text(str(self.hourTime)+":"+str(self.minuteTime)+":"+str(self.secondTime))
            self.secondTime -= 1
            Gtk.timeout_add(1000, self.timer)
        elif self.minuteTime > 0:
            self.label.set_text(str(self.hourTime)+":"+str(self.minuteTime)+":"+str(self.secondTime))
            self.minuteTime -= 1
            self.secondTime += 59
            Gtk.timeout_add(1000, self.timer)
        elif self.hourTime > 0:
            self.label.set_text(str(self.hourTime)+":"+str(self.minuteTime)+":"+str(self.secondTime))
            self.hourTime -= 1
            self.minuteTime += 59
            self.secondTime += 59
            Gtk.timeout_add(1000, self.timer)

win = MyWindow()
win.connect("delete-event", Gtk.main_quit)
win.show_all()
Gtk.main()