package kr.co.subx.common.enums;

import lombok.Getter;

@Getter
public enum Status {

    ACTIVE("활성"),
    DELETED("삭제");

    private final String label;

    Status(String label) {
        this.label = label;
    }
}
