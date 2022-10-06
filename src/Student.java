import java.util.ArrayList;
import java.util.Random;

import sort.Sort;

public class Student <T extends Comparable<T>> implements Comparable<Student<T>> {
  private String id;
  private T score;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public T getScore() {
    return score;
  }

  public void setScore(T score) {
    this.score = score;
  }

  public Student(String id, T score) {
    this.id = id;
    this.score = score;
  }

  public void print(){
    System.out.println(toString());
  }

  @Override
  public String toString() {
    return this.id + ": " + this.score;
  }

  @Override
  public int compareTo(Student<T> stu) {
    return this.score.compareTo(stu.getScore());
  }

  public static void main (String[] args) {
    int arrayLength = 10;
    ArrayList<Student<Float>> students = new ArrayList<>(arrayLength);
    Random random = new Random();
    for (int i = 0; i < arrayLength; i ++) {
      students.add(new Student<Float>(String.valueOf(i), random.nextFloat(100)));
    }
    for (Student<Float> stu : students) {
      stu.print();
    }
    Sort.printArray(students);
    Sort.bubbleSort(students);
    Sort.printArray(students);
  }
}
