package org.roommate.models;

import java.time.LocalDateTime;
import java.util.Date;

public class IOU
{
    private final Person debtor;   // 채무자 (돈을 줄 사람)
    private final Person creditor; // 채권자 (돈을 받을 사람)
    private final double amount;
    private final String reason;   // 사유 (예: "전기세 정산")
    private final LocalDateTime issuedAt; // 발행 시간
    private final Bill involvedBill;

    public IOU(Bill bill, Person debtor, Person creditor, double amount, String reason) {
        this.involvedBill = bill;
        this.debtor = debtor;
        this.creditor = creditor;
        this.amount = amount;
        this.reason = reason;
        this.issuedAt = LocalDateTime.now();
    }

    // Getter들
    public Bill getInvolvedBill() {return involvedBill;}
    public Person getDebtor() { return debtor; }
    public Person getCreditor() { return creditor; }
    public double getAmount() { return amount; }
    public String getReason() { return reason; }
    public LocalDateTime getIssuedAt() {return issuedAt; }

//    public void setBill() {};
//    public void setDebtor() {};
//    public void setCreditor() {};
//    public void setReason() {};
//    public void setIssuedAt() {};

    public String toString()
    {
        return String.format(
                "[%s] %s -> %s : $USD[%.2f] (발행일: %s)",
                involvedBill.getName(), // 연관된 영수증 이름
                debtor.getName(),           // 채무자
                creditor.getName(),         // 채권자
                amount,                     // 금액
                issuedAt.toLocalDate()      // 날짜 (날짜만 출력)
        );
    }
}
