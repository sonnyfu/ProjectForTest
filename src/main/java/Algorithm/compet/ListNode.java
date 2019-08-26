package Algorithm.compet;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class ListNode {
	public ListNode() {

	}

	public int val;
 	public ListNode next;

	ListNode(int x) {
		setVal(x);
		next = null;
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return  head;
		if (head ==null || head.next == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode last = dummy;
		int cnt = 1;
		while (cnt < m) {
			last = last.next;
			cnt++;
		}

		ListNode pre = null;
		ListNode next = last.next;
		ListNode tmpNext = null;
		while (cnt <= n) {
			// 指向后一个node-后一个node指向前一个node
			//
			tmpNext = next.next;
			next.next = pre;// 指向前一个
			pre = next;
			next = tmpNext;
			cnt++;
		}
		// 连接最后一个字符
		last.next.next = tmpNext;
		// 获取第一个node
		last.next = pre;
		return dummy.next;
	}

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l1 = reverseBetween(l1, 1, 2);

		for (int i = 1, k = 6; i <= 3; i++, k--) {
			System.out.print(l1.getVal() + " " + k);
			l1 = l1.next;

		}
		/*
		 * System.out.println(l1.val); l1=l1.next; System.out.println(l1.val);
		 * l1=l1.next; System.out.println(l1.val); l1=l1.next;
		 */
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
}
