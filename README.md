# 자동차 경주 게임

## 기능 구현 목록

- [x] 자동차 이름 입력 기능
    - [x] 사용자로부터 쉼표(,)로 구분된 자동차 이름 목록을 입력받는다
    - [x] 각 이름은 1자 이상, 5자 이하인지 검증한다
    - [x] 모든 자동차 이름은 서로 다른 이름인지 검증한다
    - [x] 이름이 비어있거나 중복된 경우 예외를 발생시킨다

- [x] 이동 횟수 입력 기능
    - [x] 사용자로부터 몇 번의 이동을 할 것인지 횟수를 입력받는다
    - [x] 입력값이 양의 정수인지 검증한다
    - [x] 입력값의 크기가 자료형 범위를 초과하지는 않는지 검증한다

- [x] 자동차 경주 기능
    - [x] 각 차수별로, 각 자동차는 전진 또는 정지한다
    - [x] 전진 조건은 '무작위 수(0~9) 중 4 이상일 경우'이다

- [x] 경주 진행 결과 출력 기능
    - [x] 매 차수마다 각 자동차 이름과 이동 횟수를 형식에 맞게 출력한다
    - [x] 진행 결과 출력은 누적된 결과로 출력한다

- [x] 우승자 판별 및 출력 기능
    - [x] 가장 멀리 이동한 자동차를 우승자로 판단한다
    - [x] 최종 우승자를 출력한다
    - [x] 이때, 공동 우승이 가능하며, 공동 우승일 경우 쉼표로 구분하여 모두 출력한다

- [x] 예외 처리 기능
    - [x] 잘못된 입력(이름 길이 초과, 빈 이름, 음수 입력 등)에 대해 `IllegalArgumentException`을 발생시키고 종료한다
    - [x] 프로그램 종료 직전, 예외 메시지를 사용자에게 명확히 출력한다

---

## 테스트 코드 목록

- [x] 성공 케이스에 대한 테스트 코드를 추가한다
    - [x] CarTest: 입력된 이름에 따라 정상적으로 자동차가 생성된다
    - [x] CarTest: 개별 자동차는 이동 조건이 true일 때 전진한다
    - [x] CarTest: 개별 자동차는 이동 조건이 false일 때 정지한다
    - [x] CarsTest: 자동차 이름 문자열이 정상적으로 파싱되어 리스트로 변환된다
    - [x] CarsTest: 이동 조건을 만족하는 자동차들만 전진한다
    - [x] CarsTest: 가장 멀리 간 단일 우승자를 정확히 찾는다
    - [x] CarsTest:가장 멀리 간 공동 우승자들을 정확히 찾는다
    - [x] TryCountTest: 숫자 문자열을 입력하면 정상적으로 숫자로 처리된다
    - [x] WinnersTest: 단일 우승자 이름을 정확히 반환한다
    - [x] WinnersTest: 공동 우승자 이름을 쉼표로 구분하여 반환한다
    - [x] WinnersTest: 우승자 목록을 불변으로 반환한다
    - [x] ApplicationTest: 사용자 입력과 랜덤 수에 따라 게임이 정상적으로 실행된다
    - [x] ApplicationTest: 게임 결과로 단일 우승자가 정상적으로 출력된다
    - [x] ApplicationTest: 게임 결과로 공동 우승자가 정상적으로 출력된다

- [x] 실패 케이스에 대한 테스트 코드를 추가한다
    - [x] CarTest: 자동차 이름이 빈 문자열일 경우 → `IllegalArgumentException` 발생
    - [x] CarTest: 자동차 이름이 null일 경우 → `IllegalArgumentException` 발생
    - [x] CarTest: 자동차 이름이 5자를 초과할 경우 → `IllegalArgumentException` 발생
    - [x] CarTest: 자동차 이름이 공백만 있는 경우 → `IllegalArgumentException` 발생
    - [x] CarsTest: 자동차 이름 목록에 중복된 이름이 있을 경우 → `IllegalArgumentException` 발생
    - [x] CarsTest: 자동차 이름 입력이 없을 경우 → `IllegalArgumentException` 발생
    - [x] TryCountTest: 음수를 입력한 경우 → `IllegalArgumentException` 발생
    - [x] TryCountTest: 0을 입력한 경우 → `IllegalArgumentException` 발생
    - [x] TryCountTest: 숫자가 아닌 문자를 입력한 경우 → `IllegalArgumentException` 발생
    - [x] TryCountTest: Long 범위를 초과한 수를 입력한 경우 → `IllegalArgumentException` 발생
    - [x] ApplicationTest: 자동차 이름 입력이 비어 있는 경우 → `IllegalArgumentException` 발생
    - [x] ApplicationTest: 자동차 이름 중 빈 값(,,)을 포함한 경우 → `IllegalArgumentException` 발생
    - [x] ApplicationTest: 시도 횟수에 음수를 입력한 경우 → `IllegalArgumentException` 발생
    - [x] ApplicationTest: 시도 횟수에 Long 범위를 초과한 수를 입력한 경우 → `IllegalArgumentException` 발생

---

## 리팩토링 목록

- [x] main 메서드의 책임을 실행 흐름 담당 run() 메서드와 경주 담당 playRacing() 메서드로 분리
    - main(): 진입점 역할만 수행하도록 단순화
    - run(): 입력 → 비즈니스 로직 → 출력의 전체 흐름 제어
    - playRacing(): 경주 반복 실행만 담당하도록 분리
- [x] Winners 일급 컬렉션을 도입하여 우승자 목록을 객체로 캡슐화
    - Cars.findWinners()의 반환 타입을 List<Car>에서 Winners로 변경하여 도메인 모델의 일관성 강화
    - 기존에 OutputView에서 모두 처리하던 우승자 관련 로직 중 이름 조합 로직은 Winners로 이동, 출력은 OutputView에서 수행하도록 역할을 분리
    - Cars의 책임을 단순화하고, 우승자 관리 및 표현 책임을 Winners로 위임하여 응집도 향상
- [x] Cars.findWinners() 함수 내 로직을 더 작게 분리
    - findWinners() 을 findMaxPosition() 와 filterCarsByPosition() 으로 책임을 명확히 분리함
