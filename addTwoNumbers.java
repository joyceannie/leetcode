public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null && l2==null){
            return null;
        }
        ListNode sumHead=new ListNode(0);
        int carry=0;
        ListNode current=sumHead;
        
        while(l1!=null && l2!=null){
            current.next=new ListNode((l1.val+l2.val+carry)%10);
            carry=(l1.val+l2.val+carry)/10;
            l1=l1.next;
            l2=l2.next;
            current=current.next;
        }
        while(l2!=null){
            current.next=new ListNode((l2.val+carry)%10);
            carry=(l2.val+carry)/10;
            l2=l2.next;
            current=current.next;
        }
        while(l1!=null){
            current.next=new ListNode((l1.val+carry)%10);
            carry=(l1.val+carry)/10;
            l1=l1.next;
            current=current.next;
        }               
        if(carry!=0){
            current.next=new ListNode(carry%10);
        }
        return sumHead.next;
    }
}
