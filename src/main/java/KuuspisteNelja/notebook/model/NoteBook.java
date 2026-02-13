package KuuspisteNelja.notebook.model;

import java.util.ArrayList;
import java.util.List;

public class NoteBook {
    private List<Note>  notes;

    public NoteBook() {
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotes() {
        return notes;
    }
}
