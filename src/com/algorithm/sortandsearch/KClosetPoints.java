package com.algorithm.sortandsearch;

import java.util.*;

public class KClosetPoints {
    public static void main(String[] args) {
        KClosetPoints kClosetPoints = new KClosetPoints();
        int[][] points = {{3,3}, {5,-1}, {-2,4}};
        //int[][] points = {{1,3}, {-2,2}};
        int k = 2;
        System.out.println(Arrays.deepToString(kClosetPoints.solve_example(points,k)));
    }

    public int[][] solve_example(int[][] points, int k) {
        int [][] result = new int[k][2];
        // x, y 평면에서 (x1, y1), (x2, y2) 두 점 사이 거리 구하는 공식
        // (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)
        // 한 점은 무조건 원점(x1 = 0, y1 = 0)이므로 (x1 * x1) + (y1 * y1)
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));

        for (int[] p : points) {
            pq.offer(p);
        }

        int index = 0;
        while(index < k) {
            result[index] = pq.poll();
            index++;
        }
        return result;
    }

}
