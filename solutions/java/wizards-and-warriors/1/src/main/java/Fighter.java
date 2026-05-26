class Fighter {

    int damagePoint;

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter {
    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    boolean isVulnerable() {
        return false;
    }

    @Override
    int getDamagePoints(Fighter f) {
        return f.isVulnerable() ? 10 : 6;
    }
}

class Wizard extends Fighter {
    private boolean preparedSpell = false;

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    void prepareSpell() {
        preparedSpell = true;
    }

    @Override
    boolean isVulnerable() {
        return !preparedSpell;
    }

    @Override
    int getDamagePoints(Fighter f) {
        return preparedSpell ? 12 : 3;
    }
}
