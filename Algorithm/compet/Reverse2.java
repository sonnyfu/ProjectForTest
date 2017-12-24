package compet;
/**
 * 翻转：
 * @author Administrator
 *
 */
public class Reverse2 {
	//基本类型，包装类
	int val;
	Reverse2 next;
	public Reverse2(int x) {
		val=x;
		next=null;
	}
	static Reverse2 reverse(Reverse2 head,int m,int n){
		Reverse2 pre=new Reverse2(0);
		pre.next=head;
		Reverse2 fist=pre;
		int k=m-1;
		while(k-->0){
			fist=fist.next;
		}
		Reverse2 sec=fist.next;
		Reverse2 node=fist.next;
		Reverse2 tmp=null;
		Reverse2 tnext=null;
		int j=n-m+1;
		//翻转（遍历时，通过改变next来连接（顺序访问node，的node））
		while(j-->0){
			tmp=node;
			node=node.next;//xx.next代表下个node，又可以用来连接另一个节点
			tmp.next=tnext;//核心
			tnext=tmp;
		}
		//连接
		fist.next=tmp;
		sec.next=node;
		return pre.next;
	}
	public static void main(String[] args) {
		//后输入
		//
		Reverse2 reverse1=new Reverse2(1);
		Reverse2 reverse2=new Reverse2(2);
		Reverse2 reverse3=new Reverse2(3);
		reverse1.next=reverse2;
		reverse2.next=reverse3;
		reverse1=reverse(reverse1,1,2);
/*		Reverse2 reverse22=reverse1;
		System.out.print(reverse22.next.val+" ");*/
		for(int i=1;i<=3;i++){
			System.out.print(reverse1.val+" ");
			reverse1=reverse1.next;
		}
	}

}
