import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<obj> data = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        for (int i=0; i<plans.length; i++) {
            data.add(new obj(plans[i][0], time(plans[i][1]), Integer.parseInt(plans[i][2])));
        }
        Deque<obj> stack = new ArrayDeque<>();
        int idx = 0;
        while (!data.isEmpty()) {
            obj out = data.remove();
            if(!data.isEmpty()) {
                int diff_time = data.peek().time - out.time;
                System.out.println(diff_time);
                if(diff_time >= out.remain) {
                    answer[idx++] = out.subject;
                    diff_time -= out.remain;
                    while (!stack.isEmpty()) {
                        obj other = stack.pop();
                        if (other.remain > diff_time) {
                            other.remain -= diff_time;
                            stack.push(other);
                            break;
                        } else {
                            diff_time -= other.remain;
                            answer[idx++] = other.subject;
                        }
                    }
                } else {
                    out.remain -= diff_time;
                    stack.push(out);
                }
            } else {
                answer[idx++] = out.subject;
            }
        }
        while(!stack.isEmpty()) {
            obj out = stack.pop();
            answer[idx++] = out.subject;
        }
        return answer;
    }
    public int time(String time) {
        String[] arr = time.split(":");
        int t = 0;
        t += Integer.parseInt(arr[0]) * 60;
        t += Integer.parseInt(arr[1]);
        return t;
    }
    class obj {
        String subject;
        int time;
        int remain;
        
        public obj(String subject, int time, int remain) {
            this.subject = subject;
            this.time = time;
            this.remain = remain;
        }
    }
}