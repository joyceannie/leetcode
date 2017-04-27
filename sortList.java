public class sortList{
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        ListNode endOfFirstSubArray=null;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            endOfFirstSubArray=slow;
            slow=slow.next;
        }
        
        endOfFirstSubArray.next=null;
        ListNode list1=sortList(head);
        ListNode list2=sortList(slow);
        
        return merge(list1,list2);
    }
    
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode head=new ListNode(0);
        ListNode current=head;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                current.next=l1;
                l1=l1.next;
            }
            else{
                current.next=l2;
                l2=l2.next;
            }
            current=current.next;
        }
        
        if (l1==null){
            current.next=l2;
        }
        else{
            current.next=l1;
        }
        return head.next;
    }
}
