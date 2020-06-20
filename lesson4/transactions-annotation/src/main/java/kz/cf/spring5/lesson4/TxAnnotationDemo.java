package kz.cf.spring5.lesson4;

import java.util.List;

import kz.cf.spring5.lesson4.config.DataJpaConfig;
import kz.cf.spring5.lesson4.config.ServicesConfig;
import kz.cf.spring5.lesson4.entities.Singer;
import kz.cf.spring5.lesson4.services.SingerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class TxAnnotationDemo {

    public static void main(String... args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ServicesConfig.class,
                DataJpaConfig.class);

        SingerService singerService = ctx.getBean(SingerService.class);

        List<Singer> singers = singerService.findAll();
        singers.forEach(s -> System.out.println(s));

        Singer singer = singerService.findById(1L);
        singer.setFirstName("John Clayton");
        singer.setLastName("Mayer");
        singerService.save(singer);
        System.out.println("Singer saved successfully: " + singer);
        System.out.println("Singer count: " + singerService.countAll());

        ctx.close();
    }
}

