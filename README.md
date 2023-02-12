# private-RW-SE450

Link to my GitHub: https://github.com/rasawillette/private-RW-SE450

### 1/28 - Sprint 1

1. Draw a rectangle 
2. Undo/Redo 

Bugs: 
1. Can only draw the rectangle from left to right, not right to left
2. Drawn rectangles will not stay on the canvas 

I've been struggling with this assignment and spent a lot of time trying to figure out undo and redo (didn't work). 

### 2/7 Sprint 2: 
1. Draw rectangle, ellipse, triangle
2. Draw different shading types
3. Select mouse mode
4. Move mouse mode 
5. Undo/Redo

Bugs:
1. Can only draw the rectangle and ellipse from the top left to lower right, not right to left

My 2 Design Patterns:
1. **Command**
- Classes: UndoCommand, RedoCommand, DrawShapeCommand, SelectShapeCommand, MoveShapeCommand
- Interfaces: ICommand (previously "IAtmCommand") & IUndoable
2. **State**
- Classes: MouseHandler, DrawMouseState, SelectMouseState, MoveMouseState
- Interfaces: IMouseState


