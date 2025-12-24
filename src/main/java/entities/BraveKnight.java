package entities;

public class BraveKnight implements Fighter {
    private String name;
    private Weapon weapon;

    @Override
    public void fight() {
    }

    protected void eat() {

    }

    private static class Weapon {
        private String name;
    }
}
