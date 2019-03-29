package play;

import java.util.Scanner;

import domain.Car;

public class PlayRacingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String carNames[] = receiveCarNamesFromUser();
		Car racingCars[] = initCarObjs(carNames);
		int cntPlay = receivePlayCntFromUser();
		// 3. ���� ����
		playRacingGame(racingCars, cntPlay);

	}
	
	private static String[] receiveCarNamesFromUser() {
		System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����)");
		Scanner sc = new Scanner(System.in);
		String namesFromUser = sc.nextLine();
		
		return namesFromUser.split(",");
	}
	
	private static Car[] initCarObjs(String[] carNames) {
		Car racingCars[] = new Car[carNames.length];
		for(int i = 0 ; i < racingCars.length ; i++) {
			racingCars[i] = new Car(carNames[i]);
		}
		
		return racingCars;
	}
	
	private static int receivePlayCntFromUser() {
		System.out.println("�õ��� Ƚ���� ��ȸ�ΰ���?");
		Scanner sc = new Scanner(System.in);
		int playCntFromUser = sc.nextInt();
		sc.close();
		System.out.println();
		
		return playCntFromUser;
	}
	
	private static void playRacingGame(Car[] racingCars, int cntPlay) {
		System.out.println("���� ���");
		//01. ���̽� Ƚ����ŭ ����
		for(int i  = 0 ; i < cntPlay ; i++) {
			// ��ü���� ���� ����
			playCarObjsFunc(racingCars);
			System.out.println();
		}
	}
	
	private static void playCarObjsFunc(Car[] racingCars) {
		for(Car car : racingCars) {
			car.playRacingOneTime();
		}
	}

}
