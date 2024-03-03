import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<String> queue = new LinkedList<>();

    @Override
    public void enqueue(String person) {
        queue.add(person);
    }

    @Override
    public String dequeue() {
        return queue.poll();
    }

    @Override
    public void addPersonToQueue(String person) {
        enqueue(person);
        System.out.println(person + " joined the queue.");
    }

    @Override
    public String servePerson() {
        String person = dequeue();
        if (person != null) {
            System.out.println(person + " was served.");
        } else {
            System.out.println("No one in the queue.");
        }
        return person;
    }

    public void update() {
        // Логика обновления состояния магазина, принятие и отдача заказов
        System.out.println("Market state updated.");
    }

    public static void main(String[] args) {
        Market market = new Market();
        market.addPersonToQueue("Ivan");
        market.addPersonToQueue("Boris");
        market.addPersonToQueue("Sveta");
        market.servePerson();
        market.update();
    }
}