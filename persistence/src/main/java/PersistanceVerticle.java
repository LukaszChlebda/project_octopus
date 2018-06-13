import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;

public class PersistanceVerticle extends AbstractVerticle{

    private Future onStop = Future.future();

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        System.out.println("Persistence verticle started "+ vertx.deploymentIDs());

        //Todo right now exception is thrown
        //MongoClient mongoClient = MongoClient.createShared(vertx, config());

        vertx.eventBus().localConsumer("/persistence/get", ar -> {
            JsonObject jsonObject = JsonObject.mapFrom(ar.body());
            ar.reply(new JsonObject());
            System.out.println(jsonObject);
        });

        startFuture.complete();
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        onStop.complete();
        stopFuture.complete();
    }
}
