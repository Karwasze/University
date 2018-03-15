from tkinter import *
import sqlite3
from datetime import date
import threading
import time


class Window:
    def __init__(self):
        self.top = Tk()
        self.top.title("Project")
        self.showMain()
        self.top.mainloop()


    def showMain(self):
        self.timervariable = StringVar()
        self.timervariable.set("TIMER")
        self.currentFrame = Frame(self.top)
        self.currentFrame.pack()
        self.trainingA = Button(self.currentFrame, text="Training A", command = self.showTrainingA)
        self.trainingB = Button(self.currentFrame, text="Training B", command = self.showTrainingB)
        self.timerFrame = Frame(self.currentFrame)
        self.timer = Label(self.timerFrame, textvariable = self.timervariable)
        self.timerButton = Button(self.timerFrame, text = "START", command = self.timerFunc)
        self.trainingA.pack()
        self.trainingB.pack()
        self.timer.pack()
        self.timerButton.pack()
        self.timerFrame.pack()


    def backMain(self):
        self.currentFrame.pack_forget()
        self.currentFrame = Frame(self.top)
        self.currentFrame.pack()
        self.trainingA = Button(self.currentFrame, text="Training A", command = self.showTrainingA)
        self.trainingB = Button(self.currentFrame, text="Training B", command = self.showTrainingB)
        self.timerFrame = Frame(self.currentFrame)
        self.timer = Label(self.timerFrame, textvariable=self.timervariable)
        self.timerButton = Button(self.timerFrame, text="START", command = self.timerFunc)
        self.trainingA.pack()
        self.trainingB.pack()
        self.timer.pack()
        self.timerButton.pack()
        self.timerFrame.pack()


    def showTrainingA(self):
        self.currentFrame.pack_forget()
        self.currentFrame = Frame(self.top)
        self.squat = Button(self.currentFrame, text="Squat",command = self.showSquatA)
        self.benchPress = Button(self.currentFrame, text="Bench Press", command = self.showBenchPress)
        self.barbellRow = Button(self.currentFrame, text="Barbell Row", command = self.showBarbellRow)
        self.back = Button(self.currentFrame, text = "Back", command = self.backMain)
        self.timerFrame = Frame(self.currentFrame)
        self.timer = Label(self.timerFrame, textvariable=self.timervariable)
        self.timerButton = Button(self.timerFrame, text="START", command = self.timerFunc)
        self.squat.pack()
        self.benchPress.pack()
        self.barbellRow.pack()
        self.back.pack()
        self.currentFrame.pack()
        self.timer.pack()
        self.timerButton.pack()
        self.timerFrame.pack()


    def showTrainingB(self):
        self.currentFrame.pack_forget()
        self.currentFrame = Frame(self.top)
        self.squat = Button(self.currentFrame, text="Squat", command = self.showSquatB)
        self.ohp = Button(self.currentFrame, text="Overhead Press", command = self.showOverheadPress)
        self.deadlift = Button(self.currentFrame, text="Deadlift", command = self.showDeadlift)
        self.back = Button(self.currentFrame, text="Back", command = self.backMain)
        self.timerFrame = Frame(self.currentFrame)
        self.timer = Label(self.timerFrame, textvariable=self.timervariable)
        self.timerButton = Button(self.timerFrame, text="START", command = self.timerFunc)
        self.squat.pack()
        self.ohp.pack()
        self.deadlift.pack()
        self.back.pack()
        self.currentFrame.pack()
        self.timer.pack()
        self.timerButton.pack()
        self.timerFrame.pack()


    def showSquatA(self):
        self.name = "Squat"
        self.currentFrame.pack_forget()
        self.currentFrame = Frame(self.top)
        self.reps = Label(self.currentFrame, text = "Reps")
        self.repsSpinbox = Spinbox(self.currentFrame, from_=0, to=20)
        self.weight = Label(self.currentFrame, text="Weight")
        self.weightSpinbox = Spinbox(self.currentFrame, from_=20, to=500)

        self.info = Label(self.currentFrame, text = "Reps, Weight, Date")

        self.lastEntry = Listbox(self.currentFrame, selectmode=SINGLE, height=3, width=40)
        self.lastEntry.config(width=0)
        for index, row in enumerate(kursor.execute("SELECT Reps, Weight, Date FROM Exercises WHERE Name = 'Squat' ORDER BY ROWID DESC LIMIT 3")):
            self.lastEntry.insert(index, row)

        self.completeSet = Button(self.currentFrame, text="Complete Set",
                                      command=lambda: self.completeSetfunc("Squat", self.repsSpinbox.get(),
                                                                           self.weightSpinbox.get()))
        self.back = Button(self.currentFrame, text = "Back", command = self.showTrainingA)
        self.timerFrame = Frame(self.currentFrame)
        self.timer = Label(self.timerFrame, textvariable=self.timervariable)
        self.timerButton = Button(self.timerFrame, text="START", command = self.timerFunc)
        self.reps.pack()
        self.repsSpinbox.pack()
        self.weight.pack()
        self.weightSpinbox.pack()
        self.info.pack()
        self.lastEntry.pack()
        self.completeSet.pack()
        self.back.pack()
        self.currentFrame.pack()
        self.timer.pack()
        self.timerButton.pack()
        self.timerFrame.pack()


    def showSquatB(self):
        self.name = "Squat"
        self.currentFrame.pack_forget()
        self.currentFrame = Frame(self.top)
        self.reps = Label(self.currentFrame, text="Reps")
        self.repsSpinbox = Spinbox(self.currentFrame, from_=0, to=20)
        self.weight = Label(self.currentFrame, text="Weight")
        self.weightSpinbox = Spinbox(self.currentFrame, from_=20, to=500)

        self.info = Label(self.currentFrame, text="Reps, Weight, Date")
        self.lastEntry = Listbox(self.currentFrame, selectmode=SINGLE, height=3, width=40)
        self.lastEntry.config(width=0)
        for index, row in enumerate(kursor.execute(
                "SELECT Reps, Weight, Date FROM Exercises WHERE Name = 'Squat' ORDER BY ROWID DESC LIMIT 3")):
            self.lastEntry.insert(index, row)

        self.completeSet = Button(self.currentFrame, text="Complete Set",
                                      command=lambda: self.completeSetfunc("Squat", self.repsSpinbox.get(),
                                                                           self.weightSpinbox.get()))
        self.back = Button(self.currentFrame, text="Back", command=self.showTrainingB)
        self.timerFrame = Frame(self.currentFrame)
        self.timer = Label(self.timerFrame, textvariable=self.timervariable)
        self.timerButton = Button(self.timerFrame, text="START", command = self.timerFunc)
        self.reps.pack()
        self.repsSpinbox.pack()
        self.weight.pack()
        self.weightSpinbox.pack()
        self.info.pack()
        self.lastEntry.pack()
        self.completeSet.pack()
        self.back.pack()
        self.currentFrame.pack()
        self.timer.pack()
        self.timerButton.pack()
        self.timerFrame.pack()


    def showBenchPress(self):
        self.name = "BenchPress"
        self.currentFrame.pack_forget()
        self.currentFrame = Frame(self.top)
        self.reps = Label(self.currentFrame, text="Reps")
        self.repsSpinbox = Spinbox(self.currentFrame, from_=0, to=20)
        self.weight = Label(self.currentFrame, text="Weight")
        self.weightSpinbox = Spinbox(self.currentFrame, from_=20, to=500)

        self.info = Label(self.currentFrame, text="Reps, Weight, Date")
        self.lastEntry = Listbox(self.currentFrame, selectmode=SINGLE, height=3, width=40)
        self.lastEntry.config(width=0)
        for index, row in enumerate(kursor.execute(
                "SELECT Reps, Weight, Date FROM Exercises WHERE Name = 'BenchPress' ORDER BY ROWID DESC LIMIT 3")):
            self.lastEntry.insert(index, row)

        self.completeSet = Button(self.currentFrame, text="Complete Set",
                                      command=lambda: self.completeSetfunc("BenchPress", self.repsSpinbox.get(),
                                                                           self.weightSpinbox.get()))
        self.back = Button(self.currentFrame, text="Back", command=self.showTrainingA)
        self.timerFrame = Frame(self.currentFrame)
        self.timer = Label(self.timerFrame, textvariable=self.timervariable)
        self.timerButton = Button(self.timerFrame, text="START", command = self.timerFunc)
        self.reps.pack()
        self.repsSpinbox.pack()
        self.weight.pack()
        self.weightSpinbox.pack()
        self.info.pack()
        self.lastEntry.pack()
        self.completeSet.pack()
        self.back.pack()
        self.currentFrame.pack()
        self.timer.pack()
        self.timerButton.pack()
        self.timerFrame.pack()


    def showBarbellRow(self):
        self.name = "BarbellRow"
        self.currentFrame.pack_forget()
        self.currentFrame = Frame(self.top)
        self.reps = Label(self.currentFrame, text="Reps")
        self.repsSpinbox = Spinbox(self.currentFrame, from_=0, to=20)
        self.weight = Label(self.currentFrame, text="Weight")
        self.weightSpinbox = Spinbox(self.currentFrame, from_=20, to=500)
        self.info = Label(self.currentFrame, text="Reps, Weight, Date")

        self.lastEntry = Listbox(self.currentFrame, selectmode=SINGLE, height=3, width=40)
        self.lastEntry.config(width=0)
        for index, row in enumerate(kursor.execute(
                "SELECT Reps, Weight, Date FROM Exercises WHERE Name = 'BarbellRow' ORDER BY ROWID DESC LIMIT 3")):
            self.lastEntry.insert(index, row)
        self.completeSet = Button(self.currentFrame, text="Complete Set",
                                      command=lambda: self.completeSetfunc("BarbellRow", self.repsSpinbox.get(),
                                                                           self.weightSpinbox.get()))
        self.back = Button(self.currentFrame, text="Back", command=self.showTrainingA)
        self.timerFrame = Frame(self.currentFrame)
        self.timer = Label(self.timerFrame, textvariable=self.timervariable)
        self.timerButton = Button(self.timerFrame, text="START", command = self.timerFunc)
        self.reps.pack()
        self.repsSpinbox.pack()
        self.weight.pack()
        self.weightSpinbox.pack()
        self.info.pack()
        self.lastEntry.pack()
        self.completeSet.pack()
        self.back.pack()
        self.currentFrame.pack()
        self.timer.pack()
        self.timerButton.pack()
        self.timerFrame.pack()


    def showOverheadPress(self):
        self.name = "OverheadPress"
        self.currentFrame.pack_forget()
        self.currentFrame = Frame(self.top)
        self.reps = Label(self.currentFrame, text="Reps")
        self.repsSpinbox = Spinbox(self.currentFrame, from_=0, to=20)
        self.weight = Label(self.currentFrame, text="Weight")
        self.weightSpinbox = Spinbox(self.currentFrame, from_=20, to=500)

        self.info = Label(self.currentFrame, text="Reps, Weight, Date")
        self.lastEntry = Listbox(self.currentFrame, selectmode=SINGLE, height=3, width=40)
        self.lastEntry.config(width=0)
        for index, row in enumerate(kursor.execute(
                "SELECT Reps, Weight, Date FROM Exercises WHERE Name = 'OverheadPress' ORDER BY ROWID DESC LIMIT 3")):
            self.lastEntry.insert(index, row)

        self.completeSet = Button(self.currentFrame, text="Complete Set",
                                      command=lambda: self.completeSetfunc("OverheadPress", self.repsSpinbox.get(),
                                                                           self.weightSpinbox.get()))
        self.back = Button(self.currentFrame, text="Back", command=self.showTrainingB)
        self.timerFrame = Frame(self.currentFrame)
        self.timer = Label(self.timerFrame, textvariable=self.timervariable)
        self.timerButton = Button(self.timerFrame, text="START", command = self.timerFunc)
        self.reps.pack()
        self.repsSpinbox.pack()
        self.weight.pack()
        self.weightSpinbox.pack()
        self.completeSet.pack()
        self.info.pack()
        self.lastEntry.pack()
        self.back.pack()
        self.currentFrame.pack()
        self.timer.pack()
        self.timerButton.pack()
        self.timerFrame.pack()


    def showDeadlift(self):
        self.name = "Deadlift"
        self.currentFrame.pack_forget()
        self.currentFrame = Frame(self.top)
        self.reps = Label(self.currentFrame, text="Reps")
        self.repsSpinbox = Spinbox(self.currentFrame, from_=0, to=20)
        self.weight = Label(self.currentFrame, text="Weight")
        self.weightSpinbox = Spinbox(self.currentFrame, from_=20, to=500)

        self.info = Label(self.currentFrame, text="Reps, Weight, Date")
        self.lastEntry = Listbox(self.currentFrame, selectmode=SINGLE, height=3, width=40)
        self.lastEntry.config(width=0)
        for index, row in enumerate(kursor.execute(
                "SELECT Reps, Weight, Date FROM Exercises WHERE Name = 'Deadlift' ORDER BY ROWID DESC LIMIT 3")):
            self.lastEntry.insert(index, row)

        self.completeSet = Button(self.currentFrame, text="Complete Set", command=lambda: self.completeSetfunc("Deadlift", self.repsSpinbox.get(), self.weightSpinbox.get()))
        self.back = Button(self.currentFrame, text="Back", command=self.showTrainingA)
        self.timerFrame = Frame(self.currentFrame)
        self.timer = Label(self.timerFrame, textvariable=self.timervariable)
        self.timerButton = Button(self.timerFrame, text="START", command = self.timerFunc)
        self.reps.pack()
        self.repsSpinbox.pack()
        self.weight.pack()
        self.weightSpinbox.pack()
        self.info.pack()
        self.lastEntry.pack()
        self.completeSet.pack()
        self.back.pack()
        self.currentFrame.pack()
        self.timer.pack()
        self.timerButton.pack()
        self.timerFrame.pack()


    def completeSetfunc(self, name, reps, weight):
        self.name = name
        self.reps = int(reps)
        self.weight = int(weight)
        self.date = date.today()

        kursor.execute('''INSERT INTO Exercises(Name, Reps, Weight, Date)
        				  VALUES(?,?,?,?)''', (self.name, self.reps, self.weight, self.date))
        db.commit()
        if self.name == "Squat":
            self.lastEntry.delete(0, self.lastEntry.size())
            for index, row in enumerate(kursor.execute(
                    "SELECT Reps, Weight, Date FROM Exercises WHERE Name = ? ORDER BY ROWID DESC LIMIT 3", (self.name,))):
                self.lastEntry.insert(index, row)

        if self.name == "BenchPress":
            self.lastEntry.delete(0, self.lastEntry.size())
            for index, row in enumerate(kursor.execute(
                    "SELECT Reps, Weight, Date FROM Exercises WHERE Name = ? ORDER BY ROWID DESC LIMIT 3",
                    (self.name,))):
                self.lastEntry.insert(index, row)

        if self.name == "BarbellRow":
            self.lastEntry.delete(0, self.lastEntry.size())
            for index, row in enumerate(kursor.execute(
                    "SELECT Reps, Weight, Date FROM Exercises WHERE Name = ? ORDER BY ROWID DESC LIMIT 3",
                    (self.name,))):
                self.lastEntry.insert(index, row)

        if self.name == "OverheadPress":
            self.lastEntry.delete(0, self.lastEntry.size())
            for index, row in enumerate(kursor.execute(
                    "SELECT Reps, Weight, Date FROM Exercises WHERE Name = ? ORDER BY ROWID DESC LIMIT 3",
                    (self.name,))):
                self.lastEntry.insert(index, row)

        if self.name == "Deadlift":
            self.lastEntry.delete(0, self.lastEntry.size())
            for index, row in enumerate(kursor.execute(
                    "SELECT Reps, Weight, Date FROM Exercises WHERE Name = ? ORDER BY ROWID DESC LIMIT 3",
                    (self.name,))):
                self.lastEntry.insert(index, row)

    def timerFunc(self):
        self.t = threading.Thread(target=self.printTime, args=(90,))
        if threading.active_count() == 1:
            self.t.start()




    def printTime(self, timeset):
        for i in range(timeset,-1,-1):
            time.sleep(1)
            self.timervariable.set(str(i))
        self.timervariable.set("TIMER")









if __name__ == '__main__':
    db = sqlite3.connect('exercise.db')

    kursor = db.cursor()

    kursor.execute("create table if not exists Exercises (Name text, Reps INT, Weight INT, Date DATE)")
    """
    kursor.execute("INSERT INTO Exercises VALUES ('Squat','8','6','2006-01-03')")
    kursor.execute("INSERT INTO Exercises VALUES ('Squat','5','5','2006-01-02')")
    kursor.execute("INSERT INTO Exercises VALUES ('Squat','4','4','2006-01-01')")
    kursor.execute("INSERT INTO Exercises VALUES ('Squat','3','3','2006-01-07')")
    kursor.execute("INSERT INTO Exercises VALUES ('Squat','2','2','2006-01-05')")
    kursor.execute("INSERT INTO Exercises VALUES ('Squat','1','1','2006-01-06')")
    kursor.execute("INSERT INTO Exercises VALUES ('BenchPress','5','200','1995-01-05')")
    kursor.execute("INSERT INTO Exercises VALUES ('OverheadPress','5','20','2012-01-06')")
    kursor.execute("INSERT INTO Exercises VALUES ('BarbellRow','20','33','2002-01-05')")
    kursor.execute("INSERT INTO Exercises VALUES ('Deadlift','5','100','2016-01-06')")
    db.commit()
    """
    Window()