# HashTable

 Presenter: Jeongyeon 🐱‍👤

# 개요
유튜브에서 내가 A라는 사람의 영상을 다운 받아 똑같은 영상을 유튜브에 업로드 하려 할 때 유튜브에서 똑같은 영상이라 업로드 할 수 없다고 한다. <br/>
뭐지?? 이건 어떤 원리일까 👻?
바로 Hash Table을 이용 한 것이다!
해시 테이블은 이런 과정으로 진행 된다. 
> F(key) -> HashCode -> Index -> Value
1. 검색하고자 하는 키 값을 Hash 함수로 돌린다.
2. 반환받은 HashCode를 배열의 Index로 환산해서 배열에 접근한다.

자세히 알아보자 😎


# HashTable 이란?
해시 테이블은 Key 와 Value 의 쌍으로 데이터를 저장하는 자료구조 이다. 
언어에 따라 HashMap (Java)이라고도 불리며, 파이썬의 Dictionary 또한 HashTable로 구현되어있다.

![image](https://user-images.githubusercontent.com/64348346/156493655-c7774090-9fe4-4203-91d7-6a07dc3d94a2.png)

## Hash 함수란? Hashing 이란? 
해시함수(hash function)란 데이터의 효율적 관리위해 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수다.
이 때 매핑 전 원래 데이터의 값을 키(key), 매핑 후 데이터의 값을 해시값( Hash Code / Hash Value), 매핑하는 과정 자체를 해싱(hashing)이라고 한다. 



# HashTable 실행 과정 예시 🚖
1. key를 입력 받아 Hash알고리즘을 통해 HashCode를 만든다.
- getHashCode(key) : 입력 받은 문자열의 각 아스키코드 값을 더해 HashCode값을 만든다.
    -  s(115) + u(117) + n(110) + g(103) = 445
    -  j(106) + i(105) + n(110) = 321
    -  h(104) + e(101) + e(101) = 306

해시 테이블은 말 그대로 어떤 고정된 판을 만들어 놓고 키에 따라서 그 위치에 값을 넣는거다. 
그래서 필수 조건 중 하나가 고정된 크기의 배열방 하나를 준비해야한다. </br>
2. 길이가 3인 배열방을 준비한다. 
3. 해시코드를 Index로 환산한다.
- ConvertToIndex(HashCode): HashCode % size(3)
    - 445 % 3 = 1
    - 321 % 3 = 0
    - 306 % 3 = 0
    ![image](https://user-images.githubusercontent.com/64348346/156969408-7f12e8bc-0bcf-4276-915d-049a6d3393bf.png)
4. 배열방에 할당한다. index가 중복 되는 value는 linked list로 연결시킨다.
![image](https://user-images.githubusercontent.com/64348346/156969491-b09eebb6-9bea-4c60-94b5-e41e4a46d170.png)

### 정리 🚩 
- 검색 요청이 들어오면 Hash 함수를 통해 HashCode를 만든다.
- 해시 Code를 index로 환산해서 해당 방의 List를 돌면서 내가 찾는 Data를 가져온다. 


# HashTable의 구조
- Hash Function
    - Hash 알고리즘을 가지고 있다. 
    - 키를 받아 hashcode를 반환한다. 
- Hash Code를 받아 배열 방의 index로 변환 해 주는 함수 
- index로 bukets 의 linked list 를 돌면서 


# HashTable 의 특징 
- 순차적으로 데이터를 저장하지 않는다
- Key 를 통해서 Value값을 얻는다.
- Value 값은 중복 가능하나 Key는 중복될 수 없다
- 최강장점 : 검색 시간이 O(1) 이다. (아닐때도 있다. Collison이 많을 때는 검색시간이 O(n)까지 걸릴 수도 있다. ) 

Array와 달리 저장된 요소를 순서대로 찾는게 아니고 Key값을 통해 Value를 찾기 때문에 빠르다.

# HashTable의 한계
충돌(Collison)이 있을 수 있다. 
- 때로는 전혀 다른 key값이 들어와도 같은 HashCode를 반환 할 때가 있다. 
왜 ? ☹ : Key값은 문자열이라 종류가 무한하지만 hashcode는 정수개 밖에 못 나오기 때문에 중복되는 key값을 반환 할 수 밖에 없다...
- 다른 HashCode가 들어와도 배열 방이 너무 작아서 인덱스로 환산 했을 때 같은 방에 배정 될 수 있다
=> 하나의 배열 방에 겹쳐서 저장되는 모든 경우를 Collison이라고 한다. 
Collision 방지 위해 좋은 해시 알고리즘이 필요하다.

# 한계 극복 방안
1. Chaining
value가 충돌 됐을 때 linked list로 value를 연결시킨다. 
![image](https://user-images.githubusercontent.com/64348346/156964317-938c4ef3-a65d-49d7-88ed-b06770807fc7.png)

2. Linear Proning (선형탐사)
이미 만들어 놓은 buket을 먼저 소모한다. 
![image](https://user-images.githubusercontent.com/64348346/156964739-10f31e6e-ffb9-433d-b9e5-49199b223b47.png)

3. Table Resizing
table길이를 늘인다.
![image](https://user-images.githubusercontent.com/64348346/156964858-a92b462e-b39c-4161-b495-df6f921703b0.png)

# 구현 예제
[HashTable.java](./HashTable.java)

# 알고리즘 풀 때 팁 🎁

내가 좋아하는 동물 리스트 
```
animal[] = ["고양이","강아지","거북이","새","햄스터"]
```
❓animal 중에 햄스터가 있나? 
-  선형 검색 : 모든 list를 다 순회 해야함
- HashTable :
```
animal = {
    "고양이":true,
    "강아지":true,
    "거북이":ture,
    "새":true,
    "햄스터":true
}
```
이렇게 설정 해 주면 array처럼 list가 있지만 원하는 값을 찾는 시간은 더 빨라진다 => O(1)



# 관련 면접 질문
1. 해싱(Hashing)이란?
2. 해시 테이블의 동작 과정 
3. java라면, HashTable과 HashMAp의 차이점

### 참조
[개발자라면 꼭 알아야할 Hash Table 의 모든 것!](https://www.youtube.com/watch?v=HraOg7W3VAM)
[자료구조 알고리즘/ 해쉬테이블(Hash Table)에 대해 알아보고 구현하기](https://www.youtube.com/watch?v=Vi0hauJemxA)
[해시-해시테이블-해싱 5분만에 이해하기 - Gunny](https://www.youtube.com/watch?v=xls6jEZNA7Y&t=187s)