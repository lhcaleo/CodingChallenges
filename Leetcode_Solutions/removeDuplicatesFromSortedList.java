class Solution 
{
    public ListNode deleteDuplicates(ListNode head) 
    {
        ListNode curr = head;
        
        while(curr != null)
        {
            ListNode next = curr.next;
            if (next == null)
                return head;
            else if (next.val == curr.val)
            {
                curr.next = next.next;
                next.next = null;
            } 
            else
                curr = curr.next;
        }
        
        return head;
    }
}