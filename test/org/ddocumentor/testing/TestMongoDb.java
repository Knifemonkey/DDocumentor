package org.ddocumentor.testing;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestMongoDb {

    private static Logger logger = Logger.getLogger(TestMongoDb.class.getName());

    private MongodExecutable mongodExe;
    private MongodProcess mongod;

    public TestMongoDb start() {
        try {
            MongodStarter runtime = MongodStarter.getDefaultInstance();
            MongodConfig config = new MongodConfig(Version.V2_4_3, 27017, Network.localhostIsIPv6(), "target/mongodb");
            mongodExe = runtime.prepare(config);
            mongod = mongodExe.start();
            return this;
        } catch (IOException e) {
            try {
                if (mongod != null) {
                    mongod.stop();
                }
                if (mongodExe != null) {
                    mongodExe.stop();
                }
            } catch (Exception ex) {
                logger.log(Level.SEVERE, "exception", ex);
            }
            throw new RuntimeException(e);
        }
    }

    public TestMongoDb stop() {
        try {
            if (this.mongod != null) {
                this.mongod.stop();
                this.mongodExe.stop();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "exception", e);
        }
        return this;
    }

}
