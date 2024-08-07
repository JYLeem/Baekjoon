import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Tree> map = new HashMap<>();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char rootVal = st.nextToken().charAt(0);
            char leftVal = st.nextToken().charAt(0);
            char rightVal = st.nextToken().charAt(0);

            Tree root = map.getOrDefault(rootVal, new Tree(rootVal));
            map.put(rootVal, root);

            if (leftVal != '.') {
                Tree left = new Tree(leftVal);
                root.left = left;
                map.put(leftVal, left);
            }
            if (rightVal != '.') {
                Tree right = new Tree(rightVal);
                root.right = right;
                map.put(rightVal, right);
            }
        }

        Tree root = map.get('A');

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    static class Tree {
        char val;
        Tree left;
        Tree right;

        Tree(char val) {
            this.val = val;
        }
    }

    static void preOrder(Tree node) {
        if (node != null) {
            System.out.print(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    static void inOrder(Tree node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val);
            inOrder(node.right);
        }
    }

    static void postOrder(Tree node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val);
        }
    }
}
