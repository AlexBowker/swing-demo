import static utils.Constants.*;

public class Wall extends Sprite {
    public Wall(int x, int y) {
        super(WALL_IMAGE_PATH, x, y, WALL_WIDTH, WALL_HEIGHT);
    }

    @Override
    public void tick() {
        // Unused
    }
}
