# 🚀 기능 명세서

### 메뉴
- [ ] Enum으로 관리
  - [ ] MenuType(viewName, MenuOptions[]{})
  - [ ] MenuOptions(viewName,price)
  - [ ] 어떤 종류의 메뉴인지 찾는다. - MenuType#getMenuType
  - [ ] 특정 메뉴 종류에 포함되는지 찾는다. - MenuType#hasMenuOption
```
<애피타이저>
양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

<메인>
티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

<디저트>
초코케이크(15,000), 아이스크림(5,000)

<음료>
제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
```
## 이벤트 목록
- 중복 할인과 증정 허용
- 이벤트 목록 Enum 관리
- 이벤트 기간 : (크리스마스 디데이 할인 외) 2023.12.1 ~ 2023.12.31
- [ ] 크리스마스 디데이 할인 적용 - Event#christmasDdayDiscount
  - [x] 이벤트 기간인지 확인한다.: 2023.12.1 ~ 2023.12.25 - DecemberCalender#isAfterChristmas
  - [x] 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가 - ChristmasDdayDiscount#discount
    - 최종 25일엔 3400원 할인
    - 총 주문 금액에서 해당 금액만큼 할인
- [ ] 요일 할인 적용 - Event#dayOfWeekDiscount
  - [x] 주말인지 확인한다. - DecemberCalender#isWeekend
  - [x] 평일 할인(일~목) : 디저트 메뉴 1개당 2023원 할인 - DayOfWeekDiscount#discount
    - [x] 디저트 메뉴 개수를 구한다. - Orders#getDessertCount
  - [x] 주말 할인(금~토) : 메인 메뉴 1개당 2023원 할인 - DayOfWeekDiscount#discount
    - [x] 메인 매뉴 개수를 구한다. - Orders#getMainDishCount
- [ ] 특별 할인 적용 - Event#specialDiscount
  - [x] 이벤트 달력에 별이 있으면 총주문 금액에서 1000원 할인 - SpecialDiscount#discount
  - [x] 특별 할인 날짜인지 확인한다. : 매주 일요일(3,10,17,24,31), 크리스마스(25) - DecemberCalender#hasStar
- [ ] 증정 이벤트 적용 - Event#getGift
  - [x] 할인 전 총주문 금액 >= 12만원이다. - Orders#getTotalOrderPrice
  - [x] 샴페인 1개(25,000원) 증정 - GiftEvent#receiveGift
## 이벤트 배지
- [ ] 이벤트 배지 부여 - Event#getEventBadge
  - [ ] Enum으로 관리 - Badge
    - [ ] 총 혜택 금액에 따라 이벤트 배지 다르게 부여
    - [ ] 총 혜택 금액 계산하기 - Event#getTotalEventPrice
        - 5천원 이상 : 별
        - 1만원 이상 : 트리
        - 2만원 이상 : 산타
## 이벤트 플래너
- `고객` 방문 날짜, 메뉴 미리 선택 -> `이벤트 플래너` 주문 메뉴, 할인 전 총주문 금액, 증정 메뉴, 혜택 내역, 총혜택 금액, 할인 후 예상 결제 금액, 12월 이벤트 배지 내용 명시
### `고객` 방문 날짜, 메뉴 미리 선택
- [x] 방문 날짜 입력 - InputView#inputVisitingDate
  - [x] "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
    - [x] 1~31 사이 숫자만 입력 - DecemberCalender#isValidDate
    - [x] 숫자가 아닌 경우 & 범위 내 숫자가 아닌 경우 :  "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."
- [x] 주문 메뉴와 개수 입력 - InputView#inputOrders
  - [x] "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
  - [x] 주문 메뉴 입력
    - [x] 음료만 주문 불가 
      -[x] 음료만 주문하는 경우 : "[ERROR] 음료만 주문할 수 없습니다. 다시 입력해 주세요." - Orders#validate
    - [x] 존재하지 않는 메뉴인 경우 : "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." - MenuOption#findMenuOption
  - [x] 주문 개수 입력
    - [x] 숫자가 아닌 경우 & 1 이상의 숫자가 아닌 경우 : "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
    - [x] 메뉴는 한 번에 최대 20개까지 주문 가능 - Orders#validate
      - [x] 20 초과인 경우 : "[ERROR] 메뉴는 한 번에 최대 20개까지 주문 가능합니다. 다시 입력해 주세요."
  - [x] 올바르지 않은 메뉴 형식인 경우 : "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
  - [x] 중복 메뉴를 입력한 경우 : "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
### `이벤트 플래너` 주문 메뉴, 할인 전 총주문 금액, 증정 메뉴, 혜택 내역, 총혜택 금액, 할인 후 예상 결제 금액, 12월 이벤트 배지 내용 명시
- [x] 주문 메뉴 출력 - OutputView#printOrderedMenus
  - [x] "<주문 메뉴>" 
  - [x] "메뉴명 0개" 형식으로 순서는 자유롭게 출력
- [x] 할인 전 총주문 금액 출력 - OutputView#printOrdersAmount
  - [x] "<할인 전 총주문 금액>"
- [x] 증정 메뉴 출력 - OutputView#printGiftMenu
  - [x] "<증정 메뉴>"
  - [x] 증정 이벤트에 해당하지 않는 경우 "없음" 출력
- [ ] 혜택 내역 출력 - OutputView#printBenefitDetails
  - [ ] "<혜택 내역>"
  - [ ] "이벤트명: -0,000원" 형식으로 순서는 자유롭게 출력
    - [x] 크리스마스 할인은 "크리스마스 디데이 할인:" 형식으로 출력
    - [x] 요일 할인은 "평일 할인:", "주말 할인:" 형식으로 출력
    - [x] 특별 할인은 "특별 할인:" 형식으로 출력
    - [ ] 증정 이벤트는 "증정 이벤트: " 형식으로 출력
  - [ ] 고객에게 적용된 이벤트 내역만 출력
  - [ ] 총주문 금액 10000원 이상부터 이벤트 적용
    - [ ] 혜택 내역 없을 경우 "없음" 출력
- [ ] 총 혜택 금액 출력 - OutputView#printBenefitPrice
  - [ ] "<총혜택 금액>"
  - [ ] "-00,000원" 형식으로 출력
  - [ ] 총혜택 금액 = 할인 금액 합게 + 증정 메뉴 가격
  - [ ] 혜택 금액 없을 경우 : 0원
- [ ] 할인 후 예상 결제 금액 출력 - OutputView#printExpectedPaymentAmount
  - [ ] "<할인 후 예상 결졔 금액>"
  - [ ] 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액
- [ ] 이벤트 배지 출력 - OutputView#printEventBadge
  - [ ] "<12월 이벤트 배지>"
  - [ ] 총혜택 금액에 따라 이벤트 배지 이름 다르게 출력
  - [ ] 이벤트 배지 없을 경우 "없음" 출력


# ⚠️추가된 요구 사항
- 아래 있는 InputView, OutputView 클래스를 참고하여 입출력 클래스를 구현한다.
  - 입력과 출력을 담당하는 클래스를 별도로 구현한다.
  - 해당 클래스의 패키지, 클래스명, 메서드의 반환 타입과 시그니처는 자유롭게 구현할 수 있다.
  ```java
  public class InputView {
      public int readDate() {
          System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
          String input = Console.readLine();    
          // ...
      }
      // ...
  }
  ```
  ```java
  public class OutputView {
      public void printMenu() {
          System.out.println("<주문 메뉴>");
          // ...
      }
      // ...
  }
  ```