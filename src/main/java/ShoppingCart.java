import java.util.ArrayList;

/******************
 * 쇼핑카트
 * 쇼핑카트에 전자제품 담기
 * Goods라는 추상클래스에서 상속해서 객체 만들기
 ******************/
public class ShoppingCart {
    public static void main(String[] args) {

        // 객체 생성
        Goods monitor = new Monitor("삼성 와이드 모니터", 450000);
        Goods tv = new TV("삼성 벽걸이 TV", 230000);
        Goods computer = new Computer("노트북 고급형", 1600000);

        // 장바구니에 담기
        ArrayList<Goods> cart = new ArrayList<Goods>();
        cart.add(monitor);
        cart.add(tv);
        cart.add(computer);

        // 장바구니 내역 출력하기
        for (Goods good: cart){
            System.out.println(good.toString());
        }
    }
}

// Goods 추상 클래스
abstract class Goods{
    protected String name;
    protected double price;

    Goods(String name, double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("cart 내용 : %s %.2f", name, price);
    }
}

class Monitor extends Goods{

    Monitor(String name, double price) {
        super(name, price);
    }
}

class TV extends Goods{

    TV(String name, double price) {
        super(name, price);
    }
}

class Computer extends Goods{

    Computer(String name, double price) {
        super(name, price);
    }
}

