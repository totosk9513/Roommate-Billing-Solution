package org.roommate.services;

import org.roommate.models.Bill;
import org.roommate.models.IOU;
import org.roommate.models.Person;
import org.roommate.models.Tenant;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This bill calculator simply just divide a bill by number of participators.
 */
public class SimpleSplitCalculatorService extends CalculatorService
{
//    private String name;
    //TODO: should this bill go up to the parent class?
    private Bill bill;


    public SimpleSplitCalculatorService(String name)
    {
        super(name);
    }

    public SimpleSplitCalculatorService(String name, Person payer, List<Person> participators)
    {
        super(name,payer,participators);
    }

    SimpleSplitCalculatorService(Bill bill)
    {
       super(bill);
    }

    @Override
    public void calc()
    {
        int numOfParticipators = participators.size();
        double split = bill.getGrandTotalPrice() / numOfParticipators;
        for (Person p : participators)
        {
//            debtor.addIOU(new IOU(bill, debtor, payer, split, name + " : REASON"));
            if (!p.equals(payer))
            {
                IOU iou = new IOU(bill, p, payer, split, name + " : REASON");
                p.addIOU(iou);
                bill.getPayer().addIOU(iou);
            }
        }
    }

    //Unit test
    public static void main(String[] args)
    {
        System.out.println("=== SimpleSplitCalculatorService 단위 테스트 시작 ===");

        Tenant payerKim = new Tenant("Kim");
        Tenant park = new Tenant("Park");
        Tenant lee = new Tenant("Lee");
        List<Person> roommates = List.of(payerKim, park, lee);
        Bill bill = new Bill("Lunch", 100.0, payerKim, roommates, LocalDateTime.of(2026,04,20,12,35));
        //List.Of 로 만들어진 List는 Immutable.

        //TODO: calculator Service.name을 아마 bill.name + 정산 날짜로 할까?
        SimpleSplitCalculatorService service = new SimpleSplitCalculatorService(bill);
        service.execute();

        System.out.println("AssertionTest");

        System.out.println("\n--- [정산 결과 확인] ---");
        for (Person p : roommates)
        {
            double give = p.getDebts().stream().mapToDouble(IOU::getAmount).sum();
            double take = p.getCredits().stream().mapToDouble(IOU::getAmount).sum();

            System.out.println("이름: " + p.getName());
            System.out.printf("  - 줄 돈: %.2f원\n", give);
            System.out.printf("  - 받을 돈: %.2f원\n", take);
            System.out.println("  - 상세 내역: " + (p.getDebts().isEmpty() && p.getCredits().isEmpty() ? "내역 없음" : "증서 있음"));
            System.out.println("----------------------");
        }

        System.out.println("\n--- [IOU Printing] ---");
        for (Person p : roommates)
        {
            System.out.println(p.getName() + "가 가지고 있는 IOU List:\n");
            for (IOU iou : p.getIouList())
            {
                System.out.println(" " + iou);
            }
        }
    }
}

