
class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    TextState head;
    TextState tail;
    TextState current;
    int size;
    final int MAX_HISTORY = 10;

    public TextEditor() {
        head = tail = current = null;
        size = 0;
    }

    public void addState(String content) {
        TextState newState = new TextState(content);

        if (head == null) {
            head = tail = current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
            tail = current;
        }

        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            displayCurrentState();
        } else {
            System.out.println("No more undo available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            displayCurrentState();
        } else {
            System.out.println("No more redo available.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No content available.");
        }
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World!!");
        editor.addState("Hello World!!!");

        editor.displayCurrentState();

        System.out.println("\nUndo Operations:");
        editor.undo();
        editor.undo();

        System.out.println("\nRedo Operations:");
        editor.redo();
        editor.redo();
        editor.redo();
    }
}

