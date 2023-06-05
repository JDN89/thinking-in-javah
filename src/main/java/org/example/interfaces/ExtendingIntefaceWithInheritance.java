package org.example.interfaces;


interface Monster {
    void menace();
}
interface DangerousMonster extends Monster {
    void destroy();
}
//this is how I would write the code, example book is confusing??
//interface DangerousMonster  {
//    void destroy();
//}
//class DragonZilla implements DangerousMonster,Monster {
//    public void menace() {}
//    public void destroy() {}
//}
class DragonZilla implements DangerousMonster {
    public void menace() {}
    public void destroy() {}
}
interface Lethal {
    void kill();
}
interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}
class VeryBadVampire implements Vampire {
    public void menace() {}
    public void destroy() {}
    public void kill() {}
    public void drinkBlood() {}
}

public class ExtendingIntefaceWithInheritance {
    static void u(Monster b) { b.menace(); }
    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }
    static void w(Lethal l) { l.kill(); }
    public static void main(String[] args) {
        //this is how I would write the code, example book is confusing??
//        DragonZilla barney = new DragonZilla();
//        u(barney);
//        v(barney);

class DragonZilla implements DangerousMonster,Monster {
    public void menace() {}
    public void destroy() {}
}
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}