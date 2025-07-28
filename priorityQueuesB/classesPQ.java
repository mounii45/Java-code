package priorityQueuesB;

import java.util.Comparator;
import java.util.PriorityQueue;

public class classesPQ {

    static class Student implements Comparable<Student> {
        int rank;
        String name;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }

    }

    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("A", 4)); // O(logn)
        pq.add(new Student("B", 1)); // O(logn)
        pq.add(new Student("C", 9)); // O(logn)
        pq.add(new Student("D", 3)); // O(logn)

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + "->" + pq.peek().rank);// O(1)
            pq.remove();// O(logn)
        }
    }
}
