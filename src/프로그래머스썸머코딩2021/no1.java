package 프로그래머스썸머코딩2021;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class no1 {
	public static int[] solution(String code, String day, String[] data) {
		TreeMap<Integer, String> map = new TreeMap<>();
		for(int i = 0; i < data.length; i++) {
            String[] temp = data[i].split(" ");
            String tempCode = temp[1].split("=")[1];
            if(code.equals(tempCode)) {
            	String tempDate = temp[2].split("=")[1].substring(0, 8);
            	if(day.equals(tempDate)) {
            		int tempTime = Integer.parseInt(temp[2].split("=")[1].substring(8, 10));
            		String tempPrice = temp[0].split("=")[1];
            		map.put(tempTime, tempPrice);
            	}

            }
        }
        int[] answer = new int[map.size()];
        Iterator<Entry<Integer, String>> entries = map.entrySet().iterator();
        int i = 0;
        while(entries.hasNext()){
            Entry<Integer, String> entry = entries.next();
            answer[i] = Integer.parseInt(entry.getValue());
            i++;
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String code = "012345";
		String day = "20190620";
		String[] data = {"price=80 code=987654 time=2019062113"
				,	"price=90 code=012345 time=2019062014"
				,	"price=120 code=987654 time=2019062010"
				,	"price=110 code=012345 time=2019062009"
				,	"price=95 code=012345 time=2019062111"};
		System.out.println(solution(code, day, data));
	}

}
