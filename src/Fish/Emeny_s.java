package src.Fish;

import src.IMAGE;
import src.ResourcesManager;

public class Emeny_s extends Emeny {

    public Emeny_s() {
        super();
        setSPEED(1.5f);
        setScore(1);
        setWIDTH(45);
        setHEIGHT(70);
        setInvincible(false);

    }

    private IMAGE Emeny_sImage;

    @Override
    public IMAGE onDraw() {
        Emeny_sImage = ResourcesManager.getInstance().getImage((isFacing_right() ? "Emeny_sRight" : "Emeny_sLeft"));
        Emeny_sImage.setProperties(getPosition().x, getPosition().y, getWIDTH(), getHEIGHT());
        if (Emeny_sImage == null) {
            System.out.println("image null");
        }
        return Emeny_sImage;
    }

}
