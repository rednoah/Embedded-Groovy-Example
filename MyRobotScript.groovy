create 'X1'

X1.move RIGHT
X1.move UP

register 'X2@10,10'.toRobot()

repeat(5) {
  X2.move LEFT
  X2.move DOWN
}

X1.doSomething
