package src.Fish;

public class Ememy_l extends Emeny {

    Ememy_l(int WINDOW_width, int WINDOW_height) {
        super(WINDOW_width, WINDOW_height);
        setSPEED(0.04f);
        setScore(15);
        setWIDTH(250);
        setHEIGHT(150);
        setInvincible(false);
    }

    @Override
    void onDraw() {

    }
}
