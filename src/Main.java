import Offer06.Solution;
import Offer24.ListNode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ListNode listNode3 = new ListNode(2, null);
//        Offer24.ListNode listnode2;
        ListNode listNode2 = new ListNode(3, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.reversePrint(listNode1)));

    }
}
