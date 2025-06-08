package src.Fish;

public class Ememy_boss extends Emeny {

    Ememy_boss(int WINDOW_width, int WINDOW_height) {
        super(WINDOW_width, WINDOW_height);
        setSPEED(8);
        setScore(20);
        setInvincible(true);
    }

    @Override
    void onDraw() {

    }

}
