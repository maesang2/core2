package com.example.core2.scan;

import com.example.core2.AutoAppConfig;
import com.example.core2.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
         AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
         MemberService memberService = ac.getBean(MemberService.class);
         assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
