package stackQueue;

import java.util.ArrayList;
import java.util.Stack;

public class Pro_크레인인형뽑기게임 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/64061
	 * Level 1
	 * 게임화면의 격자 상태가 담긴 2차원 배열 : board
	 * 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 : moves
	 * 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수 return
	 * 1:59 - 1: 52
	 * */

	static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for(int i = 0; i < moves.length; i++) {
        	for(int j = 0; j < board.length; j++) {
        		int index = board[j][moves[i]-1];
        		if(index != 0) {
        			if(basket.empty()) basket.push(index);
        			else {
        				if(basket.peek() == index) {
        					basket.pop();
        					answer += 2;
        				}else basket.push(index);
        			}
        			board[j][moves[i]-1] = 0;
        			break;
        		}
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));

	}

}
