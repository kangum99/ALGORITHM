package bfsdfs;

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
