public aspect AccountAspect {
    final int MIN_BALANCE = 10;

    pointcut callWithDraw(int amount, Account acc) : call(boolean Account.withdraw(int)) && args(amount) && target(acc);


    before (int amount, Account acc) : callWithDraw(amount, acc) {
        System.out.println("Before");

      //  return proceed(amount, acc);
    }

    boolean around (int amount, Account acc) : callWithDraw(amount, acc){
        System.out.println("Around");
        if (acc.balance < amount || acc.balance < MIN_BALANCE) {
            return false;
        }

        return proceed(amount, acc);
    }

    after (int amount, Account balance) : callWithDraw(amount, balance) {
        System.out.println("After");
    }
}