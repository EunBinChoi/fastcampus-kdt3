package me.day14.collection.queue;

import me.day14.collection.queue.node.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		System.out.println("===============================================================================");
		System.out.println("\t\t\t\t1.  큐");
		System.out.println("===============================================================================");

		// Queue는 인터페이스
		// Queue는 순서대로 유지하면 되므로 LinkedList를 사용해서 구현
		Queue<Student> queue = new LinkedList<>();


		// 원소 삽입
		queue.offer(new Student("20211111", "이순신"));
		queue.offer(new Student("20219873", "자바킹"));
		queue.offer(new Student("20212222", "이제이"));
		queue.offer(new Student("20171234", "이텔리"));
		queue.offer(new Student("20045555", "이초잉"));

		// Queue는 LinkedList로 구현하므로 List 인터페이스 메소드도 사용 가능
		queue.add(new Student("20089212", "이수근"));
		queue.addAll(List.of(
				new Student("20011222", "강호동"),
				new Student("20071231", "유재석")));
		System.out.println("queue = " + queue);
		System.out.println("queue.size() = " + queue.size());
		System.out.println();

		// 큐 원소 가져옴 (제거 ❌)
		Student peekStudent = queue.peek();
		System.out.println("peekStudent = " + peekStudent);
		System.out.println("queue = " + queue);
		System.out.println("queue.size() = " + queue.size());
		System.out.println();

		// 큐 원소 가져옴 (제거 ⭕️)
		Student pollStudent = queue.poll();
		System.out.println("pollStudent = " + pollStudent);
		System.out.println("queue = " + queue);
		System.out.println("queue.size() = " + queue.size());
		System.out.println();


		// 큐 원소 가져옴 (제거 ⭕️)
		while (!queue.isEmpty()) {
			Student pollStudent2 = queue.poll();
			System.out.println("pollStudent2 = " + pollStudent2);
			System.out.println("queue = " + queue);
			System.out.println("queue.size() = " + queue.size());
			System.out.println();
		}
		System.out.println();

		///////////////////////////////////////////////////////////////////////
		System.out.println("===============================================================================");
		System.out.println("\t\t\t\t2. 우선순위 큐");
		System.out.println("===============================================================================");
		// 우선순위가 존재하는 Queue (최소 힙 / 최대 힙을 통해 구현)
		PriorityQueue<Student> priorityQueue = new PriorityQueue<>();


		// PriorityQueue Queue에 원소 추가
		priorityQueue.offer(new Student("20211111", "이순신"));
		priorityQueue.offer(new Student("20219873", "자바킹"));
		priorityQueue.offer(new Student("20212222", "이제이"));
		priorityQueue.offer(new Student("20171234", "이텔리"));
		priorityQueue.offer(new Student("20045555", "이초잉"));


		while (!priorityQueue.isEmpty()) {
			Student pollStudent2 = priorityQueue.poll();
			System.out.println("pollStudent2 = " + pollStudent2);
			System.out.println("priorityQueue = " + priorityQueue);
			System.out.println("priorityQueue.size() = " + priorityQueue.size());
			System.out.println();
		}
		System.out.println();

	}

}
