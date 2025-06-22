package Fish;

import main.IMAGE;
import main.ResourcesManager;

public class Emeny_boss extends Emeny {

    public Emeny_boss() {
        super();
        setSPEED(0.25f);
        setScore(20);
        setWIDTH(560);
        setHEIGHT(530);
        setInvincible(true);
    }

    private IMAGE Emeny_bossImage;

    @Override
    public IMAGE onDraw() {
        Emeny_bossImage = ResourcesManager.getInstance()
                .getImage((isFacing_right() ? "Emeny_bossRight" : "Emeny_bossLeft"));
        Emeny_bossImage.setProperties(getPosition().x, getPosition().y, getWIDTH(), getHEIGHT());
        if (Emeny_bossImage == null) {
            System.out.println("image null");
        }
        return Emeny_bossImage;
    }

}
