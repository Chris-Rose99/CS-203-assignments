// ============================
// Christopher Rose
// CIS 203 Assignment 10, Decoding Morse Code.
// Starter code for creating a Morse code tree.
// ============================
public class MorseCode {
    
    private static int length;
    
    private static TreeNode<Character> codeTree = MorseCode.buildTree();

    // ===========================================
    
    // points toother constructer
    public static Character getLetter(String s) {
	length = s.length();
	return getLetter(codeTree, s, 0);
    }

    // traverses tree for the letter that pertains to the code
    public static Character getLetter(TreeNode<Character> tree, String s, int lvl) {
	if (lvl == length) {
	    return tree.data;
	}
	char letter = s.charAt(lvl);
	if (letter == '-') {
	    return getLetter(tree.right, s, lvl + 1);
	} else {
	    return getLetter(tree.left, s, lvl + 1);
	}
    }
    // ===========================================

    private static TreeNode<Character> buildTree () {
        // build left half
        TreeNode<Character> s =  new TreeNode<Character>('S',
                                                         new TreeNode<Character>('H'),
                                                         new TreeNode<Character>('V'));
        
        TreeNode<Character> u =  new TreeNode<Character>('U',
                                                         new TreeNode<Character>('F'),
                                                         null);
        TreeNode<Character> i =  new TreeNode<Character>('I', s, u);
        
        
        TreeNode<Character> r =  new TreeNode<Character>('R',
                                                         new TreeNode<Character>('L'),
                                                         null);
        
        TreeNode<Character> w =  new TreeNode<Character>('W',
                                                         new TreeNode<Character>('P'),
                                                         new TreeNode<Character>('J'));
        
        TreeNode<Character> a =  new TreeNode<Character>('A', r, w);
        
        
        TreeNode<Character> e =  new TreeNode<Character>('E', i, a);
        
        // build right half
        
        TreeNode<Character> d =  new TreeNode<Character>('D',
                                                         new TreeNode<Character>('B'),
                                                         new TreeNode<Character>('X'));
        
        TreeNode<Character> k =  new TreeNode<Character>('K',
                                                         new TreeNode<Character>('C'),
                                                         new TreeNode<Character>('Y'));
        
        TreeNode<Character> n =  new TreeNode<Character>('N', d, k);
        
        
        TreeNode<Character> g =  new TreeNode<Character>('G',
                                                         new TreeNode<Character>('Z'),
                                                         new TreeNode<Character>('Q'));
        
        TreeNode<Character> o =  new TreeNode<Character>('O');
        
        TreeNode<Character> m =  new TreeNode<Character>('M', g, o);
        
        TreeNode<Character> t =  new TreeNode<Character>('T', n, m);
        
        // build the root
        
        TreeNode<Character> root =  new TreeNode<Character>(null, e, t);
        
        return root;
    }
}
