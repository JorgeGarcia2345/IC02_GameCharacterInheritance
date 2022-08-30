public class Villain extends GameCharacter
{
    public Villain(String name, int level)
    {
        super(name, level);
    }

    public Villain(String name)
    {
        super(name);
    }

    @Override
    public void attack(GameCharacter other)
    {
        // Generate a roll between 0 and 9
        int roll = rng.nextInt(10);
        // Calculate damage by multiplying the random number by "this" character's
        // level.
        // double damage compared to Hero class
        int damage = mLevel * roll * 2;
        // Deduct the damage from the other character's health points. However, do not
        // allow health points to go below zero.

        // this = "me, attacker"
        // other = "other character being attacked"

        other.mHealthPoints -= damage;
/*
        // Do not allow HPs to go below 0
        if (other.mHealthPoints < 0)
            other.mHealthPoints = 0;
*/
        if (mHealthPoints == 0)
        {
            System.out.println("\n~~~Whoops! " + mName + " can't attack, " + mName + ": Health Points = 0!~~~");
        }

        else
        {

            System.out.println("\n~~~" + this.mName + " attacked " + other.mName + "!~~~");
            System.out.println("Attack roll: " + roll + "!");

            if (other.getHealthPoints() == 0)
            {
                System.out.println("\n**Whoops! " + other.mName + " has already been defeated!**\n");
            }

            else if (damage >= other.getHealthPoints())
            {
                other.mHealthPoints = 0;
                if (other.mHealthPoints <= 0)
                {
                    other.mHealthPoints = 0;
                    // Take the other characters gold
                    mGold += other.mGold;
                    System.out.println("\n**" + mName + " has taken " + other.mName + "'s " + other.mGold + " gold!**\n");
                    other.mGold = 0;
                    other.perish();
                }
            }

            else
            {
                other.mHealthPoints -= damage;
            }
        }
    }

    @Override
    public void assist(GameCharacter other)
    {
        int roll = rng.nextInt(5);
        System.out.println("\n~~~" + this.mName + " assisted " + other.mName + "!~~~");
        System.out.println("Assist Roll: " + roll + "!");

        int assistMultiplier = 10;
        switch (roll)
        {
            case 0:
                other.mHealthPoints += mLevel * assistMultiplier;
                mHealthPoints -= mLevel * assistMultiplier;
                break;
            case 1:
                other.mMagic += mLevel * assistMultiplier;
                mMagic -= mLevel * assistMultiplier;
                break;
            case 2:
                other.mGold += mLevel * assistMultiplier;
                mGold -= mLevel * assistMultiplier;
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
        System.out.println("Villains never rest! Are you kidding me? We have too many nefarious things to do!\n");
    }

    @Override
    public void perish()
    {
        System.out.println("Humanity has been restored!  The villain has perished.");
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
        return "Villain{" +
                "Name=" + mName +
                ", Level=" + mLevel +
                ", HealthPoints=" + mHealthPoints +
                ", Gold=" + mGold +
                ", Magic=" + mMagic +
                '}';
    }
}
