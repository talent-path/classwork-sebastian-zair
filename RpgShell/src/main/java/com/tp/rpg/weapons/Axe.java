package com.tp.rpg.weapons;

public class Axe implements Weapon {

    int damage = 45;
    int attackSpeed = 25;

    public Axe(int damage) {
        this.damage = damage;
    }

    @Override
    public int generateDamage(int damage) {
        return this.damage = damage;
        //throw new UnsupportedOperationException();
    }



    @Override
    public boolean useWeapon() {
        return false;
    }
}
