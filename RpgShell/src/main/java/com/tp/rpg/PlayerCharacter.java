package com.tp.rpg;

import com.tp.rpg.armors.Armor;
import com.tp.rpg.weapons.Weapon;

public class PlayerCharacter extends Character {
    //use scanner here to get something from the user

    public PlayerCharacter() {
        super("Marco", 1000, Weapon weapon, Armor);
    }

    @Override
    public String makeChoice() {
        throw new UnsupportedOperationException();
    }
}
