package KuuspisteKolme;


import javafx.animation.AnimationTimer;

public class PetController {

    private Pet pet;
    private PetApp view;
    private double targetX, targetY;
    private boolean moving;
    private final double speed = 2.0;


    public PetController(Pet pet, PetApp view) {
        this.pet = pet;
        this.view = view;
        this.targetX = pet.getX();
        this.targetY = pet.getY();
    }


    public void setTarget(double x, double y) {
        this.targetX = x;
        this.targetY = y;
        this.moving = true;
    }

    public void stopMoving() {
        this.moving = false;
    }


    public void startAnimation() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (moving) {
                    updateMovement();
                    view.draw();
                }
            }
        }.start();
    }

    private void updateMovement() {
        double dx = targetX - (pet.getX() + 50);
        double dy = targetY - (pet.getY() + 50);
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < 5) {
            moving = false;
            return;
        }

        pet.setX(pet.getX() + (dx / distance) * speed);
        pet.setY(pet.getY() + (dy / distance) * speed);
    }

}
