package org.roommate.services;

import org.roommate.models.Bill;
import org.roommate.models.IOU;
import org.roommate.models.Person;
import org.roommate.models.Tenant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedCalculatorService extends CalculatorService
{
//    private Map<Person, Double> weights;
    private final WeightAssigner weightAssigner;

    //default, assign same weight to all
    public WeightedCalculatorService(Bill bill)
    {
        super(bill);
        this.weightAssigner = new WeightAssigner(bill.getParticipators());
        weightAssigner.getAssignedSameWeightToAll();
    }

    // assign designated weight to a person, Assume weight is assigned before this calcServ is run
    public WeightedCalculatorService(Bill bill, WeightAssigner weightAssigner)
    {
        super(bill);
        this.weightAssigner = weightAssigner;
    }


    @Override
    public void calc()
    {
        Map<Person, Double> weights = this.weightAssigner.getWeights();
        //get totalUnits from the weights
        double totalWeight = weights.values().stream().mapToDouble(Double::doubleValue).sum();
        //get unitCost, totalBill/totalUnits
        double unitPrice = getBill().getGrandTotalPrice() / totalWeight;
        //assign bills based on units

        for (Map.Entry<Person, Double> entry : weights.entrySet())
        {
            Person p = entry.getKey();
            Double pWeight = entry.getValue();

            if (!p.equals(getBill().getPayer()))
            {
                double weightedAmount = (unitPrice * pWeight);
                IOU iou = new IOU(bill, p ,bill.getPayer(), weightedAmount, bill.getName());
                p.addIOU(iou);
                getBill().getPayer().addIOU(iou);
            }
        }

    }

    //unit test
    public static void main(String[] args)
    {
        // 1. 가상 데이터 준비
        Person p1 = new Tenant("철수"); // 결제자
        Person p2 = new Tenant("영희");
        Person p3 = new Tenant("길동");
        List<Person> members = List.of(p1, p2, p3);

        Bill testBill = new Bill("회식비", 30000.0, p1, members);

        // 2. 가중치 전략 정의 (익명 클래스로 간단히 구현)
//        WeightAssigner customAssigner = new WeightAssigner(members,);
        WeightAssigner weightAssigner1 = new WeightAssigner(members);
        weightAssigner1.setWeightToPerson(p1, 0);
        weightAssigner1.setWeightToPerson(p2, 2);
        weightAssigner1.setWeightToPerson(p3, 0.3);

        // 3. 서비스 실행
        WeightedCalculatorService service = new WeightedCalculatorService(testBill, weightAssigner1);
        service.calc();

        // 4. 결과 검증 출력
        System.out.println("=== Weighted Split Test Result ===");
        System.out.println("영수증: " + testBill.getName() + " (총액: " + testBill.getGrandTotalPrice() + "원)");
        System.out.println("결제자: " + p1.getName());
        System.out.println("---------------------------------");

        for (Person p : members)
        {
            System.out.println("[" + p.getName() + "의 상태]");
            System.out.println("  받을 돈(Credits): " + p.getCredits());
            System.out.println("  갚을 돈(Debts): " + p.getDebts());
        }
    }
}
