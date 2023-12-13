# 🚀 기능 명세서

- [ ] 메뉴 - MenuOptionEnum, MenuGroupEnum
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
- [ ] 달력 - CalenderEnum
- [ ] 중복 할인 및 증정 적용 - EventPlanner
- [ ] 크리스마스 디데이 할인 - ChristmasDdayDiscount#discount
  - [ ] 2023.12.1 ~ 2023.12.25 - Calender#isDdayEventTerm
  - [ ] 초기 값 1000원, 매일 100원씩 증가 - ChristmasDdayDiscount#discount
  - [ ] 총주문 금액 - 해당 금액 - EventPlanner
- [ ] 평일/주말 할인 - WeekAndWeekendDiscount#discount
  - [ ] 주말인지, 평일인지 판단한다. - Calender#isWeekend
  - [ ] 평일(일~목) : 디저트 메뉴 1개당 2023원 할인 - WeekAndWeekendDiscount#discount
  - [ ] 주말(금~토) : 메인 메뉴 1개당 2023원 할인 - WeekAndWeekendDiscount#discount
- [ ] 특별 할인 - SpecialDiscount#discount
  - [ ] 3, 10, 17, 24, 25, 31일 - Calender#isStarDate
  - [ ] 총주문 금액 - 1000원 - SpecialDiscount#discount
- [ ] 증정 이벤트 - GiftEvent
  - [ ] 총주문 금액 >= 12만원 , 샴페인 1개(25000원) 증정 - GiftEvent#receiveGift
- [ ] 크리스마스 디데이 할인 외 12.1~12.31 적용 - Calender#isEventTerm
- [ ] 이벤트 배지 부여 - BadgeEnum
  - [ ] 총혜택 금액에 따라 : 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴 가격 - EventPlanner#getTotalBenefitPrice
    - [ ] 5천원 이상 : 별
    - [ ] 1만원 이상 : 트리
    - [ ] 2만원 이상 : 산타
- [ ] 예외 처리
  - [ ] 총주문 금액 10000원 이상부터 이벤트 적용 - Orders(MenuOptions, count)#getTotalPrice
  - [ ] 음료만 주문 불가 - MenuOptionEnum#isGroupOf
  - [ ] 한번에 메뉴 최대 20개 주문 가능 - Orders#getTotalCount
- [ ] 예약 안내 문구 출력
  - [ ] "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다." 출력 - OutputVeiw#printReservationNotice
- [ ] 예상 방문 날짜 입력
  - [ ] "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)" 출력  - InputView#inputReservationDate
  - [ ] "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." 예외 출력 - ExceptionEnum
    - [ ] 1이상 31이하가 아닌 경우 - Calender#isValidDate
    - [ ] 숫자가 아닌 경우 
- [ ] 주문 메뉴와 개수 입력
    - [ ] "주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)" 출력 - InputView#inputOrders
      - [ ] "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 예외 처리
        - [ ] 없는 메뉴를 입력하는 경우 - Orders#validate
        - [ ] 메뉴 개수를 1 미만을 입력하는 경우 - Orders#validate
        - [ ] 메뉴 개수가 숫자가 아닌 경우
        - [ ] 주어진 형식과 다른 경우
        - [ ] 중복 메뉴를 입력하는 경우(e.g. 시저샐러드-1,시저샐러드-1) - Orders#validate
- [ ] 혜택 미리 보기 안내 문구 출력
    - [ ] "12월 n일에 우테코 식당에서 받을 이벤트 미리 보기!" 출력 - OutputView#printBenefitsNotice
- [ ] 주문 메뉴 출력
  - [ ] "<주문 메뉴>" 출력 - OutputView#printOrderMenus
  - [ ] "메뉴명 n개" 형식으로 출력 - OutputView#printOrderMenus
  - [ ] 주문 메뉴 출력 순서는 자율
- [ ] 총주문 금액 출력
  - [ ] "<할인 전 총주문 금액>" 출력 - OutputView#printTotalOrdersPrice
  - [ ] "0,000원" 형태로 출력 - OutputView#printTotalOrdersPrice
- [ ] 증정 메뉴 출력
  - [ ] "<증정 메뉴>" 출력 - OutputView#printGiftMenu
  - [ ] "메뉴명 n개" 형태로 출력 - OutputView#printGiftMenu
  - [ ] 해당 X : "없음" 출력 - OutputView#printGiftMenu
- [ ] 혜택 내역 출력
  - [ ] "<혜택 내역>" 출력 - OutputView#printBenefits
  - [ ] "할인명 : -0,000원" 형태로 출력 - OutputView#printBenefits
  - [ ] 적용 이벤트 내역만 출력
  - [ ] 해당 X : "없음" 출력
  - [ ] 해택 내역 출력 순서는 자율
- [ ] 총혜택 금액 출력
  - [ ] "<총혜택 금액>" 출력 - OutputView#printTotalBenefitsPrice
  - [ ] "-0,000원" 형태로 출력 - OutputView#printTotalBenefitsPrice
- [ ] 할인 후 예상 결제 금액 출력
  - [ ] "<할인 후 예상 결제 금액>" 출력 - OutputView#printActualPaymentPrice
  - [ ] "0,000원" 형태로 출력 - OutputView#printActualPaymentPrice
  - [ ] 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액 - EventPlanner#getActualPaymentPrice
- [ ] 이벤트 배지 출력
  - [ ] "<12월 이벤트 배지>" 출력 - OutputView#printEventBadge
  - [ ] 해당 X : "없음" 출력 - OutputView#printEventBadge
  - [ ] 총혜택 금액에 따라 이벤트 배지 이름 다르게 출력
