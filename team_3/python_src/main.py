from root import Root

# var to toggle cursor following
global follow 
follow = True

global root 
root = Root()

def handleMouseMotion(e): 
    if follow:
        root.updateTrajectory(e.x, e.y)

def handleMouse1(e):
    global follow
    follow = not follow

def handleLeft(e):
    root.moveLeft()

def handleRight(e):
    root.moveRight()

def handleScroll(e): 
    if e.delta > 0: 
        root.increaseVel()
    else: 
        root.decreaseVel()

def main():
    root.bind("<Motion>", handleMouseMotion)
    root.bind("<Button-1>", handleMouse1)
    root.bind("<Left>", handleLeft)
    root.bind("<Right>", handleRight)
    root.bind("<MouseWheel>", handleScroll)
    while True: 
        root.drawTrajectory()
        root.update()

if __name__ == "__main__": 
    main()