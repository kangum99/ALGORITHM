package bfsdfs;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 * level 2
 * 사용할 수 있는 숫자 배열 : numbers
 * 타겟넘버 : target
 * 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return*/

public class Pro_타겟넘버 {
    static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    static int dfs(int[] numbers, int target, int index, int num) {
//    	재귀를 나갈 조건
    	if(index == numbers.length)
    		return num == target ? 1 : 0;
    	else
//    		+연산과 -연산을 해주고 갖은 return값을 더한다
    		return dfs(numbers, target, index + 1, num + numbers[index])
    				+ dfs(numbers, target, index + 1, num - numbers[index]);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}

}
