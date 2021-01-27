package com.tp.rpg.weapons;

public class Sword implements Weapon {

    int damage = 30;
    int attackSpeed = 30;


    public Sword(int damage) {
        this.damage = damage;
    }
    @Override
    public int generateDamage(int damage) {

        this.damage = damage;
        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean useWeapon() {
        return false;
    }


}
