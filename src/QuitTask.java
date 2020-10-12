import animation.Task;

public class QuitTask implements Task<Void> {


    @Override
    public Void run() {
        System.exit(1);
        return null;
    }
}
