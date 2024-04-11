package notepad;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import action.Action;

public class Notepad {

    private int id;
    private String notepad[];
    private Stack<Action> undoAction;
    private Stack<Action> redoAction;

    private Queue<String> clipboard;
    private int capacity;

    public Notepad(int capacity) {
        notepad = new String[capacity];

        for (int i = 0; i < capacity; i++) {
            notepad[i] = "";
        }

        undoAction = new Stack<>();
        redoAction = new Stack<>();
        clipboard = new LinkedList<>();
        this.capacity = capacity;
    }

    public void display() {
        for (int i = 0; i < this.capacity; i++) {
            System.out.println(notepad[i]);
        }
    }

    public void display(int startingline, int endingline) {
        if (startingline <= 0 || startingline > endingline || endingline > this.capacity) {

            System.out.println("Unable to display text,Please check the input");
        }

        for (int i = startingline - 1; i < endingline; i++) {
            System.out.println(notepad[i]);
        }
    }

    public void insertLine(int lineNumber, String text) {
        if (lineNumber > capacity) {
            System.out.println("Notepad limit  crossed");
            return;
        }
        notepad[lineNumber - 1] = text;
        undoAction.push(new Action(id++, LocalDateTime.now(), true, lineNumber, text));
    }

    public void delete(int lineNumber) {
        if (lineNumber > capacity) {
            System.out.println("No such line exist");
            return;
        }
        if (notepad[lineNumber - 1].isEmpty()) {
            System.out.println("Nothing to delete ");
            return;

        }

        redoAction.push(new Action(id++, LocalDateTime.now(), false, lineNumber, notepad[lineNumber - 1]));
        notepad[lineNumber - 1] = "";

    }

    public void delete(int startingline, int endingline) {
        if (startingline > endingline || endingline > capacity) {
            System.out.println("Unable to delete, please check the input");
        }

        for (int i = startingline; i <= endingline; i++) {
            delete(i);
        }
    }

    public void copy(int startingline, int endingline) {
        if (startingline > endingline || endingline > this.capacity) {
            System.out.println("Unable to copy");
            return;
        }

        String coptText = "";
        for (int i = startingline; i <= endingline; i++) {
            coptText += notepad[i] +"\n";
        }

        if (!coptText.isEmpty()) {
            clipboard.add(coptText);
        }
    }
    public void paste(int lineNumber){
        if(this.clipboard.isEmpty())
        {
            System.out.println("Nothing to paste");
            return;
        }

        String text=clipboard.peek();
        insertLine(lineNumber, text);

    }

    public void undo(){
        if(this.undoAction.isEmpty())
        {
            System.out.println("Nothing to undo");
        }

        Action action=this.undoAction.peek();
        this.undoAction.pop();

        delete(action.getLineNumber());
    }

    public void redo(){
        if(this.redoAction.isEmpty())
        {
            System.out.println("Nothing to redo");
        }

        Action action=this.redoAction.peek();
        redoAction.pop();

        insertLine(action.getLineNumber(),action.getText());

    }

}
