# Insertion Sort

# Presenter: Fomagran 💻

# 삽입 정렬이란?

> 삽입 정렬은 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여,   
> 자신의 위치를 찾아 삽입함으로써 정렬을 완성하는 알고리즘이다. -위키 백과 -

정렬하는 과정을 살펴보면 아래와 같습니다.

<img src="https://blog.kakaocdn.net/dn/vjCBs/btrf0sIH5hb/DQEDjYtZwrBNJgjl7LidBK/img.gif"  width="200" height="400">

# 삽입 정렬 과정
 
82,10,9,72,31,45,60를 삽입 정렬을 하는 과정은 아래와 같습니다.

### 1. 먼저 맨 첫 번째인 82와 그 다음 숫자인 10을 비교해줍니다. 

10이 더 작으므로 82 앞으로 보냅니다.

> 10 82

### 2. 10 다음 숫자인 9와 10 82를 비교해줍니다.

9는 10,82보다 작으므로 가장 앞으로 보냅니다.

> 9 10 82

### 3. 그 다음 숫자인 72와 이전 숫자들을 비교해줍니다.

72는 82보다 작고 10보다 크므로 10 바로 뒤로 보내줍니다.

> 9 10 72 82

### 4. 31과 이전 숫자들을 비교합니다.

31은 72보다 작고 10보다 크므로 10 바로 뒤로 보내줍니다.

> 9 10 31 72 82

### 5. 45와 이전 숫자들을 비교합니다.

45는 31보다 크고 72보다 작으므로 31 뒤로 보내줍니다.

> 9 10 31 45 72 82

### 6. 마지막으로 60과 이전 숫자들을 비교합니다.

60은 45보다 크고 72보다 작으므로 45 뒤로 보내줍니다.

> 9 10 31 45 60 72 82

# 시간복잡도
 
만약 n개의 데이터가 있다면, 최악의 경우 처음부터 끝까지 1 + 2 + 3 + 4 ... n-1까지 비교를 해야 하기 때문에

시간 복잡도는 O(n²)입니다.

# 코드 구현

```swift
import Foundation

var numbers = [82,10,9,72,31,45,60]

numbers.sortByInsertion(nil) //9,10,31,45,60,72,82

extension Array where Element == Int {
    mutating func sortByInsertion(_ startIndex:Int?) -> [Int] {
        //만약 시작 인덱스가 없다면 1부터 정렬 시작, 있다면 해당 인덱스부터 정렬 시작
        let start = startIndex == nil ? 1 : startIndex!
        //만약 인덱스가 숫자의 갯수만큼 왔다면 반환
        if start == self.count { return self }
        //현재 인덱스 값 설정
        let current = self.remove(at: start)
        var index = 0
        //0부터 해당 인덱스까지 for문으로 순회
        for i in stride(from: start-1, through: 0, by:-1) {
            //만약 현재 값보다 더 같거나 크면 순회 멈춤.
            if current >= self[i] {
                index = i+1
                break
            }
        }
        //순회를 멈춘 인덱스에 현재 값을 삽입해줌.
        self.insert(current, at:index)
        //다음 인덱스로 재귀
        return sortByInsertion(start+1)
    }
}
```

