class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    // Constructor to create a task node
    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    TaskNode head;

    // Constructor for initializing the Task Scheduler
    public TaskScheduler() {
        head = null;
    }

    // Add a task at the beginning of the circular list
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head; // Circular reference
        } else {
            TaskNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newTask;
            newTask.next = head;
            head = newTask;
        }
    }

    // Add a task at the end of the circular list
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head; // Circular reference
        } else {
            TaskNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newTask;
            newTask.next = head;
        }
    }

    // Add a task at a specific position in the circular list
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }

        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode current = head;
        int currentPosition = 1;
        while (currentPosition < position - 1 && current.next != head) {
            current = current.next;
            currentPosition++;
        }

        if (current == null || current.next == head) {
            System.out.println("Position exceeds the list size");
        } else {
            newTask.next = current.next;
            current.next = newTask;
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove");
            return;
        }

        TaskNode current = head;
        TaskNode previous = null;

        // Case 1: If the task to be removed is the head task
        if (current.taskId == taskId) {
            if (current.next == head) {  // Only one node in the list
                head = null;
            } else {
                while (current.next != head) {
                    current = current.next;
                }
                head = head.next;
                current.next = head;
            }
            return;
        }

        // Case 2: If the task is somewhere else in the list
        while (current != head && current.taskId != taskId) {
            previous = current;
            current = current.next;
        }

        if (current == head) {
            System.out.println("Task with ID " + taskId + " not found");
        } else {
            previous.next = current.next;
        }
    }

    // View current task and move to the next task in the circular list
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }
        TaskNode current = head;
        System.out.println("Current Task: " + current.taskName + " (ID: " + current.taskId + ", Priority: " + current.priority + ", Due Date: " + current.dueDate + ")");
        head = current.next;  // Move to the next task in the circular list
    }

    // Display all tasks starting from the head node
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display");
            return;
        }

        TaskNode current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for a task by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        TaskNode current = head;
        boolean found = false;

        do {
            if (current.priority == priority) {
                System.out.println("Task found: " + current.taskName + " (ID: " + current.taskId + ", Due Date: " + current.dueDate + ")");
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}

public class TaskSchedulerApp {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks at different positions
        scheduler.addTaskAtBeginning(1, "Task 1", 3, "2025-02-20");
        scheduler.addTaskAtEnd(2, "Task 2", 2, "2025-02-22");
        scheduler.addTaskAtEnd(3, "Task 3", 1, "2025-02-25");
        scheduler.addTaskAtPosition(2, 4, "Task 4", 2, "2025-02-23");

        // Display all tasks
        System.out.println("All tasks in the scheduler:");
        scheduler.displayTasks();

        // View current task
        System.out.println("\nView current task:");
        scheduler.viewCurrentTask();

        // Display tasks after viewing current task
        System.out.println("\nTasks after viewing current:");
        scheduler.displayTasks();

        // Search for tasks with priority 2
        System.out.println("\nSearch for task with priority 2:");
        scheduler.searchTaskByPriority(2);

        // Remove task with ID 2
        System.out.println("\nRemove task with ID 2:");
        scheduler.removeTaskById(2);
        scheduler.displayTasks();
    }
}
