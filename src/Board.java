import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.Constants.*;

public class Board extends JPanel implements ActionListener, KeyListener {

    private final Player player;
    private final List<Sprite> sprites;
    private final Set<Integer> activeKeyCodes;

    public Board() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.GRAY);

        player = new Player();
        Wall wall = new Wall(BOARD_WIDTH / 2 - WALL_WIDTH / 2,
                BOARD_HEIGHT / 2 - WALL_WIDTH / 2);
        sprites = new ArrayList<>(List.of(player, wall));

        activeKeyCodes = new HashSet<>();

        new Timer(TICK_DELAY, this).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.handleActiveKeys(activeKeyCodes);

        for(Sprite sprite : sprites) {
            sprite.tick();
        }

        for(Sprite sprite : sprites) {
            if(player.isColliding(sprite)) {
                player.handleCollision(sprite);
            }
        }

        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        for(Sprite sprite : sprites) {
            sprite.draw(graphics, this);
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        // Unused
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        activeKeyCodes.add(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        activeKeyCodes.remove(keyEvent.getKeyCode());
    }
}
