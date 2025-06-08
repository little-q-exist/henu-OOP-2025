package src.Fish;

public class Emeny_m extends Emeny {

    Emeny_m(int WINDOW_width, int WINDOW_height) {
        super(WINDOW_width, WINDOW_height);
        setSPEED(15);
        setScore(8);
        setWIDTH(180);
        setInvincible(false);
        setHEIGHT(80);
    }

    @Override
    void onDraw() {

    }

}
