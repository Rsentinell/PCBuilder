package payment;

public abstract class Payment {
    PaymentImplementor paymentImplementor;

    public PaymentImplementor getPaymentImplementor() {
        return paymentImplementor;
    }

    public void setPaymentImplementor(PaymentImplementor paymentImplementor) {
        this.paymentImplementor = paymentImplementor;
    }

    public abstract void payForPC(double amount);
}
