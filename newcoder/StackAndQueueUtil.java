package newcoder;

import java.util.*;

/**
 * Created by sonny on 2017/12/16.
 */
public class StackAndQueueUtil {


    /**
     * 深度优先遍历用栈实现
     * 利用栈先进后出特点，先压右子树再压左子树
     *
     * @param node
     */
    static void dfsBTree(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode nodeTmp = stack.peek();
            stack.pop();
            System.out.println(nodeTmp.value);
            if (nodeTmp.right != null)
                stack.push(nodeTmp.right);
            if (nodeTmp.left != null)
                stack.push(nodeTmp.left);
        }
    }

    static int getStackBottom(Stack<Integer> stack) {
        Integer e = stack.pop();
        if (stack.isEmpty()) {
            return e;
        } else {
            int last = getStackBottom(stack);
            stack.push(e);
            return last;
        }
    }

    static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int i = getStackBottom(stack);
        reverseStack(stack);
        stack.push(i);
    }

    static void sortStackDesc(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            if (helpStack.size() == 0) {
                helpStack.push(cur);
            } else if (cur <= helpStack.peek())
                helpStack.push(cur);
            else {
                while (!helpStack.isEmpty()) {
                    stack.push(helpStack.pop());
                }
                helpStack.push(cur);
            }
        }
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }

    }

    /**
     * 滑动窗口最大状态数组
     *
     * @param msg   报文（数组）
     * @param width 报文宽度
     * @return
     */
    static Object[] windowMaxVal(Integer[] msg, Integer width) {
        //维持最大值是队头元素（数组下标），通过记录每次滑动窗口的下标实现
        Deque<Integer> deque = new LinkedList<Integer>();
        List<Integer> l = new LinkedList<Integer>();
        //4,3,5,4,3
        for (int i = 0; i < msg.length; i++) {
            if (deque.isEmpty())
                deque.addLast(i);
            else if (msg[deque.getLast()] >= msg[i]) {
                deque.addLast(i);
            } else {
                Integer popIndex = deque.pollLast();
                while (!deque.isEmpty() && msg[popIndex] < msg[i])
                    popIndex = deque.pollLast();
                deque.push(i);
            }
            if (deque.getFirst().equals(i - width))
                deque.pollFirst();
            if (i >= 2)
                l.add(msg[deque.peekFirst()]);
        }
        return l.toArray();
    }



    static TreeNode maxTree(Integer[] arr){
        TreeNode[] nodes=new TreeNode[arr.length];

        for(int i=0;i<arr.length;i++){
            nodes[i]=new TreeNode(arr[i]);
        }
        //3,4,5,1,2
        HashMap<TreeNode,TreeNode> lBigMap=new HashMap<TreeNode, TreeNode>();
        HashMap<TreeNode,TreeNode> rBigMap=new HashMap<TreeNode, TreeNode>();
        Stack<TreeNode> stack=new Stack<TreeNode>();

        for(int i=0;i<nodes.length;i++){
            if(i==0){
                stack.push(nodes[i]);
                lBigMap.put(nodes[i],null);
            }else if(stack.peek().value>nodes[i].value){
                lBigMap.put(nodes[i],stack.peek());
                stack.push(nodes[i]);
            }else{
                TreeNode tmpNode=stack.pop();
                while(!stack.isEmpty()&&tmpNode.value<nodes[i].value){
                        tmpNode=stack.pop();
                }
                if(tmpNode.value>nodes[i].value) {
                    stack.push(tmpNode);
                    stack.push(nodes[i]);
                    lBigMap.put(nodes[i],tmpNode);
                }else{
                    lBigMap.put(nodes[i], null);
                    stack.push(nodes[i]);
                }
            }
        }

        while (!stack.empty())
            stack.pop();

        for(int i=nodes.length-1;i>=0;i--){
            if(i==nodes.length-1){
                stack.push(nodes[i]);
                rBigMap.put(nodes[i],null);
            }else if(stack.peek().value>nodes[i].value){
                rBigMap.put(nodes[i],stack.peek());
                stack.push(nodes[i]);
            }else{
                TreeNode tmpNode=stack.pop();
                while(!stack.isEmpty()&&tmpNode.value<nodes[i].value){
                    tmpNode=stack.pop();
                }
                if(tmpNode.value>nodes[i].value){
                    stack.push(tmpNode);
                    stack.push(nodes[i]);
                    rBigMap.put(nodes[i],tmpNode);
                }else{
                    rBigMap.put(nodes[i],null);
                    stack.push(nodes[i]);
                }
            }
        }
        TreeNode root=null;
        for(int i=0;i<arr.length;i++){
            TreeNode left=lBigMap.get(nodes[i]);
            TreeNode right=rBigMap.get(nodes[i]);
            if(left==null&&right==null){
                root=nodes[i];
            }else if(left==null){
                if(right.left==null){
                    right.left=nodes[i];
                }else{
                    right.right=nodes[i];
                }
            }else if(right==null){
                if(left.left==null){
                    left.left=nodes[i];
                }else{
                    left.right=nodes[i];
                }
            }else {
                TreeNode parent=left.value<right.value?left:right;
                if(parent.left==null)
                    parent.left=nodes[i];
                else
                    parent.right=nodes[i];
            }
        }
        return root;
    }

    public  static void  main(String[] args){
/*      Tre2=new TreeNode();
        node2.value=2;
        TreeNode node3=neeeNode node1=new TreeNode();
        node1.value=1;
        TreeNode nodw TreeNode();
        node3.value=3;
        node1.left=node2;
        node1.right=node3
        dfsBTree(node1);*/

/*        Special_Stack s=new Special_Stack();
        s.push(2).push(3).push(1);
        s.pop();
        System.out.println(s.getMin());*/

/*        Stack<Integer> stack=new Stack<Integer>();
        stack.push(2);
        stack.push(1);
        stack.push(3);
        //reverseStack(stack);
        sortStackDesc(stack);
        System.out.println(stack.peek());*/

/*        Integer[] a_1={4,3,5,4,3,6};
        Object[] b_1= windowMaxVal(a_1,3);
        System.out.println();*/

        Integer[] a_2={3,4,5,1,2};
        TreeNode b_2= maxTree(a_2);
        System.out.println();

    }
}

class Special_Stack{

    Stack<Integer> stackData=new Stack<Integer>();

    Stack<Integer> stackMin=new Stack<Integer>();

    Special_Stack push(Integer e){
        stackData.push(e);
        if(stackMin.isEmpty())
            stackMin.push(e);
        else
            if(e<=stackMin.peek())
                stackMin.push(e);
        return this;
    }

    void pop(){
        if(stackData.peek().equals(stackMin.peek())){
            stackData.pop();
            stackMin.pop();
        }else
            stackData.pop();

    }

    Integer getMin(){
       return stackMin.peek();
    }
}
class  TwoStackQueue{

}