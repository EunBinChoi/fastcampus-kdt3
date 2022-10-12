<h3>컬렉션 프레임워크 (collection framework)</h3>

- 배열 한계 ?
  1) 배열 사이즈 고정되기 때문에 추가 연산시 자리가 부족하면 아래와 같은 로직을 만들어야 함
     - 기존 데이터 복사 (새롭게 객체 배열을 new 하면 기존 원소 null으로 변경)
     - 객체 배열을 새롭게 할당하고 기존 복사된 데이터를 대입  
       
  2) 객체 배열의 중간 원소 의 삽입, 삭제하기 힘듦)
     - 삭제시 앞으로 댕겨주거나 추가시 뒤로 밀어주는 작업 필요  


- 컬렉션 (collection): 객체를 저장하는 방법
  - java.util 패키지
  - 주요 인터페이스: List, Set, Map

  1) List: 순서 유지 (숫자 인덱스로 접근)
     원소 중복 가능
     ex) ArrayList, Vector, LinkedList

  2) Set: 집합
     - 순서 유지 X
     - 원소 중복 불가
     ```
          {10, 20, 30} == {10, 10, 20, 30}
          {1, 6} == {6, 1}
     ```
     ex) HashSet, LinkedHashSet (삽입된 순서 유지), TreeSet (크기 순서 유지)

  3) Map
     - key-value 쌍으로 저장 (mapping)
     - 순서 유지 X
     - 키는 중복 불가 (원소를 접근하기 위한 인덱스 같은 존재), 원소 중복 가능
     - 키를 통해 원소를 검색하므로 키가 검색 성능 좌우함
     - ex) HashMap (not synchronized), Hashtable (synchronized),
           LinkedHashMap (삽입된 순서 유지), TreeMap (크기 순서 유지 (키 기준으로 오름차순))  
     
   4) Stack, Queue
      - Stack: 마치 책이 쌓이는 것처럼 나중에 넣은 객체가 먼저 빠져나가는 자료구조
        - 입력: 1 -> 2 -> 3 -> 4 
        - 출력: 4 -> 3 -> 2 -> 1
        - Last In, First Out (LIFO), 후입선출   
        
          ```Stack<E> stack = new Stack<E>();```

          cf) Stack 메모리
        - 할당 순서: a -> b -> c -> i
        - 해제 순서: i -> c -> b -> a
        
          ```
          int a = 3;
          int b = 5;
          int c = 7;

          for(int i = 0; ){
             ...
          }
          ```

      - Queue: 마치 사람이 줄서있는 것처럼 먼저 넣은 객체가 먼저 빠져나가는 자료구조
        - 입력: 1 -> 2 -> 3 -> 4
        - 출력: 1 -> 2 -> 3 -> 4
        - First In, First Out (FIFO), 선입선출  
                  
         ```Queue<E> queue = new LinkedList<E>();```