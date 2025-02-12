
class Process {
    int id, burstTime, priority, waitingTime, turnAroundTime;
    Process next;

    public Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head, tail;
    int totalProcesses, totalWaitingTime, totalTurnAroundTime;
    int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
        totalProcesses++;
    }

    public void removeProcess(int id) {
        if (head == null) return;
        Process current = head, prev = tail;
        do {
            if (current.id == id) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                    if (current == tail) tail = prev;
                }
                totalProcesses--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void simulateRoundRobin() {
        Process current = head;
        int currentTime = 0;
        while (totalProcesses > 0) {
            if (current.burstTime > 0) {
                int timeSpent = Math.min(current.burstTime, timeQuantum);
                current.burstTime -= timeSpent;
                currentTime += timeSpent;

                if (current.burstTime == 0) {
                    current.turnAroundTime = currentTime;
                    current.waitingTime = current.turnAroundTime - timeSpent;
                    totalWaitingTime += current.waitingTime;
                    totalTurnAroundTime += current.turnAroundTime;
                    removeProcess(current.id);
                }
            }
            current = current.next;
        }
    }

    public void displayProcesses() {
        if (head == null) return;
        Process current = head;
        do {
            System.out.println("ID: " + current.id + ", Burst Time: " + current.burstTime + 
                               ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }

    public void displayAverageTimes() {
        double avgWaitingTime = (double) totalWaitingTime / (totalWaitingTime > 0 ? totalProcesses : 1);
        double avgTurnAroundTime = (double) totalTurnAroundTime / (totalTurnAroundTime > 0 ? totalProcesses : 1);
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnAroundTime);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        
        System.out.println("Processes in Circular Queue:");
        scheduler.displayProcesses();

        scheduler.simulateRoundRobin();
        
        System.out.println("Average Times:");
        scheduler.displayAverageTimes();
    }
}

