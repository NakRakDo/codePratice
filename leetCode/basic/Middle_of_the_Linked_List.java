package leetCode.basic;

public class Middle_of_the_Linked_List {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode node = new  ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode node1 = middleNode(node);
        System.out.println(node);
        System.out.println(node1);
    }

    private static ListNode middleNode(ListNode head){
        ListNode node = head;
        int count = 1;

        while(node.next != null){
            ++count;
            node = node.next;

        }

        int middle = count / 2 - 1;

        node = head;
        while(middle > -1){
            node = node.next;
            --middle;
        }
        return node;
    }
}


