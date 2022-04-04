package Offer35;

public class Solution {
    public static void main(String[] args) {
        Node node1;
        Node node2;
        Node node3;
        Node node4;

        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);
        node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        //下列为各个结点的random关系
        //1-3
        //2-4
        //3-2
        //4-1
        node1.random = node3;
        node2.random = node4;
        node3.random = node2;
        node4.random = node1;

        Solution solution = new Solution();
        solution.geneNewNode(node1);
        solution.copySiblings(node1);
        Node oldNode = node1;
        while (oldNode != null) {
            System.out.println("geneVal:" + oldNode.val + ",geneRandom:" + oldNode.random.val);
            oldNode = oldNode.next;
        }
        System.out.println("-------------");
        Node newNode = solution.separateNewNode(node1);
        while (node1 != null) {
            System.out.println("oldVal:" + node1.val + ",oldRandom:" + node1.random.val);
            node1 = node1.next;
        }
        System.out.println("-------------");
        while (newNode != null) {
            System.out.println("newVal:" + newNode.val + ",newRandom:" + newNode.random.val);
            newNode = newNode.next;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        geneNewNode(head);
        copySiblings(head);
        return separateNewNode(head);
    }

    //根据原有链表生成新链表并链接在每个原有结点的next域后
    public void geneNewNode(Node oldHead) {
        Node cur = oldHead;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
    }

    //由于合并后的新链表是依次相邻的关系，若原结点的random指向p结点，则新结点的random指向p.next
    public void copySiblings(Node oldHead) {
        Node cur = oldHead;
        while (cur != null) {
            Node newNode = cur.next;
            if (cur.random != null) {
                newNode.random = cur.random.next;
            }
            cur = newNode.next;
        }
    }

    //分离成两个链表，并返回新链表的head
    public Node separateNewNode(Node oldHead) {
        Node cur = oldHead;//该变量的作用是遍历合并后的链表的每一项
        Node newHead = oldHead.next;//即将返回的新链表头

        while (cur != null) {
            Node node = cur.next;//指向偶数位置的结点
            cur.next = node.next;//cur.next指向下一个奇数结点
            node.next = node.next == null ? null : node.next.next;//node指向下下一个结点
            cur = cur.next;
        }
        return newHead;
    }
}
