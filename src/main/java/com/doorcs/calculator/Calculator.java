package com.doorcs.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> results = new ArrayList<>();

    public void calculate(int lhs, int rhs, char op) throws IllegalArgumentException {
        OperatorType operator = OperatorType.fromSymbol(op);
        int result = operator.apply(lhs, rhs); // 예외는 main() 메서드에서 처리함!
        results.add(result);
    }

    public int getResult() {
        return getNth(results.size() - 1); // Getter 메서드를 활용해 기존 calculate() 메서드의 로직을 구현함
    }

    public int getNth(int n) {
        if (n < 0 || n >= results.size()) {
            System.out.println("잘못된 인덱스입니다.");
            return -1;
        }
        return results.get(n);
    }

    public int setNth(int n, int val) {
        if (n < 0 || n >= results.size()) {
            System.out.println("잘못된 인덱스입니다.");
            return -1;
        }
        results.set(n, val);
        return 0;
    }

    public int removeResult() {
        if (results.isEmpty()) {
            System.out.println("삭제할 결과가 없습니다.");
            return -1;
        }

        results.remove(0); // 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제
        return 0;
    }

    public List<Integer> getResultsGreaterThan(int val) {
        return results.stream()
            .filter(elem -> elem > val)
            .toList();
    }
}
