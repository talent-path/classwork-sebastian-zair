package com.tp.rpg;

import com.tp.rpg.armors.Armor;
import com.tp.rpg.armors.BronzeArmor;
import com.tp.rpg.armors.GoldArmor;
import com.tp.rpg.armors.SilverArmor;
import com.tp.rpg.weapons.Axe;
import com.tp.rpg.weapons.Fist;
import com.tp.rpg.weapons.Sword;
import com.tp.rpg.weapons.Weapon;

public class Application {
    public static void main(String[] args) {
// WEAPONS------------------------------------------------------------------------------------
        Weapon sword = new Sword(30);
        Weapon axe = new Axe(40);
        Weapon fist = new Fist(5);
        PlayerCharacter pc = setUpPlayer();
// ARMOR......................................................................................
        Armor bronze = new BronzeArmor();
        Armor silver = new SilverArmor();
        Armor gold = new GoldArmor();

// CHARACTERS**********************************************************************************
        PlayerCharacter pc1 = new PlayerCharacter();

        while( pc.isAlive() ){
            NonPlayerCharacter enemy = setUpEnemy();

            battle( pc, enemy );


        }

        gameOverScreen();

    }

    //walk the user through setting up their character
    private static PlayerCharacter setUpPlayer() {
        throw new UnsupportedOperationException();
    }

    //create some NPC object (with armor & weapons?)
    private static NonPlayerCharacter setUpEnemy() {
        throw new UnsupportedOperationException();
    }

    //a and b battle until one is dead
    private static void battle(Character a, Character b) {
        Character attacker = a;
        Character defender = b;

        while( a.isAlive() && b.isAlive() ){
            if( a.makeChoice().equals("Attack")) {
                attacker.attack(defender);
            } else {
                //TODO: consider other actions
                throw new UnsupportedOperationException();
            }

            Character temp = a;
            a = b;
            b = temp;

            //TODO: display HP status?
        }
    }

    //display some message
    private static void gameOverScreen() {
    }
}
