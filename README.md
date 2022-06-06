# kotlin-blackjack

## 블랙잭

### 기능 목록
- CardNumber
  - [x] Enum 으로 Ace, Two ~ Ten, Jack, Queen, King 이 있다.
  - [x] 각각 값은 대응되는 숫자를 가지며 A는 1, 11 두 숫자에 대응, K, Q, J는 10이다.
- Suit
  - [x] Enum 으로 Spade, Heart, Diamond, Club이 있다.
- Card
  - [x] 카드는 CardNumber와 Suit 을 속성으로 갖는다.
- Cards
  - [x] 카드들을 속성으로 갖는다.
  - [x] 동일한 카드를 한장 이상 가질 수 없다.
  - [x] 지급받은 카드들의 숫자 합을 반환한다. (A는 1, 11로 대응된다.)
- Score
  - [ ] 점수를 의미하는 객체로 Value class 이다.
- Player
  - [ ] 이름과 Cards 를 속성으로 갖는다.
  - [ ] 지급받은 카드들의 숫자 합을 반환한다. (A는 1, 11로 대응된다.)
  - [ ] 21을 넘었는지 여부를 반환한다.
  - [ ] 게임 종료 여부를 반환한다.
  - [ ] 해당 플레이어의 게임을 종료한다.
- Players
  - [ ] Player들을 속성으로 갖는다.
  - [ ] 아직 종료되지 않은 유저 목록을 반환한다.
- Blackjack
  - [ ] 모든 카드가 있는 상태로 초기화된 Cards 를 필드로 갖는다.
  - [ ] Players들을 생성자로 받는다.
  - [ ] Players에게 초기 카드를 발급한다.
  - [ ] 아직 종료되지 않은 플레이어 목록을 반환한다.
  - [ ] 특정 플레이어에게 카드를 지급한다.
- BlackjackController
  - [ ] InputView 로부터 게임에 참여할 사람 이름을 입력받는다.
  - [ ] 플레이어를 초기화하고 상태를 출력한다.
  - [ ] 아직 종료되지 않은 플레이어를 받아 카드 지급 여부를 확인하고 필요시 지급한다.
  - [ ] 추가지급을 하지 않는 플레이어는 게임을 종료한다.
  - [ ] 모든 플레이어를 출력한다.
  - 