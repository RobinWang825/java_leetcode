package BinaryTree;

public class JZ37_serialize_LC297 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode nodeleft = new TreeNode(2);
        TreeNode noderight = new TreeNode(3);
        TreeNode nodeleftleft = new TreeNode(4);
        TreeNode noderightleft = new TreeNode(2);
        TreeNode noderightleftleft = new TreeNode(4);
        TreeNode noderightright = new TreeNode(4);
        root.left = nodeleft;
        root.right = noderight;
        nodeleft.left = nodeleftleft;
        noderight.right = noderightright;
        noderight.left = noderightleft;
        noderightleft.left = noderightleftleft;
        Codec ser = new Codec();
        Codec deser = new Codec();
        String serializeStr = ser.serialize(root);// 1 2 4 # # # 3 2 4 # # # 4 # #
        TreeNode ans = deser.deserialize(serializeStr);
        System.out.println(serializeStr);
    }
}

class Codec {
    private String deserializeStr;
    // Encodes a tree to a single string.  序列化
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    // Decodes your encoded data to tree.  反序列化
    public TreeNode deserialize(String data) {
        deserializeStr = data;
        return deserialize();

    }

    public TreeNode deserialize() {
        if (deserializeStr.length() == 0) return null;
        int index = deserializeStr.indexOf(" ");
        String node = (index == -1) ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = (index == -1) ? "" : deserializeStr.substring(index + 1);

        if (node.equals("#")) {
            return null;
        }

        int val = Integer.valueOf(node).intValue(); // String转int
        TreeNode t = new TreeNode(val);
        t.left = deserialize();
        t.right = deserialize();
        return t;
    }
}