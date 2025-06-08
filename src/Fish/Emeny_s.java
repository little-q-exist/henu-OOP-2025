package src.Fish;

public class Emeny_s extends Emeny {

    Emeny_s(int WINDOW_width, int WINDOW_height) {
        super(WINDOW_width, WINDOW_height);
        setSPEED(0.15f);
        setScore(1);
        setWIDTH(45);
        setHEIGHT(70);
        setInvincible(false);

    }

    @Override
    void onDraw() {
    }

}
