package Fish;

public class Emeny_s extends Emeny {

    Emeny_s(int WINDOW_width, int WINDOW_height) {
        super(WINDOW_width, WINDOW_height);
        setSPEED(25);
        setScore(1);
        setWIDTH(45);
        setHEIGHT(70);
    }

    @Override
    void onDraw() {
    }

}
