class Main {
    static LinkedList[] arrHash = new LinkedList[20];
    static{
        populateArrWithLinkedLists();
    }
    public static void main(String[] args) {
        String[] names = new String[]{"lundi","mardi","mercredi","jeudi","vendredi","samedi","dimanche"};
        for(String word : names){
            short index = generateIndexHashArray(word);
            insertNameToLinkedList(index, word);
        }
        traverseHashMap();
    }
 
    static short generateIndexHashArray(String name){
        int index = 0;
        int sum_name = 0;
        char[] arrChar = name.toCharArray();
        //arrChar is an array of characters from name
        for(int i : arrChar){
            sum_name = sum_name + (short)i;
        }
        index = sum_name % arrHash.length;
        return (short)index;
    }

    static void populateArrWithLinkedLists(){
        for(int i = 0; i<arrHash.length; i++){
            arrHash[i] = new LinkedList();
        }
    }

    static void insertNameToLinkedList(int index,String name){
        arrHash[index].insertNode(name);
    }

    static void traverseHashMap(){
        for(int i = 0; i < arrHash.length; i++){
            arrHash[i].traverseLinkedList(i);
        }
    }
}

class LinkedList{
    Node head;
    class Node{
        Node next;
        String name;
    }
    public void insertNode(String name){
        Node node = new Node();
        node.name = name;
        if(head == null){
            head = node;
        }else{
            Node point = head;
            head = node;
            head.next = point;
        }
    }
    public void deleteNode(){
        if(head == null){
            return;
        }else{
            head = head.next;
        }
    }

    public void traverseLinkedList(int indexArrHash){
        Node node = head;
        System.out.print(indexArrHash);
        while(node!=null){
            System.out.print("-->");
            System.out.print(" "+ node.name +" ");
            node = node.next;
        }
        System.out.println();
    }
}

