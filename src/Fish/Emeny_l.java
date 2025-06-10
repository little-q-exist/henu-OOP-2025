package src.Fish;

import src.IMAGE;
import src.ResourcesManager;

public class Emeny_l extends Emeny {

    public Emeny_l() {
        super();
        setSPEED(0.8f);
        setScore(15);
        setWIDTH(250);
        setHEIGHT(150);
        setInvincible(false);
    }

    private IMAGE Emeny_lImage;

    @Override
    public IMAGE onDraw() {
        Emeny_lImage = ResourcesManager.getInstance().getImage((isFacing_right() ? "Emeny_lRight" : "Emeny_lLeft"));
        Emeny_lImage.setProperties(getPosition().x, getPosition().y, getWIDTH(), getHEIGHT());
        if (Emeny_lImage == null) {
            System.out.println("image null");
        }
        return Emeny_lImage;
    }
}
