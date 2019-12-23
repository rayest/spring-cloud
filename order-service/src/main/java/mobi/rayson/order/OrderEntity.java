package mobi.rayson.order;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderEntity {
    private Integer id;
    private String orderNo;
    private String userNo;
}
