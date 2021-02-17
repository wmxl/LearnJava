package wmxlUtils;
import java.util.*;

// 给两个List a,b，实现两个List两个List的并集，即合并两个List，重复的元素只保留一个。
// 不可以调用现成的集合方法
// 有空闲限制，a的长度是m，b的长度是n，额外空间最多用m+n (不是O(m+n))
// 尝试优化下，最少的时间复杂度是多少，在代码注释里给出最终的时间复杂度
public class ListUnion {
    static List<Integer> union(List<Integer> a, List<Integer> b) {
        //时间复杂度：O（m+n）
        if(a.size() == 0) return b;
        if(b.size() == 0) return a;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            if(map.containsKey(a.get(i))) continue;
            map.put(a.get(i), 1);
            list.add(a.get(i));
        }
        for (int i = 0; i < b.size(); i++) {
            if(map.containsKey(b.get(i))) continue;
            map.put(b.get(i), 1);
            list.add(b.get(i));
        }
        return list;
    }

    static List<Integer> union2(List<Integer> a, List<Integer> b) {
        //不算排序的时间复杂度：O（max(n,m)）算排序的话，主要是排序的时间复杂度，平均nlogn
        if(a.size() == 0) return b;
        if(b.size() == 0) return a;
        List<Integer> list = new ArrayList<>();

        Collections.sort(a);
        Collections.sort(b);

        int i = 0;
        int j = 0;
        while(i < a.size() && j < b.size()){
            if(i < a.size()-1 && a.get(i) == a.get(i+1)){
                i++;
                continue;
            }
            if(j < b.size()-1 && b.get(j) == b.get(j+1)){
                j++;
                continue;
            }
            if(a.get(i) == b.get(j)){
                list.add(a.get(i));
                i++;
                j++;
            }else if(a.get(i) < b.get(j)){
                list.add(a.get(i));
                i++;
            }else {
                list.add(b.get(j));
                j++;
            }
        }
        if(i == a.size()){
            while(j < b.size()){
                if(j < b.size()-1 && b.get(j) == b.get(j+1)){
                    j++;
                    continue;
                }
                list.add(b.get(j));
                j++;
            }
        }
        if(j == b.size()){
            while(i < a.size()){
                if(i < a.size()-1 && a.get(i) == a.get(i+1)){
                    i++;
                    continue;
                }
                list.add(a.get(i));
                i++;
            }
        }
        return list;
    }

    static List<Integer> union3(List<Integer> a, List<Integer> b) {
        //不算排序的时间复杂度：O（n+m）
        //时间复杂度：O（m+n）
        if(a.size() == 0) return b;
        if(b.size() == 0) return a;
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            if(set.contains(a.get(i))) continue;
            set.add(a.get(i));
            list.add(a.get(i));
        }
        for (int i = 0; i < b.size(); i++) {
            if(set.contains(b.get(i))) continue;
            set.add(b.get(i));
            list.add(b.get(i));
        }
        return list;
    }

    static List<Integer> union4(List<Integer> a, List<Integer> b) {
        //不算排序的时间复杂度：O（n+m）
        //时间复杂度：O（m+n）
        if(a.size() == 0) return b;
        if(b.size() == 0) return a;
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            if(set.contains(a.get(i))) continue;
            set.add(a.get(i));
            list.add(a.get(i));
        }
        for (int i = 0; i < b.size(); i++) {
            if(set.contains(b.get(i))) continue;
            set.add(b.get(i));
            list.add(b.get(i));
        }
        return list;
    }
    public static void main(String[] args) {
        // union([ 2, 1, 3], [ 2, 3, 4]) ==  [1, 2, 3, 4]
        System.out.println(union4(Arrays.asList(2,1,3), Arrays.asList(2,3,4)));
    }
}