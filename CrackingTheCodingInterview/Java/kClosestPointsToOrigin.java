//Given an array of points in a 2D plane, find 'K' closest points to origin
//Example input: ponts = [[1,2], [1,3]] K = 1
//Example output: [[1.2]]

/*
  The eucliedean distance (P(x,y)) from the origin can be
  calculated using ( sqrt(x^2 + y^2))

  Using a max heap, push first 'K' points in the heap.
  While iterating through the remaining points, if a
  point say 'P' is closer to the origin than the top
  point of the max heap, we will remove that top point from
  the heap and add 'P' to always keep the closest points
  in the heap
*/

import java.util.*;

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int distFromOrigin() {
    // ignoring sqrt
    return (x * x) + (y * y);
  }
}

class KClosestPointsToOrigin {

  public static List<Point> findClosestPoints(Point[] points, int k) {
    PriorityQueue<Point> maxHeap = new PriorityQueue<>(
              (p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());
    // put first 'k' points in the max heap
    for (int i = 0; i < k; i++)
      maxHeap.add(points[i]);

    // go through the remaining points of the input array, if a point is closer to
    // the origin than the top point of the max-heap, remove the top point from
    // heap and add the point from the input array
    for (int i = k; i < points.length; i++) {
      if (points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
        maxHeap.poll();
        maxHeap.add(points[i]);
      }
    }

    // the heap has 'k' points closest to the origin, return them in a list
    return new ArrayList<>(maxHeap);
  }

  public static void main(String[] args) {
    Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
    List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
    System.out.print("Here are the k points closest the origin: ");
    for (Point p : result)
      System.out.print("[" + p.x + " , " + p.y + "] ");
  }
}
