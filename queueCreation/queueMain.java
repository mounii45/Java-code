
public class queueMain {
    public static void main(String[] args) throws Exception {
        circularQueue q = new circularQueue(5);
        q.insert(12);
        q.insert(14);
        q.insert(16);
        q.insert(18);

        q.insert(25);

        System.out.println(q.remove());
        q.remove();
        q.insert(30);
        q.insert(44);

        q.display();
    }
}
