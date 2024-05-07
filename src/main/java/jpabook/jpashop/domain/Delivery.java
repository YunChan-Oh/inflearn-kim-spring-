package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY) //연관관계의 주체가 아님
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) //oridinal은 숫자로 되기에 쓰지 말기!
    private DeliveryStatus status; //ready, comp
}
