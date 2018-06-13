import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

public class TestVerticle extends AbstractVerticle {

    private Future onStop = Future.future();

    @Override
    public void start(Future<Void> startFuture) throws Exception {

        System.out.println("Test verticle deployed " + vertx.deploymentIDs());
        System.out.println("Config " + config().encodePrettily());

        vertx.setTimer(1000, (l) -> {
            vertx.eventBus().send("/persistence/get", new JsonObject().put("First", "Second"), ar -> {
                if(ar.succeeded()) {
                    System.out.println("Sent");
                }else {
                    System.out.println("Error");
                }
            });
        });

        startFuture.complete();
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        onStop.complete();
        stopFuture.complete();
    }
}
