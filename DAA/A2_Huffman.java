package DAA;
import java.util.*;
public class A2_Huffman {
    static Scanner sc = new Scanner(System.in);
    static class Node {
        char alpha;
        int freq;
        Node l, r;
        Node(char a, int f) {
            this.alpha = a;
            this.freq = f;
            this.l = this.r = null;
        }
    }
    public static void printCodes(Node temp, String str, HashMap<Character, String> hm) {
        if(temp == null) {
            return;
        }
        if(temp.alpha != '$') {
            hm.put(temp.alpha, str);
            System.out.println(temp.alpha+" : "+str);
        }
        printCodes(temp.l, str+"0", hm);
        printCodes(temp.r, str+"1", hm);
    }
    public static String encodeString(String input, HashMap<Character, String> hm) {
        String ans = "";
        for (int i=0; i<input.length(); i++) {
            ans += hm.get(input.charAt(i));
        }
        return ans;
    }
    public static void BuildTree(ArrayList<Node> l) {
        while (l.size() > 1) {
            Collections.sort(l, (a, b) -> a.freq - b.freq);
            Node one = l.remove(0);
            Node two = l.remove(0);
            Node newNode = new Node('$', one.freq + two.freq);
            newNode.l = one;
            newNode.r = two;
            l.add(newNode);
        }
    }
    public static void main(String []args) {
        System.out.print("\nEnter the number of character : ");
        int n = sc.nextInt();
        ArrayList<Node> lst = new ArrayList<>();
        System.out.println("Enter the character and the frequency of each character");
        for(int i = 0; i < n; i++) {
            lst.add(new Node(sc.next().charAt(0), sc.nextInt()));
        }
        BuildTree(lst);
        HashMap<Character, String> hm = new HashMap<>();
        printCodes(lst.get(0), "", hm);
        System.out.print("Enter the String that is to be encoded : ");
        String str = sc.next();
        str = encodeString(str, hm);
        System.out.println(str);
    }
}
// h : 2
// e : 4
// l : 6
// l : 8
// o : 10

// l : 00
// h : 010
// e : 011
// l : 10
// o : 11
// e : 011
// Enter the String that is to be encoded : hello
// 010 011 10 10 11
// h   e   l  l  o