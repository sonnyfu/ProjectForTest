package newcoder;

/**
 * 链表考察如何省空间
 * Created by sonny on 2017/12/18.
 */
public class LinkListUtil {

    /**
     * 头插法
     * @param e
     * @param root
     * @return
     */
    static SingleLinkNode headInsertSLNode(Integer e,SingleLinkNode root){
        if(root.next==null){
            root.next=new SingleLinkNode(e);
            return root;
        }

        SingleLinkNode tmpNode=root.next;
        root.next=new SingleLinkNode(e);
        root.next.next=tmpNode;
        return  root;
    }

    /**
     * 尾插法
     * @param e
     * @param root
     * @return
     */
    static SingleLinkNode tailInsertSLNode(Integer e,SingleLinkNode root){

        SingleLinkNode tmpNode=root;
        while (tmpNode.next!=null)
            tmpNode=tmpNode.next;
        tmpNode.next=new SingleLinkNode(e);
        return  root;
    }

    /**
     *
     * @param e
     * @param root
     * @return
     */
    static SingleLinkNode deleteSLNode(Integer e,SingleLinkNode root){
        SingleLinkNode tmpNode=root.next;
        SingleLinkNode preNode=root;
        while (tmpNode!=null){
            boolean isEqual=false;
            if(tmpNode.value.equals(e)){
                preNode.next=tmpNode.next;
                //tmpNode.next=null;//java中没有preNode.next引用，因此会自动回收
                isEqual=true;
            }
            if(!isEqual){
                preNode=tmpNode;
                tmpNode=tmpNode.next;
            }else
                tmpNode=preNode.next;
        }
        return root;
    }

    /**
     * 单链表反转
     * @param root
     * @return
     */
    static SingleLinkNode rotateSLNode(SingleLinkNode root){
        if(root.next==null)
            return root;
        SingleLinkNode preNode=root.next;
        SingleLinkNode curNode=root.next.next;
        preNode.next=null;

        while(curNode!=null){
            SingleLinkNode tNode1=curNode.next;
            curNode.next=preNode;
            preNode=curNode;
            curNode=tNode1;
        }
        root.next=preNode;
        return root;
    }

    /**
     * 不带头地结点
     * 循环单练表保持有序
     * @param root
     * @param e
     * @return
     */
    static SingleLinkNode annularSortedSL(SingleLinkNode root,Integer e){
       // if()
        if(root==null){
            SingleLinkNode node=new SingleLinkNode(e);
            node.next=node;
            return node;
        }else if(e<root.value){
            SingleLinkNode node1= new SingleLinkNode(e);
            node1.next=root;
            SingleLinkNode curNode=root;
            while (curNode.next!=root)
                curNode=root.next;
            curNode.next=node1;
            return node1;
        }else{
            SingleLinkNode preNode=root;
            while (preNode.next!=root){
                SingleLinkNode curNode=preNode.next;
                if(preNode.value<=e&&e<=curNode.value){
                    SingleLinkNode node2=new SingleLinkNode(e);
                    preNode.next=node2;
                    node2.next=curNode;
                    return root;
                }
                preNode=curNode;
            }
            SingleLinkNode node3=new SingleLinkNode(e);
            preNode.next=node3;
            node3.next=root;
            return root;
        }
    }

    /**
     * 1>2>3>null
     * 删除2节点
     * 缺点/问题：
     * 1 不能删除最后一个节点
     * 2 若非末节点，若点点数据复杂，删除时复制复杂甚至不被允许，再者就是删除了3，若3代表一个服务器
     * 则会影响服务。
     * @return
     */
    static  SingleLinkNode deleteKthNode(SingleLinkNode kthNode){
        return null;
    }

    /**
     * 方法1：将链表放到数组中，拍完序再组建成链表
     * space:O(n)
     * 最优解方法2：将小于num数的串放在一起，等于的在一起，大于的又在一起
     * space(1)
     * @param root
     * @return
     */
    static  SingleLinkNode hollandWithSLnode(SingleLinkNode root,Integer num){
        int minCount=0;
        int midCount=0;
        int maxCount=0;
        SingleLinkNode min=null;
        SingleLinkNode minTail=null;//空间换时间，时间节省到n,否n2
        SingleLinkNode mid=null;
        SingleLinkNode midTail=null;
        SingleLinkNode max=null;
        SingleLinkNode maxTail=null;
        SingleLinkNode cur=root;
        if(root==null)
            return root;
        //2,7,8,3,5,4,,4
        while(cur!=null){
            if(cur.value<num){
                if(minCount++==0){
                    min=cur;
                    cur=cur.next;
                    min.next=null;
                    minTail=min;
                }else{
                    minTail.next=cur;
                    cur=cur.next;
                    minTail.next.next=null;
                    minTail=minTail.next;
                }
            }else if(cur.value.equals(num)){
                if(midCount++==0){
                    mid=cur;
                    cur=cur.next;
                    mid.next=null;
                    midTail=mid;
                }else{
                    midTail.next=cur;
                    cur=cur.next;
                    midTail.next.next=null;
                    midTail=midTail.next;
                }                
            }else{
                if(maxCount++==0){
                    max=cur;
                    cur=cur.next;
                    max.next=null;
                    maxTail=max;
                }else{
                    maxTail.next=cur;
                    cur=cur.next;
                    maxTail.next.next=null;
                    maxTail=maxTail.next;
                }
        }
        }

        minTail.next=mid;
        midTail.next=max;
        return min;

    }

    /**
     * 寻找公共节点
     * 利用归并排序的原理可以做到
     * 即两个节点比较，谁小谁移动，若相等就输出，直到某个链表遍历完
     * @param root1
     * @param root2
     * @return
     */
    static  SingleLinkNode findCommonSL(SingleLinkNode root1,SingleLinkNode root2){
        return null;
    }

    /**
     * 方法1:利用栈
     * time:O(n),space:O(k)

     * 方法2：
     * 每k个开始逆序，
     * time:O(n),space:O(1)
     * @param root
     * @return
     */
    static  SingleLinkNode everyKNodeReversed(SingleLinkNode root){
        return null;
    }

    /**
     * 方法1
     * 利用栈进出特点，遍历比较，space O(n)
     *
     * 方法2
     * 利用回文可以折叠
     * 只需比较重复部分，一共sO(n/2)
     * -利用快指针走2步，慢指针走1步，当快指针遍历完毕时，慢指针指的就是中间指针
     * -
     *
     * 方法3
     * 后者重复部分逆序调整链表，
     * 比较；
     * 调整回来
     * @param root
     * @return
     */
    static boolean isPalindrome(SingleLinkNode root){
        return false;
    }

    /**
     * 步骤
     * -构造
     * -引用
     * -分流
     * @param root
     * @return
     */
    static  SingleLinkNode cloneSLWithRandNode(SingleLinkNode root){
        return null;
    }

    public static void  main(String[] args){
        SingleLinkNode root=new SingleLinkNode(2);
        tailInsertSLNode(7,root);
        tailInsertSLNode(8,root);
        tailInsertSLNode(3,root);
        tailInsertSLNode(5,root);
        tailInsertSLNode(4,root);
        tailInsertSLNode(4,root);
        SingleLinkNode res=hollandWithSLnode(root,5);
        System.out.println();
/*     SingleLinkNode root=new SingleLinkNode();
        SingleLinkNode node1=new SingleLinkNode(1);
        SingleLinkNode res=null;
        root.next=node1;
        res=headInsertSLNode(2,root);
        res=tailInsertSLNode(2,root);
        res=deleteSLNode(1,root);
        res=rotateSLNode(res);
        System.out.println(res);*/

/*        SingleLinkNode node1=null;//new SingleLinkNode(2);
        //node1.next=node1;
        //SingleLinkNode res=annularSortedSL(node1,1);
        SingleLinkNode res=annularSortedSL(node1,3);
        System.out.println(res);*/


    }
}

/**
 * 带头结点的单链表（带节点与否的区分为value是否为null）
 */
class SingleLinkNode{
    Integer value;
    SingleLinkNode next;
    public SingleLinkNode(Integer value){
        this.value=value;
    }

    public SingleLinkNode(){
    }

}

