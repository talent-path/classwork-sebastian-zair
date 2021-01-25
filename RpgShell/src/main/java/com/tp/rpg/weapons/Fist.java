package com.tp.rpg.weapons;

public class Fist implements Weapon {

    int damage = 10;
    int attackSpeed = 50;

   public Fist(int damage) {
        this.damage = damage;
    }

    @Override
    public int generateDamage() {

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean useWeapon() {
        return false;
    }
}
