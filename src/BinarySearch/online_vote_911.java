package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class online_vote_911 {

    public static void main(String[] args) {
        int [] persons = {0, 1, 1, 0, 0, 1, 0};
        int [] times = {0, 5, 10, 15, 20, 25, 30};

        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons, times);
//        System.out.println(topVotedCandidate.tops);//[0, 1, 1, 0, 0, 1, 0]
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(15));
        System.out.println(topVotedCandidate.q(24));
        System.out.println(topVotedCandidate.q(8));

    }

    private static class TopVotedCandidate {
        List<Integer> tops;
        Map<Integer, Integer> voteCounts;
        int[] times;
        public TopVotedCandidate(int[] persons, int[] times) {
            tops = new ArrayList<Integer>();
            voteCounts = new HashMap<Integer, Integer>();
            voteCounts.put(-1, -1); // 初始化为-1
            // 用哈希表存储，每个时刻，每个候选者有多少票
//            System.out.println("vote counts: "+voteCounts); // vote counts: {-1=-1}
            int top = -1;
            for (int i = 0; i < persons.length; ++i) {
                int p = persons[i];
                // getOrDefault: 返回 key 相映射 的 value，如果给定的 key 在映射关系中找不到，则返回指定的默认值。
                voteCounts.put(p, voteCounts.getOrDefault(p, 0) + 1); // 候选者＋1票
                if (voteCounts.get(p) >= voteCounts.get(top)) {
                    top = p; // 领先的候选者；平票的时候，选最新的
                }
//                System.out.println("vote counts: "+voteCounts);
                //vote counts: {-1=-1, 0=1, 1=1}
                //vote counts: {-1=-1, 0=4, 1=3}  某一时刻，第0个人和第1个人的票数
                tops.add(top);  // 在领先者列表tops里面添加 当前times的  领先者
            }
            this.times = times;
        }
        public int q(int t) {
            //返回t时刻的最高票候选者的编号。
            // 二分查找
            int l = 0, r = times.length - 1;
            // 找到满足 times[l] <= t 的最大的 l
            while (l < r) {
                int m = l + (r - l + 1) / 2;
                if (times[m] <= t) {
                    l = m;
                } else {
//                    r = m;
                    r = m - 1;
                }
            }
            return tops.get(l);

        }
    }



}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */