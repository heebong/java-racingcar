package play;

import java.util.Scanner;

public class PlayRacingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. ����ڷκ��� car �̸� �ޱ�
		String carNames[] = receiveCarNamesFromUser();
		// 2. car ��ü ����
		// 3. ���� ����

	}
	
	private static String[] receiveCarNamesFromUser() {
		Scanner sc = new Scanner(System.in);
		String inputNames = sc.next();
		sc.close();
		
		return inputNames.split(",");
	}

}
