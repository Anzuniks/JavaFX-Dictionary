package KuuspisteNelja.notebook.controller;


import KuuspisteNelja.notebook.model.Note;
import KuuspisteNelja.notebook.model.NoteBook;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;


public class NoteController {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private ListView<Note> noteListView;

    @FXML
    Button addNoteButton;

    private NoteBook notebook = new NoteBook();

    @FXML
    private void handleAddNote() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (!title.isEmpty() && !content.isEmpty()) {

            Note newNote = new Note(title, content);

            notebook.addNote(newNote);

            noteListView.getItems().add(newNote);

            titleField.clear();
            contentArea.clear();

            System.out.println("Muistiinpano lisätty: " + title);



        }
    }
    @FXML
    public void initialize() {
        noteListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                titleField.setText(newValue.getTitle());
                contentArea.setText(newValue.getContent());
            }
        });
    }

    @FXML
    private void handleDeleteNote() {
        Note selectedNote = noteListView.getSelectionModel().getSelectedItem();
        if (selectedNote != null) {
            notebook.getNotes().remove(selectedNote);
            noteListView.getItems().remove(selectedNote);
            System.out.println("Muistiinpano poistettu:  " + selectedNote.getTitle());
        }
    }

    @FXML
    private void handleUpdateNote() {
        Note selectedNote = noteListView.getSelectionModel().getSelectedItem();
        if (selectedNote != null) {
            selectedNote.setTitle(titleField.getText());
            selectedNote.setContent(contentArea.getText());

            noteListView.refresh();
            System.out.println("Muistiinpano päivitetty: " + selectedNote.getTitle());
        }
    }
}
