package org.ddocumentor.testing;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

import java.io.IOException;

public class TestMongoDb {

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
            if (mongod != null) {
                mongod.stop();
            }
            if (mongodExe != null) {
                mongodExe.stop();
            }
            throw new RuntimeException(e);
        }
    }

    public TestMongoDb stop() {
        if (this.mongod != null) {
            this.mongod.stop();
            this.mongodExe.stop();
        }
        return this;
    }

}
