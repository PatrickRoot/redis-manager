package cn.sixlab.app.rm;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

import java.io.IOException;

@SpringBootApplication
public class RedisManagerApplication extends Application {
    private static Logger logger = LoggerFactory.getLogger(RedisManagerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RedisManagerApplication.class, args);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        test();
        
        Platform.setImplicitExit(true);
        Parent parent;
        try {
            parent = FXMLLoader.load(getClass().getResource("rm.fxml"));
        } catch (IOException e1) {
            parent = new Label("读取失败");
            logger.error(e1.getMessage(), e1);
        }
        Scene scene = new Scene(parent, 1040, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Redis Manager");
        primaryStage.show();
    }
    
    public String test() {
    
        Jedis jedis = new Jedis("192.168.1.12", 32768);
        // 直接调用jedis对象的方法，方法名称和redis的命令一致
        jedis.set("key1", "test01");
        jedis.set("key2", "test02");
        String key1 = jedis.get("key1");
        String key2 = jedis.get("key2");
        System.out.println(key1 + " " + key2);
        // 关闭jedis
        jedis.close();
    
        //RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        //configuration.setDatabase(0);
        //configuration.setHostName("localhost");
        //configuration.setPort(32768);
        //
        //RedisConnectionFactory factory = new JedisConnectionFactory(configuration);
        //
        //RedisConnection connection = factory.getConnection();
        //
        //System.out.println(connection.isClosed());
        //System.out.println(connection.isPipelined());
        //System.out.println(connection.isQueueing());
        //System.out.println(connection.isSubscribed());
        //
        //RedisTemplate template = new RedisTemplate();
        //
        //template.setConnectionFactory(factory);
        //
        //ValueOperations operations = template.opsForValue();
        //
        //operations.set("abc","1");
        //System.out.println(operations.get("abc"));
        //System.out.println(template.delete("abc"));
        //
        return "template";
    
    }
}
