package cn.wlk.keepcoding.niuke.Y2020.QiNiu;

/**
 * 2020/4/28 20:35
 * author:WLK
 */

public class BankAccount {
    private long balance;

    public BankAccount(long balance) {
        this.balance = balance;
    }
    static void transferFrom_old(BankAccount source, BankAccount dest, long amount) {
        synchronized(BankAccount.class) {
            source.balance -= amount;
            dest.balance   += amount;
        }
    }


    /**
     * 使用BankAccount的hashcode作为加锁的顺序依据，先加hashcode大的对象，后加hashcode小的对象的锁，
     * 这样可以防止出现死锁的现象
     * @param source
     * @param dest
     * @param amount
     */
    static void transferFrom_new(BankAccount source, BankAccount dest, long amount) {
        if(source.hashCode() > dest.hashCode()) {
            synchronized (source) {
                synchronized (dest) {
                    source.balance -= amount;
                    dest.balance += amount;
                }
            }
        }else{
            synchronized (dest) {
                synchronized (source) {
                    source.balance -= amount;
                    dest.balance += amount;
                }
            }

        }
    }
    public synchronized long balance() {
        return balance;
    }
}
