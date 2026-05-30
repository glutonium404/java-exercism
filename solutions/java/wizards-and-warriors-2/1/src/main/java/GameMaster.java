public class GameMaster {

    public String describe(Character c) {
        return "You're a level " + c.getLevel() + " " + c.getCharacterClass() + " with " + c.getHitPoints() + " hit points.";
    }

    public String describe(Destination d) {
        return "You've arrived at " + d.getName() + ", which has " + d.getInhabitants() + " inhabitants.";
    }

    public String describe(TravelMethod tv) {
        if (tv == TravelMethod.WALKING)
            return "You're traveling to your destination by walking.";

        return "You're traveling to your destination on horseback.";
    }

    public String describe(Character c, Destination d, TravelMethod tv) {
        return describe(c) + " " + describe(tv) + " " + describe(d);
    }

    public String describe(Character c, Destination d) {
        return describe(c) + " " + describe(TravelMethod.WALKING) + " " + describe(d);
    }
}
