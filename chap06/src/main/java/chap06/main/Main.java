package chap06.main;

import chap06.config.AppCtx;
import chap06.spring.Client;
import java.io.IOException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) throws IOException  {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Client client = ctx.getBean(Client.class);
        client.send();

        ctx.close();
    }
}