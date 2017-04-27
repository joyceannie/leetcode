public class linkedListCycle{
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null){
            return false;
        }
        ListNode start1 = head;
        ListNode start2= head.next;
        
        while(start2 != start1){
            if (start2==null || start2.next==null){
                return false;
            }
        start1=start1.next;
        start2=start2.next.next;

         }
         return true;
    }
}
