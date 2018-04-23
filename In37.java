package offerPractice;

/**
 * Created by Meihuan on 2018/4/18.
 */
public class In37 {
    private static int index;

    static String Serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        serializeCore(root,sb);
        //sb.deleteCharAt(sb.length()-1);
        return new String(sb);
    }

    private static void serializeCore(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append('$');
            sb.append(',');
            return;
        }
        sb.append(root.val);
        sb.append(',');
        serializeCore(root.left,sb);
        serializeCore(root.right,sb);
    }

    static TreeNode Deserialize(String str) {
        index = 0;
        return deserializeCore(str);
    }

    private static TreeNode deserializeCore(String str){
        if(str == null || str.length() == 0) return null;
        int j = str.indexOf(',',index);
        if(j == -1) return null;
        String sub = str.substring(index,j);
        index = j + 1;
        if("$".equals(sub)){
            return null;
        }
        int val = Integer.parseInt(sub);
        TreeNode node = new TreeNode(val);
        node.left = deserializeCore(str);
        node.right = deserializeCore(str);
        return node;
    }

    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(11);
        TreeNode n6 = new TreeNode(9);
        TreeNode n5 = new TreeNode(7);
        TreeNode n4 = new TreeNode(5);
        TreeNode n3 = new TreeNode(10,n6,n7);
        TreeNode n2 = new TreeNode(6,n4,n5);
        TreeNode n1 = new TreeNode(8,n2,n3);

        TreeNode s4 = new TreeNode(2);
        TreeNode s3 = new TreeNode(3,s4,null);
        TreeNode s2 = new TreeNode(4,s3,null);
        TreeNode s1 = new TreeNode(5,s2,null);

        /*String str = Serialize(n1);
        System.out.println(str);

        TreeNode head = Deserialize(str);*/

        String str = Serialize(s1);
        System.out.println(str);

        TreeNode head = Deserialize(str);

        System.out.println("hello..");
    }
}
