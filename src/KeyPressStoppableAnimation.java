import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * Created by Sahar on 19/06/2016.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;

    /**
     *
     * @param sensor the keyboard sensor
     * @param key the key used to stop animation
     * @param animation the game animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.sensor = sensor;
        this.isAlreadyPressed = true;

    }

    /**
     * @param d in order to draw any surface we get
     * @param dt num to make the program run per sec
     */
    public void doOneFrame(DrawSurface d, double dt) {
        if (!this.sensor.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        }
        this.animation.doOneFrame(d, dt);
    }

    /**
     * @return a boolean if the program should or shelden stop
     */
    public boolean shouldStop() {
        return this.sensor.isPressed(this.key) && !this.isAlreadyPressed;
    }
}