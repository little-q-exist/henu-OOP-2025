package src.Fish;

import src.IMAGE;
import src.ResourcesManager;

public class Emeny_m extends Emeny {

    public Emeny_m() {
        super();
        setSPEED(0.6f);
        setScore(8);
        setWIDTH(124);
        setInvincible(false);
        setHEIGHT(75);
    }

    private IMAGE Emeny_mImage;

    @Override
    public IMAGE onDraw() {
        Emeny_mImage = ResourcesManager.getInstance().getImage((isFacing_right() ? "Emeny_mRight" : "Emeny_mLeft"));
        Emeny_mImage.setProperties(getPosition().x, getPosition().y, getWIDTH(), getHEIGHT());
        if (Emeny_mImage == null) {
            System.out.println("image null");
        }
        return Emeny_mImage;
    }

}
