package KuuspisteKolme;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;



public class PetApp extends Application {

    private Pet pet;
    private Canvas canvas;
    private GraphicsContext gc;
    private PetController controller;
    private javafx.scene.image.Image petImage;


    @Override
    public void start(Stage primaryStage) {
        pet = new Pet(100, 100);
        canvas = new Canvas(500, 500);
        gc = canvas.getGraphicsContext2D();


        try {
            petImage = new Image(getClass().getResourceAsStream("/KuuspisteKolme/munkissa.png"));
            if (petImage.isError()) System.out.println("Virhe kuvan latauksessa.");
        } catch (Exception e) {
            System.out.println("Kuvaa ei löytynyt.");
        }

        controller = new PetController(pet, this);

        canvas.setOnMouseMoved(event -> {
            controller.setTarget(event.getX(), event.getY());
        });

        canvas.setOnMouseExited(event -> {
            controller.stopMoving();
        });

        draw();

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("Virtuaalinen lemmikki");
        primaryStage.setScene(scene);
        primaryStage.show();

        controller.startAnimation();
    }

    public void draw() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if (petImage != null)  {
            gc.drawImage(petImage, pet.getX(), pet.getY(), 100, 100);
        } else {
            gc.setFill(Color.CHARTREUSE);
            gc.fillOval(pet.getX(), pet.getY(), 50, 50);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
