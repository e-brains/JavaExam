/******************
 * 높은 성적 찾기
 ******************/

import java.util.ArrayList;

public class HighScorePicked {

    public static void main(String[] args) {


        String[] nameArr = {"김씨", "박씨", "최씨", "이씨", "길씨", "감", "홍", "강씨", "유씨"};
        int[] scoreArr = {98, 91, 65, 82, 80, 73, 69, 32, 95};
        HighScorePicked highScorePicked = new HighScorePicked(nameArr, scoreArr);
        highScorePicked.topRank();

    }


    String[] nameList = new String[10];
    int[] scoreList = new int[10];

    HighScorePicked(String[] nameList, int[] scoreList) {
        this.nameList = nameList;
        this.scoreList = scoreList;
    }

    public void topRank() {

        int topIdx = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < scoreList.length; i++) {
            if (scoreList[topIdx] <= scoreList[i]) { // 현재 놈 보다 더 큰놈이 나타나면
                topIdx = i; // 새로운 큰놈으로 대체
                arrayList.add(topIdx);
            }
        }

        System.out.printf("1등 : ");

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf(" %s (%d)", nameList[arrayList.get(i)], scoreList[arrayList.get(i)]);
        }

    }


}
