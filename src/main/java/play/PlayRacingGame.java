/**
 * name : PlayRacingGame
 * version : 1.0
 * date : 2019.03.31
 * author : heebong
 * */

package play;

import java.util.Scanner;

import domain.Car;

public class PlayRacingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String carNames[] = receiveCarNamesFromUser();
		int cntPlay = receivePlayCntFromUser();
		
		Car racingCars[] = initCarObjs(carNames);
		playRacingGame(racingCars, cntPlay);
		printWinners(racingCars);

	}
	
	private static String[] receiveCarNamesFromUser() {
		System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����)");
		Scanner sc = new Scanner(System.in);
		String namesFromUser = sc.nextLine();
		
		return namesFromUser.split(",");
	}
	
	private static int receivePlayCntFromUser() {
		System.out.println("�õ��� Ƚ���� ��ȸ�ΰ���?");
		Scanner sc = new Scanner(System.in);
		int playCntFromUser = sc.nextInt();
		sc.close();
		System.out.println();
		
		return playCntFromUser;
	}
	
	private static Car[] initCarObjs(String[] carNames) {
		Car racingCars[] = new Car[carNames.length];
		for(int i = 0 ; i < racingCars.length ; i++) {
			racingCars[i] = new Car(carNames[i]);
		}
		
		return racingCars;
	}
	
	private static void playRacingGame(Car[] racingCars, int cntPlay) {
		System.out.println("���� ���");
		
		for(int i  = 0 ; i < cntPlay ; i++) {
			executeCarObjsPlayRacing(racingCars);
			System.out.println();
		}
	}
	
	private static void executeCarObjsPlayRacing(Car[] racingCars) {
		for(Car car : racingCars) {
			car.playRacingOneTime();
		}
	}
	
	private static void printWinners(Car[] racingCars) {
		int winnerNum = findWinnerNum(racingCars);
		String winnersStr = findWinnersName(racingCars, winnerNum);
		System.out.println(winnersStr + "�� ���� ����߽��ϴ�.");
	}
	
	private static int findWinnerNum(Car[] racingCars) {
		int winnerNum = 0;
		for(Car car : racingCars) {
			winnerNum = car.getPosition() > winnerNum ? car.getPosition() : winnerNum;
		}
		return winnerNum;
	}
	
	private static String findWinnersName(Car[] racingCars, int winnerNum) {
		String winnersName = "";
		for(Car car : racingCars) {
			if(car.getPosition() == winnerNum) {
				winnersName += car.getName() + ",";
			}
		}
		return winnersName.substring(0, winnersName.length() - 1);
	}

}
