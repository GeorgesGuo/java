package Tree;

import java.util.*;

public class TestBinaryTree{

    class Node{
        char value;
        Node left;
        Node right;
        public Node(char value){
            this.value=value;
        }
    }
    //二叉树的前序遍历
    void binaryTreePrevOrder(Node root){
        if (root==null){
            return;
        }
        System.out.print(root.value+" ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.right);

    }
    //二叉树的中序遍历
    void binaryTreeInOrder(Node root){
        if (root==null){
            return;
        }
        binaryTreeInOrder(root.left);
        System.out.print(root.value+" ");
        binaryTreeInOrder(root.right);

    }
    //二叉树的后序遍历
    void binaryTreePostOrder(Node root){
        if (root==null){
            return;
        }
        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
        System.out.print(root.value+" ");

    }
    //二叉树的前序遍历非递归
    void binaryTreePrevOrderNonR(Node root){
        Stack<Node>stack =new Stack<>();
        Node cur = root;
        Node top = null;
        while (cur!=null||!stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            System.out.print(cur.value + " ");
            cur = top.right;
        }
    }
    //二叉树的中序遍历非递归
    void binaryTreeInOrderNonR(Node root){
        Stack<Node>stack=new Stack<>();
        Node cur = root;
        Node top = null;
        while (cur!=null||!stack.empty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur =stack.pop();

        }
    }

    //二叉树的后序遍历非递归
   void binaryTreePostOrderNonR(Node root){
       Stack<Node>stack=new Stack<>();
       //List<Integer>list = new ArrayList<>();
       Node cur = root;
       Node prev = null;
       while (cur!=null||!stack.empty()){
           while (cur!=null){
               stack.push(cur);
               cur=cur.left;
           }
           cur =stack.peek();
          if(cur.right ==null||cur.right==prev){
              stack.pop();
              System.out.print(cur.value+" ");//
              //list.add(cur.value);
              prev = cur;
              cur = null;
          }else {
              cur = cur.right;
          }
       }
       //return list;
   }
    public int i = 0;
    //根据字符串创建二叉树
    Node createTestTree(String s){
        Node root = null;
        if(s.charAt(i)!='#'){
            root = new Node(s.charAt(i));
            i++;
            root.left = createTestTree(s);
            root.right = createTestTree(s);
        }else {
            i++;
        }
        return root;
    }
    // 结点个数
    int getSize(Node root){
        if(root==null){
            return 0;
        }
        return getSize(root.left)+getSize(root.right)+1;
    }
    // 叶子结点个数
    int getLeafSize(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return getLeafSize(root.left)+getLeafSize(root.right);
    }
    // 第 k 层结点个数
    int getKLevelSize(Node root, int k){
        if(root==null){
            return 0;
        }else if(k==1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }
    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，
    // 如果找到，返回结点，否则返回 null
    Node find(Node root, int value){
        if(root==null){
            return null;
        }
        if(root.value == value){
            return root;
        }
        Node ret = find(root.left,value);
        if(ret!=null){
            return ret;
        }
        ret = find(root.right,value);
        if(ret!=null){
            return ret;
        }
        return null;
    }
    //二叉树的高度
    int height(Node root){
        if(root==null){
            return 0;
        }else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return leftHeight>rightHeight ?leftHeight+1:rightHeight+1;
        }
    }

    //二叉树的层序遍历
    void binaryTreeLevelOrder(Node root){
        Queue<Node>queue = new LinkedList<>();
        if(root !=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            //拿到队头元素 将队头元素的左右子树入队
            Node cur = queue.poll();
            System.out.print(cur.value+" ");
            //不为空的时候才能入队
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right !=null){
                queue.offer(cur.right);
            }
        }
    }
    //判断一棵树是否是完全二叉树 返回0代表是完全二叉树
    int binaryTreeComplete(Node root){
        Queue<Node>queue = new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            Node top = queue.poll();
            if(top!= null){
                queue.offer(top.left);
                queue.offer(top.right);
            }else {
                break;
            }
        }
        while (!queue.isEmpty()){
            Node cur =queue.peek();
            if(cur != null){
                return -1;
            }else {
                queue.poll();
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        TestBinaryTree testBinaryTree = new TestBinaryTree();
        TestBinaryTree.Node root =testBinaryTree.createTestTree("abc##de#g##f###");
        testBinaryTree.binaryTreePrevOrder(root);
        System.out.println();
        testBinaryTree.binaryTreePostOrder(root);
        System.out.println();
        testBinaryTree.binaryTreeInOrder(root);
        System.out.println();
        System.out.println(testBinaryTree.getKLevelSize(root,2));
        System.out.println(testBinaryTree.getLeafSize(root));
        System.out.println(testBinaryTree.getSize(root));
        System.out.println(testBinaryTree.find(root,'z').value);

    }
}
