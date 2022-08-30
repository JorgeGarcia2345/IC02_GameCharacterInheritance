public class Hero extends GameCharacter
{
    public Hero(String name, int level) {
        super(name, level);
    }

    public Hero(String name) {
        super(name);
    }


    @Override
    public void attack(GameCharacter other)
    {
        // Generate a roll between 0 and 9
        int roll = rng.nextInt(10);
        // Calculate damage by multiplying the random number by "this" character's
        // level.
        int damage = mLevel * roll;

        // Deduct the damage from the other character's health points. However, do not
        // allow health points to go below zero.
        // this = "me, attacker"
        // other = "other character being attacked"
        System.out.println("\n~~~" + this.mName + " attacked " + other.mName + "!~~~");
        System.out.println("Attack roll: " + roll + "!");

        // other character already defeated message
        if (other.getHealthPoints() == 0)
        {
            System.out.println("**Whoops! " + other.mName + " has already been defeated!**");
        }

        // sets other healthPoints = 0
        // displays other.perish() message
        // takes other gold
        else if(damage >= other.getHealthPoints())
        {
            other.mHealthPoints = 0;
            // Take the other characters gold
            mGold += other.mGold;
            other.perish();
            System.out.println("**" + mName + " has taken " + other.mName + "'s " + other.mGold + " gold as victory!**");
            other.mGold = 0;
        }

        // processes damage, other still has healthPoints
        else
        {
            other.mHealthPoints-= damage;
        }
    }

    @Override
    public void assist(GameCharacter other)
    {

        int roll = rng.nextInt(5);
        System.out.println("\n~~~" + this.mName + " assisted " + other.mName + "!~~~");
        System.out.println("Assist Roll: " + roll + "!");

        switch (roll)
        {
            case 0:
                other.mHealthPoints += mLevel * 5;
                mHealthPoints -= mLevel * 5;
                break;
            case 1:
                other.mMagic += mLevel * 5;
                mMagic -= mLevel * 5;
                break;
            case 2:
                other.mGold += mLevel * 5;
                mGold -= mLevel * 5;
                break;
            case 3:
                other.mLevel++;
                other.mGold += 100;
                other.mMagic += 100;
                other.mHealthPoints += 100;

                mLevel--;
                mGold -= 100;
                mMagic -= 100;
                mHealthPoints -= 100;
                break;
            case 4:
                mHealthPoints = mLevel * 100;
                other.mHealthPoints = other.mLevel * 100;
                break;
        }
    }


    @Override
    public void rest()
    {
        int roll = rng.nextInt(5);
        mHealthPoints += roll * mLevel;
        System.out.println(mName + " is resting now, but please let us know of any danger!");
    }


    @Override
    public void perish()
    {
        System.out.println("All is lost, our hero has perished :(\n");
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Hero{" +
                "Name=" + mName +
                ", Level=" + mLevel +
                ", HealthPoints=" + mHealthPoints +
                ", Gold=" + mGold +
                ", Magic=" + mMagic +
                '}';
    }
}
