
/******************
 * 기사는 탱커의 역할 수행
 * 추후 2차 전직에서 성기사와 마검사로 전직
 * 성기사는 힐러, 마검사는 마법사 역할을 추가로 부여받음
 ******************/
public class KnightGame {
    public static void main(String[] args) {

        // 기사 객체 생성
        Knight uther = new HolyKnight("우서", 200, 10);
        Knight arthas = new MagicKnight("아서스", 150, 8);

        // 우서 기사 버프 실행
        uther.increaseHP();
        uther.increaseAmor();

        // 2차 전직 : 우서 성기사 버프 실행
        HolyKnight holyUther = (HolyKnight) uther;  // Knight타입은 성기사 부분은 구현되어 있지 않아서 기사 역할만 수행 가능
        holyUther.hollyAmor();                      // 타입 캐스팅을 하면 인터페이스를 구현한 부분까지 모두 사용 가능
        holyUther.healingAura();

        // 아서스 기사 버프 실행
        arthas.increaseHP();
        arthas.increaseAmor();

        // 2차 전직 : 아서스 마검사 버프 실행
        MagicKnight magicArthas = (MagicKnight) arthas;
        magicArthas.fireAmor();
        magicArthas.thunderBlade();

    }
}

interface Tanker {
    public void increaseAmor(); // 아머 +5

    public void increaseHP(); // 체력 +100
}

interface Healer {
    public void healingAura(); // 초당 체력회복 +10

    public void hollyAmor(); // 데미지 감소 -10
}

interface Sorcerer {
    public void fireAmor(); // 주변의 적 초당 데미지 +10

    public void thunderBlade(); // 공격시 추가 데미지 +10
}

class Knight implements Tanker {

    protected String name;
    protected int HP;
    protected int amor;

    Knight(String name, int HP, int amor) {
        this.name = name;
        this.HP = HP;
        this.amor = amor;
    }

    @Override
    public void increaseAmor() {
        amor += 10;
        System.out.println( "[" + name +"] increaseAmor() : " + "아머가  +5 증가합니다.");
    }

    @Override
    public void increaseHP() {
        HP += 100;
        System.out.println( "[" + name +"] increaseHP() : " + "체력이 +100 증가합니다.");
    }
}

class HolyKnight extends Knight implements Healer {

    HolyKnight(String name, int HP, int amor) {
        super(name, HP, amor);
    }

    @Override
    public void healingAura() {
        HP += 10;
        System.out.println( "[" + name +"] healingAura() : " + "초당 체력회복이 +10 증가합니다.");
    }

    @Override
    public void hollyAmor() {
        System.out.println( "[" + name +"] hollyAmor() : " + "데미지를 -10 덜 받습니다.");
    }
}

class MagicKnight extends Knight implements Sorcerer {

    MagicKnight(String name, int HP, int amor) {
        super(name, HP, amor);
    }

    @Override
    public void fireAmor() {
        System.out.println( "[" + name +"] fireAmor() : " + "주변 적에게 초당 +10 데미지를 줍니다.");
    }

    @Override
    public void thunderBlade() {
        System.out.println( "[" + name +"] thunderBlade() : " + "매 공격 시 +10의 추가 데미지를 줍니다..");
    }
}
