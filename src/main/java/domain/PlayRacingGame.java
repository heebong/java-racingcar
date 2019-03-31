/**
 * name : PlayRacingGame
 * version : 1.0
 * date : 2019.03.31
 * author : heebong
 * */

package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

import domain.Car;

public class PlayRacingGame {
	private  final int LIMITED_WORD_NUMBER = 5;

	public void play() {
		// TODO Auto-generated method stub
		String carNames[] = receiveCarNamesFromUser();
		int cntPlay = receivePlayCntFromUser();

		Car racingCars[] = initCarObjs(carNames);
		playRacingGame(racingCars, cntPlay);
		printWinners(racingCars);

	}

	private String[] receiveCarNamesFromUser() {
		boolean validationProblem = false;
		String namesFromUserArr[];

		do {
			System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����)");
			Scanner sc = new Scanner(System.in);
			String namesFromUser = sc.nextLine();
			namesFromUserArr = namesFromUser.split(",");
			validationProblem = hasValidationProblem(namesFromUserArr);
		} while (validationProblem);

		return namesFromUserArr;
	}

	/**
	 * �ڵ��� �̸� �� üũ.
	 * 1) �Է¹��� �̸��� 5���� �������� üũ. 5���� �ʰ��� ��� �ȳ��� ���. ���ڼ� ������ ��� LIMITED_WORD_NUMBER �� ǥ��
	 * 2) �ڵ��� �̸��� 0���� �ٽ� �Է�
	 */
	private boolean hasValidationProblem(String[] namesFromUserArr) {
		boolean validationProblem = false;

		for (String names : namesFromUserArr) {
			if (names.length() > LIMITED_WORD_NUMBER) {
				System.out.println("�ڵ��� �̸��� 5���� ���Ϸ� �Է����ּ���.");
				validationProblem = true;
				break;
			}
			if(names.length() <= 0) {
				System.out.println("�ڵ��� �̸��� �Ѱ� �̻� �Է����ּ���.");
				validationProblem = true;
				break;
			}
		}

		return validationProblem;
	}
	
	/**
	 * ���� Ƚ�� �� üũ
	 * 1) 0 �̸��� ���� ������ ��� ��� �� �ٽ� �Է�.
	 * */
	private boolean hasValidationProblem(int playCntFromUser) {
		boolean validationProblem = false;
		
		if(playCntFromUser <= 0) {
			System.out.println("0 �̻��� ���ڸ� �Է��ϼ���");
			validationProblem = true;
		}
		
		return validationProblem;
	}

	private int receivePlayCntFromUser() {
		boolean validationProblem = false;
		int playCntFromUser = 0;
		
		do {
			System.out.println("�õ��� Ƚ���� ��ȸ�ΰ���?");
			Scanner sc = new Scanner(System.in);
			
			/* ���ڸ� �Է����� �� ��� ��� */
			try {
				playCntFromUser = sc.nextInt();
				validationProblem = hasValidationProblem(playCntFromUser);
			}catch(InputMismatchException e) {
				System.out.println("������ �Է����ּ���");
				validationProblem = true;
			}
			
		} while(validationProblem);

		System.out.println();

		return playCntFromUser;
	}

	private Car[] initCarObjs(String[] carNames) {
		Car racingCars[] = new Car[carNames.length];
		for (int i = 0; i < racingCars.length; i++) {
			racingCars[i] = new Car(carNames[i]);
		}

		return racingCars;
	}

	private void playRacingGame(Car[] racingCars, int cntPlay) {
		System.out.println("���� ���");

		for (int i = 0; i < cntPlay; i++) {
			executeCarObjsPlayRacing(racingCars);
			System.out.println();
		}
	}

	private void executeCarObjsPlayRacing(Car[] racingCars) {
		for (Car car : racingCars) {
			car.playRacingOneTime();
		}
	}

	private void printWinners(Car[] racingCars) {
		int winnerNum = findWinnerNum(racingCars);
		String winnersStr = findWinnersName(racingCars, winnerNum);
		System.out.println(winnersStr + "�� ���� ����߽��ϴ�.");
	}

	private int findWinnerNum(Car[] racingCars) {
		int winnerNum = 0;
		for (Car car : racingCars) {
			winnerNum = car.getPosition() > winnerNum ? car.getPosition() : winnerNum;
		}
		return winnerNum;
	}

	private String findWinnersName(Car[] racingCars, int winnerNum) {
		String winnersName = "";
		for (Car car : racingCars) {
			if (car.getPosition() == winnerNum) {
				winnersName += car.getName() + ",";
			}
		}
		return winnersName.substring(0, winnersName.length() - 1);
	}

}
