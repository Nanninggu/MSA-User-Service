package MSAEcommerce.userservice.vo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

public class ResponseOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Date createdAt;

    private String orderId;
}
