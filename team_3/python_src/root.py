import tkinter as tk
from tkinter import *
from constants import *
from math import *

class Root(Tk):
    objects = []
    canv = None
    robx = 0
    roby = 0
    angle = 0
    velocity = 400 # inches per second

    def __init__(self):
        super(Root, self).__init__()
        self.title("Robo Rollers Code Concept")
        self.minsize(WIDTH, HEIGHT)
        self.resizable(False, False)

        # create canvas
        self.canv = Canvas(self, width=WIDTH, height=HEIGHT, bg="#010012", highlightthickness=0) # highlightthickness removes window border 
        self.canv.pack(fill="both", expand=True)

        # draw goal
        self.drawRect(WIDTH - GOAL_WIDTH, HEIGHT, WIDTH, HEIGHT - self.toPx(GOAL_HEIGHT), fill="#000d54")
        self.drawRect(WIDTH - GOAL_WIDTH, HEIGHT - self.toPx(GOAL_HEIGHT + OPENING), WIDTH, HEIGHT - self.toPx(GOAL_HEIGHT), fill="#a12828")

        # draw white/color border
        self.drawLine(WIDTH - GOAL_WIDTH - self.toPx(ZONE_LEN + GOALIE_LEN), HEIGHT, WIDTH - GOAL_WIDTH - self.toPx(ZONE_LEN + GOALIE_LEN), 0, fill="red", dash=(5, 1))

        # draw goalie border
        self.drawLine(WIDTH - GOAL_WIDTH - self.toPx(GOALIE_LEN), HEIGHT, WIDTH - GOAL_WIDTH - self.toPx(GOALIE_LEN), 0, fill="white", dash=(5, 1))

        # remove these objects, as they are static and won't need to be updated
        self.objects.clear()

        self.robx = ((WIDTH - self.toPx(ROBOT_LEN + ZONE_LEN + GOALIE_LEN) - GOAL_WIDTH) + WIDTH - self.toPx(ZONE_LEN + GOALIE_LEN) - GOAL_WIDTH) / 2
        self.roby = HEIGHT - self.toPx(ROBOT_HEIGHT / 2)

    def toPx(self, inches):
        return inches * 4

    def toInches(self, px):
        return px / 4
        
    def toRad(self, deg): 
        return deg * pi / 180

    def toDeg(self, rad): 
        return rad * 180 / pi

    def angleDiff(self, a, b): 
        angle = a - b
        return (angle + 180.0) % 360.0 - 180.0

    def drawRect(self, x0, y0, x1, y1, fill="#54b6e5"): 
        self.objects.append(self.canv.create_rectangle(x0, y0, x1, y1, fill=fill))

    def drawCircle(self, x, y, r, fill="#ffbb00"): 
        self.objects.append(self.canv.create_oval(x - r, y - r, x + r, y + r, fill=fill))

    def drawLine(self, x0, y0, x1, y1, fill, dash): 
        self.objects.append(self.canv.create_line(x0, y0, x1, y1, fill=fill, dash=dash))

    def drawArrow(self, x, y, angle): 
        angle += 90
        angle %= 360
        ydiff = cos(self.toRad(angle)) * ARROW_LEN
        xdiff = sin(self.toRad(angle)) * ARROW_LEN
        self.objects.append(self.canv.create_line(x, y, x + xdiff, y + ydiff, arrow=tk.LAST))

    def drawText(self, x, y, txt): 
        self.objects.append(self.canv.create_text(x, y, text=txt, font = "Arial 20", fill="white"))

    def clearObjects(self): 
        for obj in self.objects: 
            self.canv.delete(obj)
        self.objects.clear()

    def updateTrajectory(self, x, y): 
        xdiff = abs(x - self.robx)
        ydiff = abs(y - self.roby)
        self.angle = abs(atan2(ydiff, xdiff))

    # trajectory formula
    def calcTrajectory(self, x): 
        return x * tan(self.angle) - (( self.toPx(GRAVITY) * x * x) / (2 * self.toPx(self.velocity) *  self.toPx(self.velocity) * cos(self.angle) * cos(self.angle)))

    def moveRight(self):
        if self.robx + ROBOT_LEN / 2 + GOAL_WIDTH + 1 < WIDTH: 
            self.robx += 2

    def moveLeft(self):
        if self.robx - ROBOT_LEN / 2 - 1 > 0: 
            self.robx -= 2

    def increaseVel(self): 
        self.velocity += 2
    
    def decreaseVel(self): 
        self.velocity -= 2
        if self.velocity < 0: 
            self.velocity = 0.0

    def drawTrajectory(self): 
        self.clearObjects()
        color = "red"

        final = HEIGHT - self.calcTrajectory(WIDTH - int(self.robx)) - self.toPx(ROBOT_HEIGHT)
        if final >= HEIGHT - self.toPx(GOAL_HEIGHT + OPENING) and final <= HEIGHT - self.toPx(GOAL_HEIGHT):
            color = "green"

        # draw robot
        self.drawRect(self.robx - ROBOT_LEN / 2, HEIGHT, self.robx + ROBOT_LEN / 2, HEIGHT - self.toPx(ROBOT_HEIGHT))
        for x in range(int(self.robx), WIDTH, 15): 
            y = HEIGHT - self.calcTrajectory(x - int(self.robx)) - self.toPx(ROBOT_HEIGHT)
            self.drawCircle(x, y, 3, fill=color)

        # write important numbers to screen
        self.drawText(110, 20, "Angle: " + str(round(self.toDeg(self.angle), 2)) + " deg")
        self.drawText(100, 60, "Vel: " + str(round(self.velocity / 12, 2)) + " ft/s")
            
