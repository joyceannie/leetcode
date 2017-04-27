public class reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null)
        return head;
        else
        {
            ListNode currentNode=head.next;
            ListNode nextNode=currentNode.next;
            ListNode prevNode=head;
            currentNode.next=prevNode;
            prevNode.next=null;
            prevNode=currentNode;
            currentNode=nextNode;
            while(currentNode!=null)
            {
                nextNode=currentNode.next;
                currentNode.next=prevNode;
                prevNode=currentNode;
                currentNode=nextNode;
            }
            return prevNode;
        }
      }
}
