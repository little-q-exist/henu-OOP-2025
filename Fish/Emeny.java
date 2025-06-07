package Fish;

import java.awt.event.KeyEvent;

public abstract class Emeny {
    abstract void onDraw();

    abstract void onUpdate();

    abstract void onInput(KeyEvent e);
}
