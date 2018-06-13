import io.vertx.core.Vertx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new TestVerticle(), ar -> {
            if(ar.succeeded()) {
                System.out.println("Verticle deployed");
            }else {
                System.out.println("Problem deploying Verticle");
            }
        });

        vertx.deployVerticle(new PersistanceVerticle(), ar -> {
            if(ar.succeeded()) {
                System.out.println("Verticle deployed");
            }else {
                System.out.println("Problem deploying Verticle");
            }
        });
    }

}
