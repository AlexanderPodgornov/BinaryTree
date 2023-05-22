import java.util.Stack;

public class BinarTree implements BT{
    Node root;
    public BinarTree() {
        root = null;
    }
    public int getHeight(Node temp) {
        if (temp == null)
            return 0;
        else
            return 1 + Math.max(getHeight(temp.left), getHeight(temp.right));
    }
    @Override
    public void add(int value) {
        Node n = new Node();
        n.data = value;
        Node temp = root;
        if (root == null)
            root = n;
        else
        {
            Node parent;
            while(true)
            {
                parent = temp;
                if(n.data < temp.data)
                {
                    temp  = temp.left;
                    if(temp == null)
                    {
                        parent.left = n;
                        return;
                    }
                }
                else if(n.data > temp.data)
                {
                    temp = temp.right;
                    if(temp == null)
                    {
                        parent.right = n;
                        return;
                    }
                }
                else
                    throw new NullPointerException("НЕЛЬЗЯ ДОБАВЛЯТЬ СУЩЕСТВУЮЩИЙ ЭЛЕМЕНТ");
            }
        }
    }

    @Override
    public boolean search(int value) {
        if (root == null)
            throw new NullPointerException("БИНАРНОЕ ДЕРЕВО ПУСТО");
        Node temp = root;
        while (temp != null)
        {
            if (temp.data == value)
                return true;
            if (temp.data < value)
                temp = temp.right;
            else temp = temp.left;
        }
        return false;
    }
    /*public Node findForReplace(Node t)
    {
        Node parPar = t;
        Node temp =  t.right;
        Node parent = temp;
        while (temp != null)
        {
            parent = temp;
            temp = temp.left;
        }
        return parent;
    }*/
    public Node findForReplace(Node t) {
        Node parPar = t;
        Node parent = t;
        Node temp = t.right;
        while (temp != null) {
            parPar = parent;
            parent = temp;
            temp = temp.left;
        }
        if (parent != t.right) {
            parPar.left = parent.right;
            parent.right = t.right;
        }
        return parent;
    }
    @Override
    public void delete(int value) {
        if (root == null)
            throw new NullPointerException("БИНАРНОЕ ДЕРЕВО ПУСТО");
        Node temp = root;
        Node parent = root;
        // находим нужный элемент
        while (temp != null)
        {
            if (temp.data == value)
                break;
            parent = temp;
            if (temp.data < value)
                temp = temp.right;
            else temp = temp.left;
        }
        //
        if (temp == null)
            throw new NullPointerException("ЭЛЕМЕНТА В ДЕРЕВЕ НЕТ");
        if (temp.right == null && temp.left == null) // если элемент - лист дерева
        {
            //System.out.println(parent.data);
            if (temp == root) // если дерево состоит только из корня
                root = null;
            else if (parent.left.data == value)
                parent.left = null;
            else if (parent.right.data == value)
                parent.right = null;
        }
        else if (temp.right == null) // если только левая ветвь
        {
            if (temp == root) // если дерево состоит только из корня
                root = temp.left;
            else if (parent.left.data == value)
                parent.left = temp.left;
            else parent.right = temp.left;
        }
        else if (temp.left == null) // если только правая ветвь
        {
            if (temp == root) // если дерево состоит только из корня
                root = temp.right;
            else if (parent.left.data == value)
                parent.left = temp.right;
            else parent.right = temp.right;
        }
        else // если 2 ветви
        {
            //System.out.println(findForDelete(temp).data);//
            Node rep = findForReplace(temp);
            if (temp == root) // если дерево состоит только из корня
                root = rep;
            else if (parent.left.data == value)
                parent.left = rep;
            else parent.right = rep;
            rep.left = temp.left;
        }
    }


    @Override
    public int findMin() {
        if (root == null)
            throw new NullPointerException("БИНАРНОЕ ДЕРЕВО ПУСТО");
        Node temp = root;
        Node parent = root;
        while (temp != null)
        {
            parent = temp;
            temp = temp.left;
        }
        return parent.data;
    }

    @Override
    public int findMax() {
        if (root == null)
            throw new NullPointerException("БИНАРНОЕ ДЕРЕВО ПУСТО");
        Node temp = root;
        Node parent = root;
        while (temp != null)
        {
            parent = temp;
            temp = temp.right;
        }
        return parent.data;
    }
    @Override
    public Node findNode()
    {
        return root;
    }
    @Override
    public void obhodP(Node root)
    {
        if(root != null)
        {
            System.out.print(root.data + " ");
            obhodP(root.left);
            obhodP(root.right);
        }
    }
    @Override
    public void obhodS(Node root)
    {
        if(root != null)
        {
            obhodS(root.left);
            System.out.print(root.data + " ");
            obhodS(root.right);
        }
    }
    @Override
    public void obhodO(Node root)
    {
        if(root != null)
        {
            obhodO(root.left);
            obhodO(root.right);
            System.out.print(root.data + " ");
        }

    }
    public void print() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int space = (int) Math.pow(2, getHeight(root));
        boolean isRowEmpty = false;
        System.out.println();
        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;
            for (int i = 0; i < space; i++) {
                System.out.print(' ');
            }
            while (!globalStack.isEmpty()) {
                Node temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getData());
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if (temp.left != null || temp.right != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i = 0; i < space * 2 - 2; i++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            space /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }
        System.out.println();
    }
}
