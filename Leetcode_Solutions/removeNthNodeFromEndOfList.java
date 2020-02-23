// Two Pointer, one fast, one slow
// keep their gap at n, and move till the end
// Time: O(n) Space: O(1)
class Solution 
{
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {    
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        // Advances fast pointer so that the gap between fast and slow is n nodes apart
        while(n > 0) {
            fast = fast.next;
            n--;
        }
        // Move fast to the end, maintaining the gap
        while(fast.next != null) 
        {
            fast = fast.next;
            slow = slow.next;
        }
        // Slow pointer's next node is the n-th node from the end of list
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}