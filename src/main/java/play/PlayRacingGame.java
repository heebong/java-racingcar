package play;

import java.util.Scanner;

import domain.Car;

public class PlayRacingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. ����ڷκ��� car �̸� �ޱ�
		String carNames[] = receiveCarNamesFromUser();
		// 2. car ��ü ����
		Car racingCars[] = initCarObjs(carNames);
		for(Car c : racingCars) {
			System.out.println("car : " + c.getName());
		}
		// 3. ���� ����

	}
	
	private static String[] receiveCarNamesFromUser() {
		Scanner sc = new Scanner(System.in);
		String inputNames = sc.next();
		sc.close();
		
		return inputNames.split(",");
	}
	
	private static Car[] initCarObjs(String[] carNames) {
		Car racingCars[] = new Car[carNames.length];
		for(int i = 0 ; i < racingCars.length ; i++) {
			racingCars[i] = new Car(carNames[i]);
		}
		
		return racingCars;
	}

}
