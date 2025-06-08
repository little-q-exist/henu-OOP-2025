package src.Fish;

public class Emeny_m extends Emeny {

    Emeny_m(int WINDOW_width, int WINDOW_height) {
        super(WINDOW_width, WINDOW_height);
        setSPEED(0.1f);
        setScore(8);
        setWIDTH(180);
        setInvincible(false);
        setHEIGHT(80);
    }

    @Override
    void onDraw() {

    }

}
