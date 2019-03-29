package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    /* �׽�Ʈ�� ���� �߰�*/
    public String getName() {
    	return this.name;
    }
    
    /**
     * ������ ���� ����
     * ���� ��Ȳ ���
     * */
    public void playRacingOneTime() {
    	// ���� ����
    	int randNum = makeRandomNum();
    	// �������� �ƴ��� Ȯ��
    	isGoingForward(randNum);
    	// ���� ������ ���
    	printResultStr();
    }
    
    /**
     * 0~9 ������ ������ ���� ����
     * */
    private int makeRandomNum() {
    	Random rand = new Random();
    	int randNum = rand.nextInt(10);
    	
    	return randNum;
    }
    
    /**
     * ������ ���ڰ� 4 �̻��̸� ����(true), 3 ���ϸ� ����(false)
     * �����̸� position �� +1;
     * */
    private void isGoingForward(int randNum) {
    	if(randNum >= 4) {
    		this.position += 1;
    	}
    }
    
    /**
     * ��� ���� : �̸� : -(���� Ƚ��)
     * */
    private void printResultStr() {
    	String strResult = "";
    	// �̸� �ֱ�
    	strResult += this.name + " : ";
    	// ������ ��� �ֱ�
    	strResult += printForwardingCnt();
    	
    	System.out.println(strResult);
    }
    
    /**
     * printResultStr���� ����ϴ� �Լ�.
     * */
    private String printForwardingCnt() {
    	String strResult = "";
    	
    	for(int i  = 0 ; i < this.position ; i++) {
    		strResult += "-";
    	}
    	
    	return strResult;	
    }
}
