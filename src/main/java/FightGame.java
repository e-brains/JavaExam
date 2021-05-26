/******************
 * 리얼 격투 게임
 * 두 영웅중 한쪽의 체력이 소진될때 까지, 서로를 향해 펀치를 날리는 격투게임
 * 영웅 속성 : 이름 , 체력
 * 영웅은 펀치를 통해 상대 영웅에게 피해를 준다.
 ******************/

public class FightGame {

    public static void main(String[] args) throws InterruptedException {
        Hero hero = new Hero("hero", 50);
        Hero enemy = new Hero("enemy", 50);

        Hero.battle(hero, enemy);

    }
}

class Hero {

    String name;
    int hp;
    int baseHp;

    static void battle(Hero hero, Hero enemy) throws InterruptedException {

        // 두사람이 체력이 남아 있다면 계속 싸움
        while (hero.hp > 0 && enemy.hp > 0) {

            Hero attacker, defender;

            // 1/2확률로 공격/수비 결정

            if (Math.random() < 0.5) {
                attacker = hero;
                defender = enemy;
            } else {
                attacker = enemy;
                defender = hero;
            }

            // 대상을 공격
            attacker.punch(defender);

            // 딜레이 0.2초
            Thread.sleep(1000);

        }
    }


    Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.baseHp = hp;
    }

    void punch(Hero defender) {

        defender.hp -= 10;
        System.out.printf("%s의 펀치 \n", this.name);
        System.out.printf("===> %s의 체력  %d/%d \n", defender.name, defender.hp, defender.baseHp);
    }

}


