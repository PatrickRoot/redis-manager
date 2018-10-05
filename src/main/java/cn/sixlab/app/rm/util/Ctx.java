package cn.sixlab.app.rm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Ctx {
    private static ApplicationContext ctx;

    @Autowired
    public void setCtx(ApplicationContext ctx) {
        Ctx.ctx = ctx;
        System.out.println(ctx);
    }

    public static <T> T getBean(Class<T> clz) {
        return ctx.getBean(clz);
    }

}
