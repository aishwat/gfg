package com.dynamic;


public class PalindromicTree {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static int MAXN = 1000;

    static class Node {
        // store start and end indexes of current
        // Node inclusively
        int start, end;

        // stores length of substring
        int length;

        // stores insertion Node for all characters a-z
        int insertEdg[] = new int[26];

        // stores the Maximum Palindromic Suffix Node for
        // the current Node
        int suffixEdg; //index of that node
    }

    static Node root1 = new Node();
    static Node root2 = new Node();

    // stores Node information for constant time access
    static Node tree[] = new Node[MAXN];

    // Keeps track the current Node while insertion
    static int currNode;
    static char s[];
    static int ptr;

    static void insert(int idx) {
        //STEP 1//

    /* search for Node X such that s[idx] X S[idx]
       is maximum palindrome ending at position idx
       iterate down the suffix link of currNode to
       find X */
        System.out.println(ANSI_PURPLE + "idx: " + idx + " char: " + s[idx] + " currNode: " + currNode + " ptr: " + ptr + ANSI_RESET);
//        System.out.println();

        int tmp = currNode;
        while (true) {
            System.out.printf(ANSI_BLUE);
            System.out.println("\tin while");
            int curLength = tree[tmp].length;

            System.out.println("\t" + "tmp: " + tmp + " curLength: " + curLength);
            System.out.println("\t(idx - curLength): " + (idx - curLength));
            if (idx - curLength >= 1)
                System.out.println("\ts[idx]: " + s[idx] + " s[idx - curLength - 1]: " + s[idx - curLength - 1]);

            if (idx - curLength >= 1 && s[idx] == s[idx - curLength - 1]) //failsafe s[-ive]
                break;
            tmp = tree[tmp].suffixEdg;
            System.out.println("\ttmp: " + tmp);
        }
        System.out.printf(ANSI_RESET);

        /* Now we have found X ....
         * X = string at Node tmp
         * Check : if s[idx] X s[idx] already exists or not*/
//        System.out.println("tree[tmp].insertEdg[s[idx] - 'a'] != 0");
//        System.out.println("tree[" + tmp + "].insertEdg[" + (s[idx] - 'a') + "] => " + (tree[tmp].insertEdg[s[idx] - 'a']));
        //if not 0, ie exists and just updates curNode
        if (tree[tmp].insertEdg[s[idx] - 'a'] != 0) {
            // s[idx] X s[idx] already exists in the tree
            currNode = tree[tmp].insertEdg[s[idx] - 'a'];
            System.out.println(ANSI_YELLOW + "updating curNode to: " + currNode + ANSI_RESET);
            return;
        }

        // creating new Node
        ptr++;

        // making new Node as child of X with
        // weight as s[idx]
        System.out.println(ANSI_RED);
        tree[tmp].insertEdg[s[idx] - 'a'] = ptr;
        System.out.println("tree[tmp].insertEdg[s[idx] - 'a'] = ptr");
        System.out.println("tree[" + tmp + "].insertEdg[" + (s[idx] - 'a') + "] = " + ptr);

        // calculating length of new Node
        tree[ptr].length = tree[tmp].length + 2;
        System.out.println("\ntree[ptr].length = tree[tmp].length + 2");
        System.out.println("tree[" + ptr + "].length = " + (tree[tmp].length + 2));

        // updating end point for new Node
        tree[ptr].end = idx;
        System.out.println("\ntree[ptr].end = idx");
        System.out.println("tree[" + ptr + "].end = " + idx);

        // updating the start for new Node
        tree[ptr].start = idx - tree[ptr].length + 1;
        System.out.println("\ntree[ptr].start = idx - tree[ptr].length + 1");
        System.out.println("tree[" + ptr + "].start = " + (idx - tree[ptr].length + 1));


//STEP 2//

    /* Setting the suffix edge for the newly created
       Node tree[ptr]. Finding some String Y such that
       s[idx] + Y + s[idx] is longest possible
       palindromic suffix for newly created Node.*/


        System.out.println("\ntmp = tree["+tmp+"].suffixEdg");
        System.out.println("tmp =" + tree[tmp].suffixEdg);
        tmp = tree[tmp].suffixEdg;

        // making new Node as current Node
        currNode = ptr;
        System.out.println("currNode=" + ptr);
        System.out.println(ANSI_RESET);


        System.out.println(ANSI_CYAN + "tree[currNode].length=" + tree[currNode].length);
        if (tree[currNode].length == 1) {
            // if new palindrome's length is 1
            // making its suffix link to be null string
            tree[currNode].suffixEdg = 2;
            System.out.println(ANSI_YELLOW + "tree[currNode].suffixEdg = 2");
            System.out.println("=============================" + ANSI_RESET);
            return;
        }

        while (true) {
            System.out.println(ANSI_GREEN + "\tin 2nd while");
            int curLength = tree[tmp].length;
            System.out.println("\t" + "tmp: " + tmp + " curLength: " + curLength);
            System.out.println("\t(idx - curLength): " + (idx - curLength));
            if (idx - curLength >= 1)
                System.out.println("\ts[idx]: " + s[idx] + " s[idx - curLength - 1]: " + s[idx - curLength - 1]);

            if (idx - curLength >= 1 && s[idx] == s[idx - curLength - 1])
                break;
            tmp = tree[tmp].suffixEdg;
            System.out.println("\ttmp: " + tmp);
            System.out.println(ANSI_RESET);
        }

        // Now we have found string Y
        // linking current Nodes suffix link with s[idx]+Y+s[idx]
        tree[currNode].suffixEdg = tree[tmp].insertEdg[s[idx] - 'a'];
        System.out.println(ANSI_BLACK + "tree[currNode].suffixEdg = tree[tmp].insertEdg[s[idx] - 'a']");
        System.out.println("tree["+currNode+"].suffixEdg = tree["+tmp+"].insertEdg["+(s[idx] - 'a')+"]");
        System.out.println("tree["+currNode+"].suffixEdg = "+tree[tmp].insertEdg[s[idx] - 'a']);
        System.out.println("=============================" + ANSI_RESET);
    }

    public static void main(String[] args) {
        root1.length = -1;
        root1.suffixEdg = 1;
        root2.length = 0;
        root2.suffixEdg = 1;

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }
        tree[1] = root1;
        tree[2] = root2;
        ptr = 2;
        currNode = 1;


        // given string
        String s_ = "abba";
        s = s_.toCharArray();
        int l = s.length;

        for (int i = 0; i < l; i++) {
            insert(i);
            System.out.println();
        }


        // printing all of its distinct palindromic
        // substring
        System.out.println("All distinct palindromic substring for " + s_ + ":");

        for (int i = 3; i <= ptr; i++) {
            System.out.printf(i + ")");
            for (int j = tree[i].start; j <= tree[i].end; j++)
                System.out.printf("%s", s[j]);
            System.out.println();
        }

    }

}
