import java.util.ArrayList;

/******************
 * 각국 통화 출력하기
 * 부모클래스에서 상속받아 타입 그룹을 만들어서 사용하기
 *
 ******************/
public class Currency {
    public static void main(String[] args) {

        // 객체 생성
        KRW krw = new KRW(1500.0, "원");
        USD usd = new USD(100.50, "달러");
        EUR eur = new EUR(260.87, "유로");
        JPY jpy = new JPY(1400, "엔");

        // 부모 클래스를 통한 그룹화
        //CurrencyBase[] currencyBases = {krw, usd, eur, jpy};
        ArrayList<CurrencyBase> currencyBases = new ArrayList<CurrencyBase>();
        currencyBases.add(krw);
        currencyBases.add(usd);
        currencyBases.add(eur);
        currencyBases.add(jpy);

        // 모는 화페 출력
        for ( CurrencyBase cur : currencyBases ) {
            System.out.println(cur.toString());
        }

    }
}

// 부모 클래스
class CurrencyBase{
    protected double amount;
    protected String currencyUnit;

    public CurrencyBase(double amount, String currencyUnit){
        this.amount = amount;
        this.currencyUnit = currencyUnit;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f %s", this.getClass().getSimpleName(), amount, currencyUnit );
    }
}

class KRW extends CurrencyBase{

    KRW (double amount, String currencyUnit){
        super(amount, currencyUnit);
    }
}

class USD extends CurrencyBase{

    USD (double amount, String currencyUnit){
        super(amount, currencyUnit);
    }
}

class EUR extends CurrencyBase{

    EUR (double amount, String currencyUnit){
        super(amount, currencyUnit);
    }
}

class JPY extends CurrencyBase{

    JPY (double amount, String currencyUnit){
        super(amount, currencyUnit);
    }
}