package com.doorcs.calculator;

public enum OperatorType {
    ADD('+'),
    SUB('-'),
    MUL('*'),
    DIV('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public int apply(int x, int y) {
        return switch (this) {
            case ADD -> x + y;
            case SUB -> x - y;
            case MUL -> x * y;
            case DIV -> {
                if (y == 0) {
                    throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                yield x / y;
            }
        };
    }

    public static OperatorType fromSymbol(char symbol) {
        for (OperatorType op : values()) {
            if (op.symbol == symbol) {
                return op;
            }
        } // 일치하는 연산자가 없을 경우에도 명시적 예외를 발생시킴
        throw new IllegalArgumentException("올바른 사칙연산 기호 (+, -, *, /)를 입력해주세요.");
    }
}