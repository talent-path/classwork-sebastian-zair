package com.tp.rpg;

import com.tp.rpg.armors.Armor;
import com.tp.rpg.weapons.Weapon;

//TODO:
//      add a concept of hitpoints
//      add a concept of armor (or maybe multiple pieces of armor)
//      add a concept of a weapon (or maybe multiple weapons)
//Stretch goals:
//      add a potion class/interface that the character can drink instead of attacking
//      let the character "disarm" the opponent instead of attacking
//          base this on the weapons used?
//      let the character choose to "block" or "defend"
//          could stun the opponent if they attack?
//          could give us TWO attacks on the next round?
public abstract class Character implements Chooser {

    //state
    private String name;
    private int HP;
    private Weapon weapon;
    private Armor armor;

    //modified
    private int speed;
    private int attackDamage;

    // create
    public Character(String name, int HP, Weapon weapon, Armor armor){
        this.name = name;
        this.HP = HP;
        this.weapon = weapon;
        this.armor = armor;
    }
    //TODO: add fields for armor(s) and weapon(s)


    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void attack(Character defender ){

        defender.takeDamage(0);
        //throw new UnsupportedOperationException();
    }

    public void takeDamage( int damage ){

        damage = this.HP - this.weapon.generateDamage();



        //throw new UnsupportedOperationException();
    }

    public boolean isAlive(){
       return (this.HP > 0);

        //throw new UnsupportedOperationException();
    }
    public boolean isNotAlive() {
        return (this.HP < 0);
    }

}
