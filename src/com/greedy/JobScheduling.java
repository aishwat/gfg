package com.greedy;

import java.util.Arrays;

class Job implements Comparable<Job> {
    char id;
    int dead;
    int profit;

    Job(char _id, int _dead, int _profit) {
        this.id = _id;
        this.dead = _dead;
        this.profit = _profit;
    }

    @Override
    public int compareTo(Job o) {
        return o.profit - this.profit; //decreasing
    }
}

public class JobScheduling {
    public static void printJobSchedule(Job[] jobs, int n) {
        char slot[] = new char[jobs.length];
        Arrays.fill(slot, '-');
        Arrays.sort(jobs);

        for (int i = 0; i < jobs.length; i++) {
            //pick this job and look for free slot from deadline to start

            for (int j = jobs[i].dead - 1; j >= 0; j--) {
                if (slot[j] == '-') {
                    slot[j] = jobs[i].id;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(slot));
    }

    public static void main(String[] args) {
        Job jobs[] = {new Job('a', 2, 100),
                new Job('b', 1, 19),
                new Job('c', 2, 27),
                new Job('d', 1, 25),
                new Job('e', 3, 15)};
        printJobSchedule(jobs, jobs.length);

    }
}
