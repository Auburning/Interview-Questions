package Algorithm;

import java.util.LinkedList;

class HashTable {
    // 해시 테이블에 저장 할 데이터를 노드에 담자 
    class Node{
        String key; // 검색 할 key
        String value; // 검색 결과를 보여 줄 value
        // Node 생성 할 때 key와 value를 받아서 값을 할당한다.
        public Node(String key, String value){
            this.key = key;
            this.value = value;
        }
         //get
        String value(){
            return value;
        }
        //set
        void value(String value){
            this.value = value;
        }
    }

    //데이터 저장 할 LinkedList를 배열로 선언
    //방금 선언 한 노드가 들어갈거다
    LinkedList<Node>[] data;
    HashTable(int size){
        //해시 테이블 크기를 정해 배열 방을 미리 만들어 놓는다. 
        this.data = new LinkedList[size];
    }
    //key를 받아 HashCode를 반환한다. 
    int getHashCode(String key){
        int hashcode =0;
        //key를 입력받아 아스키 코드로 변환. 모두 더한다. 
        for(char c : key.toCharArray()){
            hashcode += c;
        }
        return hashcode;
    }
    int convertToIndex(int hashcode){
        // 해시코드 % 해시 테이블의 크기가 배열 방의 index가 된다. 
        return hashcode % data.length;
    }
    // 인덱스로 배열방 찾았을 때 배열방에 노드가 여러개 존재하는 경우
    // 검색 키를 가지고 해당 노드를 찾아오는 함수 
    Node searchKey(LinkedList<Node> list, String key){
        if(list == null) return null;
        for (Node node:list){
            if(node.key.equals(key)){
                return node;
            }
        }
        return null;
    }
    // 데이터를 받아 저장 해 보자!
    void put(String key, String value){
        //1. key를 가지고 hashcode를 반환한다. 
        int hashcode = getHashCode(key);
        //2. HashCode로 저장 할 배열 방 번호를 받아온다.
        int index = convertToIndex(hashcode);
        //3. 배열 방 번호 이용해 기존 배열 방에 있는 데이터를 가져오고
        LinkedList<Node> list = data[index];
        //3-1. 배열 방이 null이면 LinkedList를 생성한다. 
        if (list == null){
            list = new LinkedList<Node>();
            //해당 리스트를 배열방에 넣어준다. 
            data[index] = list;
        }
        //4.혹시 기존 배열방에 해당 key를 가진 Node가 존재하는지 찾아본다.
        Node node = searchKey(list,key);
        if(node == null){
            // 기존에 해당 키 가진 node가 없었다는 뜻. node를 생성 해 데이터를 추가한다. 
            list.addLast(new Node(key, value));
        }else{
            // 해당 노드의 값을 대체 해 주는걸로 중복키를 처리한다. 
            node.value(value);
        }
    }
    // key를 가지고 data를 가져오는 함수 
    String get(String key){
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        //Node가 null이면 not found 반환, 찾으면 value 반환
        return node == null? "Not found":node.value();
    }

    public static void main (String[] args){
        HashTable h = new HashTable(3);
        h.put("sung", "apple");
        h.put("jin","banana");
        h.put("hee","mango");
        h.put("park","mintChoco");
        System.out.println(h.get("sung"));
        System.out.println(h.get("jin"));
        System.out.println(h.get("hee"));
        System.out.println(h.get("park"));
        System.out.println(h.get("kim"));
    }
}



