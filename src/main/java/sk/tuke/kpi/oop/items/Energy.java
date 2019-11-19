package sk.tuke.kpi.oop.items;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Ripley;

public class Energy extends AbstractActor implements Usable<Ripley> {
    public Energy(){
        Animation animation = new Animation(
            "sprites/energy.png",
            32,
            32);

        setAnimation(animation);
    }
    @Override
    public void useWith(@NotNull Ripley ripley) {
        if(ripley.getEnergy() < 100) {
            Scene scene = getScene();
            assert scene != null;
            scene.removeActor(this);
            ripley.setEnergy(100);
        }
    }
}