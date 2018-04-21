package learn_java_lock;

/**
 * @Author bruce.ge
 * @Date 2017/3/19
 * @Description
 */
public class LockDemo {
    public static void main(String[] args) {
        MujusculeABC mujusculeABC = new MujusculeABC();
        Thread t_a = new Thread(new Thread_ABC(mujusculeABC,'A'));
        Thread t_b = new Thread(new Thread_ABC(mujusculeABC,'B'));
        Thread t_c = new Thread(new Thread_ABC(mujusculeABC,'C'));
        t_a.start();
        t_b.start();
        t_c.start();
    }
}
