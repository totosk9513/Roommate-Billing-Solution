package org.roommate.models;

import java.time.LocalDateTime;

public class IOU
{
    private final Person debtor;   // 채무자 (돈을 줄 사람)
    private final Person creditor; // 채권자 (돈을 받을 사람)
    private final double amount;
    private final String reason;   // 사유 (예: "전기세 정산")
    private final LocalDateTime issuedAt; // 발행 시간

    public IOU(Person debtor, Person creditor, double amount, String reason) {
        this.debtor = debtor;
        this.creditor = creditor;
        this.amount = amount;
        this.reason = reason;
        this.issuedAt = LocalDateTime.now();
    }

    // Getter들
    public Person getDebtor() { return debtor; }
    public Person getCreditor() { return creditor; }
    public double getAmount() { return amount; }
    public String getReason() { return reason; }
}
