package org.roommate.services;

import org.roommate.models.Bill;
import org.roommate.models.Person;

import java.util.List;

public abstract class CalculatorService
{
    protected String name;
    protected Person payer;
    protected List<? extends Person> participators;
    protected Bill bill;

    public CalculatorService(String name)
    {
        this.name = name;
    }

    public CalculatorService(Bill bill)
    {
        this.bill = bill;
        this.name = bill.getName();
        this.payer = bill.getPayer();
        this.participators = bill.getParticipators();
    }

    public CalculatorService(String name, Person payer, List<? extends Person> participators)
    {
        this.name = name;
        this.payer = payer;
        this.participators = participators;
    }

    //Design Pattern: Template Method Pattern.
    public final void execute() {
        // 1. 공통 전처리: 참여자 명단이 비어있는지 체크
        if (participators == null || participators.isEmpty()) {
            System.out.println("참여자가 없어 계산을 중단합니다.");
            return;
        }

        System.out.println("[" + name + "] 정산 로직 실행");

        // 2. 핵심 로직: 자식 클래스가 정의한 정산 방식 실행\
        //Design Pattern: Template Method Pattern.
        calc();

        // 3. 공통 후처리: 발행된 IOU 개수 출력 등
        System.out.println("정산이 성공적으로 끝났습니다.");
    }

    public abstract void calc();

}
