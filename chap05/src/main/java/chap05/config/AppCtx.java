package chap05.config;

import chap05.spring.ChangePasswordService;
import chap05.spring.MemberDao;
import chap05.spring.MemberInfoPrinter;
import chap05.spring.MemberPrinter;
import chap05.spring.MemberRegisterService;
import chap05.spring.MemberSummaryPrinter;
import chap05.spring.VersionPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"chap05.spring"})
public class AppCtx {
    @Bean
    public MemberDao memberDao2() {
        MemberDao memberDao = new MemberDao();
        return memberDao;
    }

    @Bean
    public MemberRegisterService memberRegSvc() {
        return new MemberRegisterService();
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
        return new ChangePasswordService();
    }

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberprinter2() {
        return new MemberSummaryPrinter();
    }

    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setPrinter(memberprinter2());
        return new MemberInfoPrinter();
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
