# private-RW-SE450

**Link to my GitHub**: https://github.com/rasawillette/private-RW-SE450

Link to sprint 1 (main branch): https://github.com/rasawillette/private-RW-SE450/tree/main

Link to sprint 2 (450-sprint-2 branch): https://github.com/rasawillette/private-RW-SE450/tree/450-sprint-2

Link to sprint 2 Re-Submission (sprint-2-redo): https://github.com/rasawillette/private-RW-SE450/tree/sprint-2-redo

Link to sprint 3 (sprint-3-submission branch): https://github.com/rasawillette/private-RW-SE450/tree/sprint-3-submission/jpaint

### 1/28 - Sprint 1

Implementations:
1. Draw a rectangle
2. Undo/Redo

Bugs:
1. Can only draw the rectangle from left to right, not right to left
2. Drawn rectangles will not stay on the canvas

Notes: I've been struggling with this assignment and spent a lot of time trying to figure out undo and redo (didn't work).

### 2/7 Sprint 2 &
### 2/17 Sprint 2 Re-Submission

Implementations:
1. Draw rectangle, ellipse, triangle
2. Draw different shading types
3. Select mouse mode
4. Move mouse mode
5. Undo/Redo

Bugs:
1. N/A

My 2 Design Patterns:
1. **Command**
- Classes: UndoCommand, RedoCommand, DrawShapeCommand, SelectShapeCommand, MoveShapeCommand
- Interfaces: ICommand (previously "IAtmCommand") & IUndoable

2. **State**
- Classes: MouseHandler, DrawMouseState, SelectMouseState, MoveMouseState
- Interfaces: IMouseState

### 2/24 - Sprint 3

Link to sprint 3 (sprint-3-submission branch): https://github.com/rasawillette/private-RW-SE450/tree/sprint-3-submission/jpaint

Implementations:
1. Copy
2. Paste
3. Delete
4. Outline Selected Shapes
5. Undo/Redo Copy and Paste
6. 4 Design Patterns

Bugs:
1. Paste command removes the original shape and pastes it on the offset
2. Select outline is wonky for rectangle and ellipse, works for triangle

My 4 Design Patterns:
1. **Command**
- Classes: UndoCommand, RedoCommand, DrawShapeCommand, SelectShapeCommand, MoveShapeCommand, CopyCommand, DeleteCommand, PasteCommand
- Interfaces: ICommand & IUndoable

2. **State**
- Classes: MouseHandler, DrawMouseState, SelectMouseState, MoveMouseState
- Interfaces: IMouseState

3. **Strategy**
- Classes: Rectangle, Ellipse, Triangle
- Interfaces: IShape

4. **Proxy**
- Classes: ShapeOutline, ShapeOutlineProxy, RectangleOutline, TriangleOutline, EllipseOutline
- Interfaces: IProxyOutline


### 3/8 - Sprint 4

Link to sprint 4 (sprint-4 branch): 

Implementations:
1. Group
2. Ungroup
5. Undo/Redo Group and Ungroup
6. 5 Design Patterns

Bugs:
1. N/A

My 5 Design Patterns:
1. **Command**
- Classes: UndoCommand, RedoCommand, DrawShapeCommand, SelectShapeCommand, MoveShapeCommand, CopyCommand, DeleteCommand, PasteCommand
- Interfaces: ICommand & IUndoable

2. **State**
- Classes: MouseHandler, DrawMouseState, SelectMouseState, MoveMouseState
- Interfaces: IMouseState

3. **Strategy**
- Classes: Rectangle, Ellipse, Triangle
- Interfaces: IShape

4. **Proxy**
- Classes: ShapeOutline, ShapeOutlineProxy, RectangleOutline, TriangleOutline, EllipseOutline
- Interfaces: IProxyOutline

5. **add 5th here**
- Classes:
- Interfaces: 

