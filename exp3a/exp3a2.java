import java.util.TreeSet;

public class exp3a2 {

    public static TreeSet<Integer> mergeTreeSets(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> mergedSet = new TreeSet<>(set1);
        mergedSet.addAll(set2);
        return mergedSet;
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet1 = new TreeSet<>();
        treeSet1.add(1);
        treeSet1.add(3);
        treeSet1.add(5);

        TreeSet<Integer> treeSet2 = new TreeSet<>();
        treeSet2.add(2);
        treeSet2.add(3);
        treeSet2.add(4);

        System.out.println("TreeSet 1: " + treeSet1);
        System.out.println("TreeSet 2: " + treeSet2);

        TreeSet<Integer> mergedSet = mergeTreeSets(treeSet1, treeSet2);
        System.out.println("Merged TreeSet: " + mergedSet);
    }
}
