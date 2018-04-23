package offerPractice;

/**
 * Created by Meihuan on 2018/4/12.
 */
public class In18 {

    public static ListNode deleteDuplication(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                if(pre == null){
                    //表明首节点重复了
                    while(cur.next != null){
                        if(cur.val == cur.next.val){
                            cur = cur.next;
                        }else{
                            break;
                        }
                    }
                    ListNode newHead = cur.next;
                    if(newHead == null) return newHead;
                    head = newHead;
                    cur = newHead;
                }else{
                    //说明首节点不重复，是中间节点重复了
                    while(cur.next != null){
                        if(cur.val == cur.next.val){
                            cur = cur.next;
                        }else{
                            break;
                        }
                    }
                    pre.next = cur.next;
                    cur = cur.next;
                }
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode tail = new ListNode(1,null);
        ListNode node1 = new ListNode(1,tail);
        ListNode node2 = new ListNode(1,node1);
        ListNode node3 = new ListNode(1,node2);
        ListNode node4 = new ListNode(1,node3);
        ListNode node5 = new ListNode(1,node4);
        ListNode head = new ListNode(1,node5);

        ListNode res = null;
        res = deleteDuplication(head);
    }
}
