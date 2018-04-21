package learn_java_lock;

/**
 * @Author bruce.ge
 * @Date 2017/3/19
 * @Description
 */
public class Thread_ABC implements Runnable {
    private MujusculeABC abc;

    private int printTime;
    private char currentChar;

    public Thread_ABC(MujusculeABC maj, char currentChar) {
        this.abc = maj;
        this.currentChar = currentChar;
        this.printTime = 0;
    }

    @Override
    public void run() {
        while (true) {
            abc.getLock().lock();
            try {
                if (this.printTime == 0 && currentChar == 'A') {
                    System.out.println(this.currentChar);
                    abc.getWaitA().signal();
                    abc.setLastPrintChar('A');
                    this.printTime++;
                } else if (this.printTime == 10) {
                    return;
                } else {
                    if (currentChar == 'A') {
                        try {
                            while (abc.getLastPrintChar() != 'C') {
                                abc.getWaitC().await();
                            }
                        } catch (InterruptedException e) {

                        }
                        System.out.println('A');
                        this.printTime++;
                        abc.getWaitA().signal();
                        abc.setLastPrintChar('A');
                    } else if (currentChar == 'B') {
                        try {
                            while (abc.getLastPrintChar() != 'A') {
                                abc.getWaitA().await();
                            }
                        } catch (InterruptedException e) {

                        }
                        System.out.println('B');
                        this.printTime++;
                        abc.setLastPrintChar('B');
                        abc.getWaitB().signal();
                    } else if (currentChar == 'C') {
                        try {
                            while (abc.getLastPrintChar() != 'B') {
                                abc.getWaitB().await();
                            }
                        } catch (InterruptedException e) {

                        }
                        abc.setLastPrintChar('C');
                        System.out.println('C');
                        this.printTime++;
                        abc.getWaitC().signal();
                    }
                }

            } finally {
                abc.getLock().unlock();
            }

        }
    }
}
