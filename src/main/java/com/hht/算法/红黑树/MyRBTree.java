package com.hht.算法.红黑树;

public class MyRBTree<T extends Comparable<T>> {

    private RBTNode<T> mRoot;    // 根结点

    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    @SuppressWarnings("hiding")
	public class RBTNode<T extends Comparable<T>> {
        boolean color;        // 颜色
        T key;                // 关键字(键值)
        RBTNode<T> left;    // 左孩子
        RBTNode<T> right;    // 右孩子
        RBTNode<T> parent;    // 父结点

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

    }
    
    
    /**
     * 对X节点进行左旋
     * 
     */
    public void leftRotate(RBTNode<T> x) {
    	// 1. 左旋就先取右孩子，进行保存，避免被覆盖
    	RBTNode<T> y = x.right;
    	
    	// 2. X和β对接
    	x.right = y.left;
    	if(y.left != null) {
    		y.left.parent = x;
    	}
    	
    	// 3. y和X的父类对接
    	y.parent = x.parent;
    	if(x.parent == null) {
    		// 如果X的父类是null， 说明X是根节点，现在要把Y设为根节点
    		this.mRoot = y;
    	} else {
    		// 如果不是根节点， 则要判断y是设为左节点，还是右节点
    		if(x.parent.left == x) {// 为左节点
    			x.parent.left = y;
    		}else {
    			x.parent.right = y;	// 为右节点
    		}
    	}
    	
    	// 4. X和Y对接
    	y.left = x;
    	x.parent = y;
    	
    }
    
    /**
     * 对y节点进行右旋
     * 
     */
    public void rightRotate(RBTNode<T> y) {
    	// 1. 右旋就先取左孩子，进行保存，避免被覆盖
    	RBTNode<T> x = y.left;
    	
    	// 2. y和β对接
    	y.left = x.right;
    	if(x.right != null) {
    		x.right.parent = y;
    	}
    	
    	// 3. X和Y的父类对接
    	x.parent = y.parent;
    	if(y.parent == null) {
    		// 如果y的父类是null， 说明y是根节点，现在要把x设为根节点
    		this.mRoot = x;
    	}else {
    		// 如果不是根节点， 则要判断x是设为左节点，还是右节点
    		if(y.parent.left == y) {
    			y.parent.left = x;	// 为左节点
    		} else {
    			y.parent.right = x;	// 为右节点
    		}
    	}
    	
    	// 4. x和y对接
    	x.right = y;
    	y.parent = x;
    
    }
    
    private void insert(RBTNode<T> node) {
    	int cmp; 
    	RBTNode<T> x = this.mRoot;
    	RBTNode<T> y = null;
    	
    	// 1. 将红黑树当作一颗二叉查找树，将节点添加到二叉查找树中
    	while(x != null) {
    		y = x;
    		cmp = node.key.compareTo(x.key);
    		if(cmp < 0) {
    			x = x.left;
    		} else {
    			x = x.right;
    		}
    	}
    	
    	node.parent = y;
    	if(y == null) {
    		this.mRoot = node;
    	}else {
    		cmp = node.key.compareTo(y.key);
    		if(cmp < 0) {
    			y.left = node;
    		} else {
    			y.right = node;
    		}
    	}
    	
    	// 2. 设置节点的颜色为红色
    	node.color = RED;
    	
    	// 3. 将它重新修正为一颗二叉查找树
    	insertFixUp(node);
    	
    	
    	
    }
    
    /**
     * 新建结点(key)，并将其插入到红黑树中
     * 
     */
    public void insert(T key) {
    	RBTNode<T> node = new RBTNode<T>(key, BLACK, null, null, null);
    	insert(node);
    }
    
    /**
     * 红黑树插入修正函数
     * 
     * 在向红黑树中插入节点之后(失去平衡)，再调用该函数；
     * 目的是将它重新塑造成一颗红黑树。
     * 
     * 自己的总结：
     * 		1. 父、叔都是红色，直接将父、叔设置“黑”，爷设置“红”，  node指向爷继续循环。
     * 		2. 父红、叔黑，就需要判断爷、父、子是不是3个一条左斜线或右斜线。
     * 			A. 如果非一条斜线，爷、父、子为左左右，则父左旋， 父子变量互换。结果就变为一条斜线。
     * 			B. 如果非一条斜线，爷、父、子为右右左，则父右旋， 父子变量互换。结果就变为一条斜线。
     * 			C. 一条斜线： 左斜 ：父设置为“黑”，爷设置为“红”， 爷右旋
     * 						 右斜 ：父设置为“黑”，爷设置为“红”， 爷左旋
     */
	private void insertFixUp(RBTNode<T> node) {
		RBTNode<T> parent, gparent;

		// 若“父节点存在，并且父节点的颜色是红色”
		while ( (parent = parentOf(node)) != null && !parent.color) {
			gparent = parent.parent;

			// 若“父节点”是“祖父节点的左孩子”
			if (parent == gparent.left) {
				// Case 1条件：叔叔节点是红色
				RBTNode<T> uncle = gparent.right;
				if ((uncle != null) && !uncle.color) {
					uncle.color = BLACK;
					parent.color = BLACK;
					gparent.color = RED;
					node = gparent;
					continue;
				}

				// Case 2条件：叔叔是黑色，且当前节点是右孩子
				if (parent.right == node) {
					RBTNode<T> tmp;
					leftRotate(parent);
					tmp = parent;
					parent = node;
					node = tmp;
				}

				// Case 3条件：叔叔是黑色，且当前节点是左孩子。
				parent.color = BLACK;
				gparent.color = RED;
				rightRotate(gparent);
			} else { // 若“z的父节点”是“z的祖父节点的右孩子”
				// Case 1条件：叔叔节点是红色
				RBTNode<T> uncle = gparent.left;
				if ((uncle != null) && !uncle.color) {
					uncle.color = BLACK;
					parent.color = BLACK;
					gparent.color = RED;
					node = gparent;
					continue;
				}

				// Case 2条件：叔叔是黑色，且当前节点是左孩子
				if (parent.left == node) {
					RBTNode<T> tmp;
					rightRotate(parent);
					tmp = parent;
					parent = node;
					node = tmp;
				}

				// Case 3条件：叔叔是黑色，且当前节点是右孩子。
				parent.color = BLACK;
				gparent.color = RED;
				leftRotate(gparent);
			}
		}

		// 将根节点设为黑色
		this.mRoot.color = BLACK;
	}
    
    
    
    
    
    
    
    
    
	
	
	

    private RBTNode<T> parentOf(RBTNode<T> node) {
        return node!=null ? node.parent : null;
    }

    /*
     * 前序遍历"红黑树"
     */
    private void preOrder(RBTNode<T> tree) {
        if(tree != null) {
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    /*
     * 中序遍历"红黑树"
     */
    private void inOrder(RBTNode<T> tree) {
        if(tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key+" ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }


    /*
     * 后序遍历"红黑树"
     */
    private void postOrder(RBTNode<T> tree) {
        if(tree != null)
        {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key+" ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }


    /*
     * (递归实现)查找"红黑树x"中键值为key的节点
     */
    private RBTNode<T> search(RBTNode<T> x, T key) {
        if (x==null)
            return x;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public RBTNode<T> search(T key) {
        return search(mRoot, key);
    }

    /*
     * (非递归实现)查找"红黑树x"中键值为key的节点
     */
    private RBTNode<T> iterativeSearch(RBTNode<T> x, T key) {
        while (x!=null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0) 
                x = x.left;
            else if (cmp > 0) 
                x = x.right;
            else
                return x;
        }

        return x;
    }

    public RBTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /* 
     * 查找最小结点：返回tree为根结点的红黑树的最小结点。
     */
    private RBTNode<T> minimum(RBTNode<T> tree) {
        if (tree == null)
            return null;

        while(tree.left != null)
            tree = tree.left;
        return tree;
    }

    public T minimum() {
        RBTNode<T> p = minimum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }
     
    /* 
     * 查找最大结点：返回tree为根结点的红黑树的最大结点。
     */
    private RBTNode<T> maximum(RBTNode<T> tree) {
        if (tree == null)
            return null;

        while(tree.right != null)
            tree = tree.right;
        return tree;
    }

    public T maximum() {
        RBTNode<T> p = maximum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /* 
     * 找结点(x)的后继结点。即，查找"红黑树中数据值大于该结点"的"最小结点"。
     */
    public RBTNode<T> successor(RBTNode<T> x) {
        // 如果x存在右孩子，则"x的后继结点"为 "以其右孩子为根的子树的最小结点"。
        if (x.right != null)
            return minimum(x.right);

        // 如果x没有右孩子。则x有以下两种可能：
        // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
        // (02) x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"。
        RBTNode<T> y = x.parent;
        while ((y!=null) && (x==y.right)) {
            x = y;
            y = y.parent;
        }

        return y;
    }
     
    /* 
     * 找结点(x)的前驱结点。即，查找"红黑树中数据值小于该结点"的"最大结点"。
     */
    public RBTNode<T> predecessor(RBTNode<T> x) {
        // 如果x存在左孩子，则"x的前驱结点"为 "以其左孩子为根的子树的最大结点"。
        if (x.left != null)
            return maximum(x.left);

        // 如果x没有左孩子。则x有以下两种可能：
        // (01) x是"一个右孩子"，则"x的前驱结点"为 "它的父结点"。
        // (01) x是"一个左孩子"，则查找"x的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是"x的前驱结点"。
        RBTNode<T> y = x.parent;
        while ((y!=null) && (x==y.left)) {
            x = y;
            y = y.parent;
        }

        return y;
    }


    /*
     * 打印"红黑树"
     *
     * key        -- 节点的键值 
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(RBTNode<T> tree, T key, int direction) {

        if(tree != null) {

            if(direction==0)    // tree是根节点
                System.out.printf("%2d(B) is root\n", tree.key);
            else                // tree是分支节点
                System.out.printf("%2d(%s) is %2d's %6s child\n", tree.key, tree.color?"R":"B", key, direction==1?"right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right,tree.key,  1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }
    


    /*
     * 销毁红黑树
     */
    private void destroy(RBTNode<T> tree) {
        if (tree==null)
            return ;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree=null;
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }
    
    
    
    
    
    

    
}
