# 자동차 경주 게임

프리 코스 두 번째 과제 <자동차 경주 게임>입니다.<br>
각 자동차들이 경주를 펼쳐 가장 멀리 나간 자동차가 우승하는 프로그램입니다.
<br><br>

# 게임 방법  

1. 자동차 이름을 입력
>* 이름1,이름2,이름3 형식으로 입력
>* 자동차의 이름은 콤마(,)로 나뉘어지기 때문에 참고해서 입력
>* 전부 입력했으면 엔터 입력

> **경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)**
> 안녕하세요,반가워요,제이름은,heebong
> **자동차 이름은 5글자 이하로 입력해주세요.**
> **경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)**
> 안녕하세요,반가워요,제이름은,heebg

2. 게임 횟수를 입력
> **시도할 횟수는 몇회인가요?**
> 5

3. 게임 횟수만큼 자동차의 전진 상황을 확인
>* '자동차 이름 : 전진횟수' 형식으로 출력
>* 전진 횟수는 '-' 이걸로 표시

4. 가장 멀리나간 우승차 확인
<br>

# 구현 기능
**메인 기능 [PlayRacingGame]**<br>
1. 사용자로부터 자동차 이름 입력받기
>* 이름을 , 기준으로 나누기
>* 이름이 5글자 초과면 안내문이 출력되고 다시 사용자로부터 이름 받음.

2. 사용자로부터 게임 횟수 입력받기
3. 자동차 이름별로 Car 객체 생성하기
4. 레이싱 게임 실행
>* 입력받은 게임 횟수만큼 레이싱 진행
>* 레이싱은 객체별로 순차적으로 진행.

5. 우승자 출력
>* 최고 점수 획득, 최고 점수의 자동차 이름 획득
>* 우승 자동차 이름 출력

**Car 객체** 
1. 생성자
>* 생성시 이름 설정

2. 1회 레이싱 진행
>* 0~9 사이의 임의의 난수 생성
>* 난수가 4 이상이면 전진(포지션 +1)
>* 현재 전진 상황 출력

