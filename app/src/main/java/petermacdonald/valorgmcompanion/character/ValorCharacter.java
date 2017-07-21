package petermacdonald.valorgmcompanion.character;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import petermacdonald.valorgmcompanion.character.enums.CharacterType;
import petermacdonald.valorgmcompanion.character.flaws.Flaw;
import petermacdonald.valorgmcompanion.character.skills.Skill;
import petermacdonald.valorgmcompanion.character.techniques.Technique;
import petermacdonald.valorgmcompanion.tools.ListTools;
import petermacdonald.valorgmcompanion.tools.ValorMath;

public class ValorCharacter {
    //User-inputted stats
    private String name;//ValorCharacter name
    private int level;//ValorCharacter level


    private CharacterType type;//ValorCharacter type
    private List<Flaw> flaws;
    private List<Skill> skills;//ValorCharacter skills
    private List<Technique> techniques;//ValorCharacter techniques
    private int strength, agility, spirit, mind, guts;//Base attributes

    //Derived stats
    private int season;//What season the character is currently in. Levels 1-5 = First Season, 6-10 = Second Season etc.
    private int muscle, dexterity, aura, intuition, resolve;//Active attributes
    private int health, stamina;//HP and ST totals
    private int skillPoints, techPoints, statPoints, ultTechPoints;//SP, TP, and attribute point totals
    private int maxTechLevel, maxAttribute, maxFlaws;//Maximum values for tech levels and attributes
    private int strengthAttack, agilityAttack, spiritAttack, mindAttack;//Attack values
    private int defense, resistance;//Defense values
    private int speed;//Move score
    private int initiative;//Initiative value;
    private int healthIncrement, staminaIncrement, criticalHealth, damageIncrement;//Intervals

    public ValorCharacter() {
        name = new String("");
        level = 1;
        type = CharacterType.ELITE;
        skills = new ArrayList<Skill>();
        flaws = new ArrayList<Flaw>();
        techniques = new ArrayList<Technique>();
        strength = 1;
        agility = 1;
        spirit = 1;
        mind = 1;
        guts = 1;
        calculateDerivedValues();
    }

    public ValorCharacter(String name){
        this.name = new String(name);
        level = 1;
        type = CharacterType.ELITE;
        skills = new ArrayList<Skill>();
        flaws = new ArrayList<Flaw>();
        techniques = new ArrayList<Technique>();
        strength = 1;
        agility = 1;
        spirit = 1;
        mind = 1;
        guts = 1;
        calculateDerivedValues();
    }

    public ValorCharacter(String name, CharacterType type) {
        this.name = new String(name);
        level = 1;
        season = calculateSeason();
        this.type = type;
        skills = new ArrayList<Skill>();
        flaws = new ArrayList<Flaw>();
        techniques = new ArrayList<Technique>();
        strength = 1;
        agility = 1;
        spirit = 1;
        mind = 1;
        guts = 1;
        calculateDerivedValues();
    }

    public ValorCharacter(String name, CharacterType type, int level) {
        this.name = new String(name);
        this.level = level;
        this.type = type;
        skills = new ArrayList<Skill>();
        flaws = new ArrayList<Flaw>();
        techniques = new ArrayList<Technique>();
        strength = 1;
        agility = 1;
        spirit = 1;
        mind = 1;
        guts = 1;
        calculateDerivedValues();
    }

    public ValorCharacter(CharacterType type, int level, int strength, int agility, int spirit, int mind, int guts) {
        this.name = "TEST";
        this.type = type;
        this.level = level;
        this.strength = strength;
        this.agility = agility;
        this.spirit = spirit;
        this.mind = mind;
        this.guts = guts;
        skills = new ArrayList<Skill>();
        flaws = new ArrayList<Flaw>();
        techniques = new ArrayList<Technique>();
        calculateDerivedValues();
    }

    public void addSkill(Skill skill) {
        ListTools.addToList(skill, skills);
        calculateDerivedValues();
    }

    public void addFlaw(Flaw flaw) {
        ListTools.addToList(flaw, flaws);
        calculateDerivedValues();
    }

    public void removeSkill(Skill skill) {
        ListTools.removeFromList(skill, skills);
        calculateDerivedValues();
    }

    public void removeFlaw(Flaw flaw) {
        ListTools.removeFromList(flaw, flaws);
        calculateDerivedValues();
    }

    public void addTech(Technique technique) {
        if (!techniques.contains(technique)){
            techniques.add(technique);
        }
    }

    /*
        This method uses the basic attributes and character level, and then calculates all values that can be derived from those numbers.
     */
    private void calculateDerivedValues(){
        season = calculateSeason();

        //First we calculate the active attributes
        muscle = calculateActiveAttribute(strength);
        dexterity = calculateActiveAttribute(agility);
        aura = calculateActiveAttribute(spirit);
        intuition = calculateActiveAttribute(mind);
        resolve = calculateActiveAttribute(guts);

        //Now HP and stamina pools
        health = calculateHealth();
        stamina = calculateStamina();

        //How many points can be gained from flaws, how many SP and TP you have in total, the maximum attributes and the maximum tech levels
        maxFlaws = level + 7;
        skillPoints = calculateSPTotal();
        techPoints = calculateTPTotal();
        ultTechPoints = calculateUltTPTotal();
        statPoints = 22 + (3*level);
        maxTechLevel = 3+level;
        maxAttribute = 7 + level;

        //Attack values
        strengthAttack = calculateAttack(strength);
        agilityAttack = calculateAttack(agility);
        spiritAttack = calculateAttack(spirit);
        mindAttack = calculateAttack(mind);

        //Defense values
        defense = calculateDefense(strength+guts);
        resistance = calculateDefense(spirit+mind);

        //Speed and initiative values
        speed = 3 + (agility-1)/4;
        initiative = dexterity;

        //The damage increment
        damageIncrement = calculateDamageIncrement();

        //Passive bonuses and penalties from skills/flaws are now applied
        applyPassiveSkills();
        applyPassiveFlaws();

        //Remaining increments are calculated
        healthIncrement = ValorMath.calculateIncrement(health);
        staminaIncrement = ValorMath.calculateIncrement(stamina);
        criticalHealth = healthIncrement *2;
    }

    /*
        Calculates which season the character is in
     */
    private int calculateSeason() {
        return 1 + (level-1)/5;
    }

    private void applyPassiveFlaws() {
        for (Flaw flaw:flaws) {
            flaw.applyPassiveEffect();
        }
    }

    private void applyPassiveSkills() {
        for (Skill skill:skills) {
            skill.applyPassiveEffect();
        }
    }

    /*
        Returns the damage increment appropriate for the character's level and type.
     */
    private int calculateDamageIncrement() {
        int temp = 5 + level;
        if(type == CharacterType.FLUNKY || type == CharacterType.SOLDIER) {
            temp = ValorMath.halfRoundUp(temp);
        }
        return temp;
    }

    /*
        Calculates a defense value. Pass in the total of the attributes keyed to the defense (STR+GUTS for Defense, SPR+MIN for Resistance), and it returns the value.
     */
    private int calculateDefense(int totalAttributes) {
        return (level * 2) + totalAttributes;
    }

    /*
        Calculates and attack value. Pass in the relevant basic attribute value, and it returns the attack value based ont eh attribute and the character level.
     */
    private int calculateAttack(int attribute) {
        int temp;
        switch(type) {
            case FLUNKY: temp = level + attribute;
                break;
            case SOLDIER: temp = level + attribute;
                break;
            case SWARM: temp = level + attribute;
                break;
            case ELITE: temp = (level + attribute)*2;
                break;
            case MASTER: temp = (2 * level) + (3*attribute);
                break;
            default: temp = (level + attribute)*2;
        }
        return temp;
    }

    /*
        Returns the character's total TP based on their type and level
     */
    private int calculateTPTotal() {
        int temp;
        int templevels = level;
        int perLevel=4;
        switch(type) {
            case ELITE: temp = 8;
                for (int i=0; i < season-1; i++) {
                    temp += 5*perLevel;
                    templevels -= 5;
                    perLevel++;
                }
                for (int i=0; i<templevels;i++) {
                    temp += perLevel;
                }
                break;
            case FLUNKY: temp = 2;
                for (int i=0; i < season-1; i++) {
                    int tempPerLevel = perLevel/4;
                    if (perLevel %4 >0) {
                        tempPerLevel += 1;
                    }
                    temp += 5*tempPerLevel;
                    templevels -= 5;
                    perLevel++;
                }
                for (int i=0; i<templevels;i++) {
                    int tempPerLevel = perLevel/4;
                    if (perLevel % 4 > 0) {
                        tempPerLevel+=1;
                    }
                    temp += tempPerLevel;
                }
                break;
            case SOLDIER: temp = 4;
                for (int i=0; i < season-1; i++) {
                    int tempPerLevel = perLevel/2;
                    if (perLevel %2 >0) {
                        tempPerLevel += 1;
                    }
                    temp += 5*tempPerLevel;
                    templevels -= 5;
                    perLevel++;
                }
                for (int i=0; i<templevels;i++) {
                    int tempPerLevel = perLevel/2;
                    if (perLevel % 2 > 0) {
                        tempPerLevel+=1;
                    }
                    temp += tempPerLevel;
                }
                break;
            case SWARM: temp = 4;
                for (int i=0; i < season-1; i++) {
                    int tempPerLevel = perLevel/2;
                    if (perLevel %2 >0) {
                        tempPerLevel += 1;
                    }
                    temp += 5*tempPerLevel;
                    templevels -= 5;
                    perLevel++;
                }
                for (int i=0; i<templevels;i++) {
                    int tempPerLevel = perLevel/2;
                    if (perLevel % 2 > 0) {
                        tempPerLevel+=1;
                    }
                    temp += tempPerLevel;
                }
                break;
            case MASTER: temp = 9;
                perLevel+= 1;
                for (int i=0; i < season-1; i++) {
                    temp += 5*perLevel;
                    templevels -= 5;
                    perLevel++;
                }
                for (int i=0; i<templevels;i++) {
                    temp += perLevel;
                }
                break;
            default: temp = 0;
        }
        return temp;
    }

    /*
        Returns the character's total SP based on their type and level
     */
    private int calculateSPTotal() {
        int temp;
        int perLevel;
        switch(type) {
            case FLUNKY: temp = 10;
                perLevel = 3;
                break;
            case SOLDIER: temp = 10;
                perLevel = 3;
                break;
            case SWARM: temp = 20;
                perLevel = 6;
                break;
            case ELITE: temp = 20;
                perLevel = 6;
                break;
            case MASTER: temp = 25;
                perLevel = 7;
                break;
            default: temp = 20;
                perLevel = 6;
                break;
        }
        temp += perLevel * (level-1);
        temp += calculateFlawsPoints();
        return temp;
    }

    /*
        Tallies and returns how many SP have been used.
     */

    public int getUsedSP() {
        int total = 0;

        for(Skill skill:skills) {
            total += skill.getCost();
        }
        return total;
    }


    /*
        Tallies and returns the number of points gained from Flaws. Used for calculating total SP.
     */
    private int calculateFlawsPoints() {
        int total = 0;
        for (Flaw flaw:flaws) {
            total+=flaw.getValue();
        }
        return Math.min(total, maxFlaws);
    }

    /*
        Calculates and returns the size of the character's stamina pool.
     */
    private int calculateStamina() {
        int temp = 8 + (4*level) + (2*spirit) + (2*mind);
        if (type == CharacterType.MASTER){
            return 2*temp;
        } else {
            return temp;
        }
    }

    /*
        Calculates and returns the size of the character's health pool
     */
    private int calculateHealth() {
        int temp = 50 + (10*level) + (5*strength) + (10 * guts);
        switch(type) {
            case FLUNKY: temp = 1;
                break;
            case SOLDIER: int totalStorage = temp;
                temp = temp/2;
                if (totalStorage % 2 > 0) {
                    temp+=1;
                }
                break;
            case SWARM: break;
            case ELITE: break;
            case MASTER: temp = 2*temp;
                break;
            default: break;
        }
        return temp;
    }

    /*
        Calculates and returns the active attribute based on the basic attribute passed into it, and the character's level.
     */
    private int calculateActiveAttribute(int basicAttribute) {
        int temp = basicAttribute + level;
        temp = ValorMath.halfRoundUp(temp);
        switch(type) {
            case FLUNKY: return temp-1;
            case SOLDIER: return temp-1;
            default: return temp;

        }
    }

    /*
        Calculated and returns the number of TP gained for use in ultimate abilities.
     */
    private int calculateUltTPTotal(){
        int amountToAdd = 8;
        int ultsEarned = level/5;
        int total = 0;

        if (type==CharacterType.SOLDIER || type==CharacterType.FLUNKY || type==CharacterType.SWARM) {//Soldiers, Flunkies, and Swarms don't get ults, so it just returns 0 for them
            return 0;
        }

        for(int i=0; i < ultsEarned; i++) {
            total+=amountToAdd;
            amountToAdd+=5;
        }

        return total;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public CharacterType getType() {
        return type;
    }

    public List<Flaw> getFlaws() {
        return flaws;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public List<Technique> getTechniques() {
        return techniques;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getSpirit() {
        return spirit;
    }

    public int getMind() {
        return mind;
    }

    public int getGuts() {
        return guts;
    }

    public int getSeason() {
        return season;
    }

    public int getMuscle() {
        return muscle;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getAura() {
        return aura;
    }

    public int getIntuition() {
        return intuition;
    }

    public int getResolve() {
        return resolve;
    }

    public int getHealth() {
        return health;
    }

    public int getStamina() {
        return stamina;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public int getTechPoints() {
        return techPoints;
    }

    public int getStatPoints() {
        return statPoints;
    }

    public int getMaxTechLevel() {
        return maxTechLevel;
    }

    public int getMaxAttribute() {
        return maxAttribute;
    }

    public int getMaxFlaws() {
        return maxFlaws;
    }

    /*
       These methods return half of an attack value, rounded as appropriate. Used for calculating damage on Damage Core techs with Special Modifiers
     */
    public int getHalfStrengthAttack() {
        return ValorMath.halfRoundUp(strengthAttack);
    }

    public int getHalfAgilityAttack() {
        return ValorMath.halfRoundUp(agilityAttack);
    }

    public int getHalfSpiritAttack() {
        return ValorMath.halfRoundUp(spiritAttack);
    }

    public int getHalfMindAttack() {
        return ValorMath.halfRoundUp(mindAttack);
    }

    public int getStrengthAttack() {
        return strengthAttack;
    }

    public int getAgilityAttack() {
        return agilityAttack;
    }

    public int getSpiritAttack() {
        return spiritAttack;
    }

    public int getMindAttack() {
        return mindAttack;
    }

    public int getDefense() {
        return defense;
    }

    public int getResistance() {
        return resistance;
    }

    public int getSpeed() {
        return speed;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getHealthIncrement() {
        return healthIncrement;
    }

    public int getStaminaIncrement() {
        return staminaIncrement;
    }

    public int getCriticalHealth() {
        return criticalHealth;
    }

    public int getDamageIncrement() {
        return damageIncrement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUltTechPoints() {
        return ultTechPoints;
    }

    /*
        The following Setters are for stats which affect how secondary stats are calculated, so they also calculate all derive values after setting.
     */

    public void setLevel(int level) {
        this.level = level;
        calculateDerivedValues();
    }

    public void setType(CharacterType type) {
        this.type = type;
        calculateDerivedValues();
    }

    public void setStrength(int strength) {
        this.strength = strength;
        calculateDerivedValues();
    }

    public void setAgility(int agility) {
        this.agility = agility;
        calculateDerivedValues();
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
        calculateDerivedValues();
    }

    public void setMind(int mind) {
        this.mind = mind;
        calculateDerivedValues();
    }

    public void setGuts(int guts) {
        this.guts = guts;
        calculateDerivedValues();
    }

    /*
        The following setters are only to be used by skills or flaws with passive effects. To prevent accidental misuse, the skill or flaw calling them passes themselves into it as a parameter.
        The skill or flaw object passed in must also be in the character's Skill or Flaw lists, or the setter will not function.
        This isn't foolproof, but it means that if I or another programmer want to muck up a character's stats without adding a skill, we'll need to do it deliberately.
        Some of them may also call calculateDerivedValues if they affect any other attributes.
     */

    public void setHealth(int health, Skill caller) {
        for (Skill skill:skills) {
            if (skill == caller) {
                this.health = health;
            }
        }
    }

    public void setHealth(int health, Flaw caller) {
        for (Flaw flaw:flaws) {
            if (flaw == caller) {
                this.health = health;
            }
        }
    }

    public void setStamina(int stamina, Skill caller) {
        for (Skill skill:skills) {
            if (skill == caller) {
                this.stamina = stamina;
            }
        }
    }

    public void setStamina(int stamina, Flaw caller) {
        for (Flaw flaw:flaws) {
            if (flaw == caller) {
                this.stamina = stamina;
            }
        }
    }

    public void setTechPoints(int techPoints, Skill caller) {
        for (Skill skill:skills) {
            if (skill == caller) {
                this.techPoints = techPoints;
            }
        }
    }

    public void setTechPoints(int techPoints, Flaw caller) {
        for (Flaw flaw:flaws) {
            if (flaw == caller) {
                this.techPoints = techPoints;
            }
        }
    }

    public void setUltTechPoints(int ultTechPoints, Skill caller) {
        for (Skill skill:skills) {
            if (skill == caller) {
                this.ultTechPoints = ultTechPoints;
            }
        }
    }

    public void setUltTechPoints(int ultTechPoints, Flaw caller) {
        for (Flaw flaw:flaws) {
            if (flaw == caller) {
                this.ultTechPoints = ultTechPoints;
            }
        }
    }

    public void setStrengthAttack(int strengthAttack, Skill caller) {
        for (Skill skill:skills) {
            if (skill == caller) {
                this.strengthAttack = strengthAttack;
            }
        }
    }

    public void setStrengthAttack(int strengthAttack, Flaw caller) {
        for (Flaw flaw:flaws) {
            if (flaw == caller) {
                this.strengthAttack = strengthAttack;
            }
        }
    }

    public void setAgilityAttack(int agilityAttack, Skill caller) {
        for (Skill skill:skills) {
            if (skill == caller) {
                this.agilityAttack = agilityAttack;
            }
        }
    }

    public void setAgilityAttack(int agilityAttack, Flaw caller) {
        for (Flaw flaw:flaws) {
            if (flaw == caller) {
                this.agilityAttack = agilityAttack;
            }
        }
    }

    public void setSpiritAttack(int spiritAttack, Skill caller) {
        for (Skill skill:skills) {
            if (skill == caller) {
                this.spiritAttack = spiritAttack;
            }
        }
    }

    public void setSpiritAttack(int spiritAttack, Flaw caller) {
        for (Flaw flaw:flaws) {
            if (flaw == caller) {
                this.spiritAttack = spiritAttack;
            }
        }
    }

    public void setMindAttack(int mindAttack, Skill caller) {
        for (Skill skill:skills) {
            if (skill == caller) {
                this.mindAttack = mindAttack;
            }
        }
    }

    public void setMindAttack(int mindAttack, Flaw caller) {
        for (Flaw flaw:flaws) {
            if (flaw == caller) {
                this.mindAttack = mindAttack;
            }
        }
    }

    public void setDefense(int defense, Skill caller) {
        for (Skill skill:skills) {
            if (skill == caller) {
                this.defense = defense;
            }
        }
    }

    public void setDefense(int defense, Flaw caller) {
        for (Flaw flaw:flaws) {
            if (flaw == caller) {
                this.defense = defense;
            }
        }
    }

    public void setResistance(int resistance, Skill caller) {
        for (Skill skill:skills) {
            if (skill == caller) {
                this.resistance = resistance;
            }
        }
    }

    public void setResistance(int resistance, Flaw caller) {
        for (Flaw flaw:flaws) {
            if (flaw == caller) {
                this.resistance = resistance;
            }
        }
    }

    public void setSpeed(int speed, Skill caller) {
        for (Skill skill:skills) {
            if (skill == caller) {
                this.speed = speed;
            }
        }
    }

    public void setSpeed(int speed, Flaw caller) {
        for (Flaw flaw:flaws) {
            if (flaw == caller) {
                this.speed = speed;
            }
        }
    }

    public void setInitiative(int initiative, Skill caller) {
        for (Skill skill:skills) {
            if (skill == caller) {
                this.initiative = initiative;
            }
        }
    }

    public void setInitiative(int initiative, Flaw caller) {
        for (Flaw flaw:flaws) {
            if (flaw == caller) {
                this.initiative = initiative;
            }
        }
    }

    public void setDamageIncrement(int damageIncrement, Skill caller) {
        for (Skill skill:skills) {
            if (skill == caller) {
                this.damageIncrement = damageIncrement;
            }
        }
    }

    public void setDamageIncrement(int damageIncrement, Flaw caller) {
        for (Flaw flaw:flaws) {
            if (flaw == caller) {
                this.damageIncrement = damageIncrement;
            }
        }
    }
}
