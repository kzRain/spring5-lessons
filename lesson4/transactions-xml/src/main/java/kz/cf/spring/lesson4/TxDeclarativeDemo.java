package kz.cf.spring.lesson4;

import java.util.List;

import kz.cf.spring.lesson4.entities.Singer;
import kz.cf.spring.lesson4.services.SingerService;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TxDeclarativeDemo {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/tx-declarative-app-context.xml");
        ctx.refresh();

        SingerService singerService = ctx.getBean(SingerService.class);

        List<Singer> singers = singerService.findAll();
        singers.forEach(s -> System.out.println(s));

        Singer singer = singerService.findById(1L);
        singer.setFirstName("John Clayton");
        singerService.save(singer);
        System.out.println("Singer saved successfully: " + singer);
        System.out.println("Singer count: " + singerService.countAll());

        ctx.close();
    }
}
