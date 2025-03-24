package kr.co.subx.model.parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class BaseParameter {

    private int page = 1;
    private int size = 10;

    public int getPage() {
        return this.page - 1;
    }

    @JsonIgnore
    public Pageable getPageable(String sortProp) {
        if (sortProp.isEmpty()) {
            return PageRequest.of(getPage(), this.size);
        } else {
            return PageRequest.of(getPage(), this.size, Sort.by(sortProp).descending());
        }
    }

}
