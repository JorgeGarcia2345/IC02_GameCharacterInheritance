public class Main
{
    public static void main(String[] args)
    {
        GameCharacter jorge = new GameCharacter("Jorge the NPC", 6);
        Hero jerrySeinfeld = new Hero("Jerry Seinfeld", 17);
        Villain newman = new Villain("Newman", 2);
        Villain kramer = new Villain("Kramer", 3);
        GameCharacter test = new Hero("test", 2);

        System.out.println("\n~~~Game Character Created~~~\n");
        System.out.println(jorge);
        System.out.println(jerrySeinfeld);
        System.out.println(newman);
        System.out.println(kramer);

        // NPC jorge tries to assist/attack
        jorge.assist(jerrySeinfeld);
        jorge.attack(newman);
        System.out.println(jorge);
        System.out.println(jerrySeinfeld);
        System.out.println(newman);
        System.out.println(kramer);

        // kramer assists newman
        kramer.assist(newman);
        System.out.println(jorge);
        System.out.println(jerrySeinfeld);
        System.out.println(newman);
        System.out.println(kramer);

        // jerrySeinfeld attacks newman
        jerrySeinfeld.attack(newman);
        System.out.println(jorge);
        System.out.println(jerrySeinfeld);
        System.out.println(newman);
        System.out.println(kramer);

        // newman attacks jerrySeinfeld
        newman.attack(jerrySeinfeld);
        System.out.println(jorge);
        System.out.println(jerrySeinfeld);
        System.out.println(newman);
        System.out.println(kramer);

        //jerrySeinfeld attacks newman
        jerrySeinfeld.attack(newman);
        System.out.println(jorge);
        System.out.println(jerrySeinfeld);
        System.out.println(newman);
        System.out.println(kramer);

        //jerrySeinfeld attacks newman
        jerrySeinfeld.attack(newman);
        System.out.println(jorge);
        System.out.println(jerrySeinfeld);
        System.out.println(newman);
        System.out.println(kramer);

        // newman attacks jerrySeinfeld
        newman.attack(jerrySeinfeld);
        System.out.println(jorge);
        System.out.println(jerrySeinfeld);
        System.out.println(newman);
        System.out.println(kramer);

        // NPC jorge & jerrySeinfeld rest
        jorge.rest();
        jerrySeinfeld.rest();
        System.out.println(jorge);
        System.out.println(jerrySeinfeld);
        System.out.println(newman);
        System.out.println(kramer);

    }
}
