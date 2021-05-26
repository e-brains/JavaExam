import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/******************
 * 주사위 던지기
 * 1부터 N사이 임의의 정수를 반환하도록 주사위 클래스를 완성하고
 * 해당 주사위를 1000번 던진 값의 평균을 구하시오

 ******************/

public class ThrowDice {

    public static void main(String[] args) {

        // 화면에서 입력값 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // N면체 주사위 생성
        Die dice = new Die(N);
        //System.out.println(dice.roll());

        // 1000번 주사위를 던져 결과를 저장
        ArrayList<Integer> results = new ArrayList<Integer>();

        for (int i=0; i<1000; i++){
            int randNum = dice.roll();  // 주사위를 굴린다.
            results.add(randNum);
            System.out.println(randNum);
        }

        // 평균값 계산
        double avg = dice.avg(results);

        // 출력
        System.out.printf("평균 : %.1f", avg);

    }
}

class Die{

    private int maxNumber;

    Die(int n){
        this.maxNumber = n;
    }

    // 1~n면체 (maxNumber) 까지 반환
    public int roll(){
        Random random = new Random();
        return random.nextInt(maxNumber) + 1; // 0부터 이므로
    }

    public double avg(ArrayList<Integer> arrayList){
        double sum = 0;
        for (Integer i : arrayList ) { // foreach 형태
            sum += i;
        }

        System.out.printf("sum : %f  arrayList.size : %d \n",sum, arrayList.size());
        return sum / arrayList.size();
    }
}

