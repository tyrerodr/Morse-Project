package TDAS;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class BinaryTree<E> {

    private Node<E> root;

    private static class Node<E> {

        E data;
        private Node<E> left;
        private Node<E> right;

        public Node(E data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean add(E child, E parent, String prueba) {
        Node<E> nc = searchNode(child);
        if (nc != null) {
            return false;
        }
        nc = new Node<>(child);
        if (parent == null && root == null) {
            root = nc;
            return true;
        }
        Node<E> np = searchNode(parent);
        if (np != null) {
            if (prueba == "d" && np.left == null) {
                np.left = nc;
                return true;
            } else if (prueba == "i" && np.right == null) {
                np.right = nc;
                return true;
            }
        }
        return false;
    }

    public boolean remove(E child) {
        if (child == null || isEmpty()) {
            return false;
        }
        if (root.data.equals(child)) {
            root = null;
            return true;
        }
        Node<E> np = searchParent(child);
        if (np != null) {
            if (np.left != null && np.left.data.equals(child)) {
                np.left = null;
            } else {
                np.right = null;
            }
            return true;
        }
        return false;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<E> n) {
        if (n == null) {
            return 0;
        }
        return 1 + size(n.left) + size(n.right);
    }

    public int height() { //altura
        return height(root);
    }

    private int height(Node<E> n) {
        if (n == null) {
            return 0;
        }
        return 1 + Math.max(height(n.left), height(n.right));
    }

    public boolean isFull() {
        return isFull(root);
    }

    private boolean isFull(Node<E> n) {
        if (n == null) {
            return true;
        } else if ((n.left == null && n.right != null) || (n.left != null && n.right == null)) {
            return false;
        }
        return height(n.left) == height(n.right) && isFull(n.left) && isFull(n.right);
    }

    //MÉTODOS PROPIOS
    private Node<E> searchNode(E data) {
        return searchNode(data, root);
    }

    private Node<E> searchNode(E data, Node<E> n) {
        if (n == null) {
            return n;
        } else if (n.data.equals(data)) {
            return n;
        } else {
            Node<E> nl = searchNode(data, n.left);
            if (nl != null) {
                return nl;
            }
            return searchNode(data, n.right);
        }
    }

    private Node<E> searchParent(E child) {
        return searchParent(child, root);
    }

    private Node<E> searchParent(E child, Node<E> n) {
        if (n == null) {
            return n;
        } else if ((n.left != null && n.left.data.equals(child)) || (n.right != null && n.right.data.equals(child))) {
            return n;
        } else {
            Node<E> nl = searchParent(child, n.left);
            if (nl != null) {
                return nl;
            }
            return searchParent(child, n.right);
        }
    }

    public void preOrden() {
        preOrden(root);
    }

    private void preOrden(Node<E> n) {
        if (n != null) {
            System.out.println(n.data);
            preOrden(n.left);
            preOrden(n.right);
        }
    }

    public void postOrden() {
        postOrden(root);
    }

    private void postOrden(Node<E> n) {
        if (n != null) {
            postOrden(n.left);
            postOrden(n.right);
            System.out.println(n.data);
        }
    }

    public void inOrden() {
        inOrden(root);
    }

    private void inOrden(Node<E> n) {
        if (n != null) {
            inOrden(n.left);
            System.out.println(n.data);
            inOrden(n.right);
        }
    }

    public List<E> getValuesFromLevels(int ini, int fin) {
        LinkedList<E> list = new LinkedList<>();
        if (ini < 0 || ini > fin) {
            return list;
        }
        return getValuesFromLevels(ini, fin, root, 1);
    }

    private List<E> getValuesFromLevels(int ini, int fin, Node<E> p, int level) {
        LinkedList<E> list = new LinkedList<>();
        if (p == null) {
            return list;
        }
        if (level >= ini && level <= fin) {
            list.add(p.data);
        }
        if (level < fin) {
            list.addAll(getValuesFromLevels(ini, fin, p.left, level + 1));
            list.addAll(getValuesFromLevels(ini, fin, p.right, level + 1));
        }
        return list;
    }

    public E maxLevel(int n) {
        if (n < 0) {
            return null;
        }
        Node<E> maxData = new Node(null);
        Comparator<Integer> f = new Comparator<>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                if (n1 > n2) {
                    return 1;
                } else if (n1 < n2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        return maxLevel(n, root, 1, f, maxData);
    }

    private E maxLevel(int n, Node<E> p, int level, Comparator c, Node<E> maxData) {
        if (p == null) {
            return maxData.data;
        } else if (level == n) {
            return p.data;
        } else if (level < n) {
            E n1 = maxLevel(n, p.left, level + 1, c, p);
            E n2 = maxLevel(n, p.right, level + 1, c, p);
            if (c.compare(n2, n1) > 0) {
                return n2;
            } else {
                return n1;
            }
        }
        return maxData.data;
    }

    public boolean isMirror(BinaryTree<E> other) {
        if (other == null) {
            return false;
        }
        return isMirror(other.root, root);
    }

    public boolean isMirror(Node<E> o, Node<E> p) {
        if (o == null && p == null) {
            return true;
        }
        if ((o == null && p != null) || (o != null && p == null)) {
            return false;
        } else if (!o.data.equals(p.data)) {
            return false;
        }

        return isMirror(o.left, p.right) && isMirror(o.right, p.left);

    }

    public BinaryTree<String> crearArbolMorse(HashMap<String, List<String>> mapa) {
        BinaryTree<String> bt = new BinaryTree<>();
        bt.root = new Node<>("INICIO");
        for (Entry<String, List<String>> e : mapa.entrySet()) {
            Node<String> q = bt.root;
            for (String sim : e.getValue()) {
                if (sim.equals("-")) {
                    if (q.left == null) {
                        q.left = new Node<>(" ");
                    }
                    q = q.left;
                } else {
                    if (q.right == null) {
                        q.right = new Node<>(null);
                    }
                    q = q.right;
                }
            }
            q.data = e.getKey();
        }
        return bt;
    }
}
