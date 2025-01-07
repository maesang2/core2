package com.example.core2.order;

import com.example.core2.discount.DiscountPolicy;
import com.example.core2.member.Member;
import com.example.core2.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

        private final MemberRepository memberRepository;
        private final DiscountPolicy discountPolicy;

        @Override
        public Order createOrder(Long memberId, String itemName, int itemPrice) {
            Member member = memberRepository.findById(memberId);
            int discountPrice = discountPolicy.discount(member, itemPrice);

            return new Order(memberId, itemName, itemPrice, discountPrice);
        }

}
