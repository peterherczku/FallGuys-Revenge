package dev.blockeed.api.storage;

/*
 * Copyright (c) Blockeed | All rights reserved
 *
 * Do not change the code!
 *
 */

import dev.blockeed.api.tools.MinecraftPlugin;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public abstract class SQLStorage extends StorageMethod<SQLStorage> {

    private MinecraftPlugin plugin;
    private Connection connection;

    public SQLStorage(MinecraftPlugin plugin, Connection connection) {
        this.plugin=plugin;
        this.connection=connection;
    }

    public void insertSQLData(String table, String names, String values) {
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    PreparedStatement update = connection
                            .prepareStatement("INSERT INTO `"+table+"` ("+names+") VALUES ("+values+")");
                    update.executeUpdate();
                    update.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void updateSQLData(String table, String dataname, Object value, String where, Object whereValue) {
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    PreparedStatement update = connection
                            .prepareStatement("UPDATE `"+table+"` SET `"+dataname+"`=? WHERE `"+where+"`=?");
                    update.setObject(1, value);
                    update.setObject(2, whereValue);
                    update.executeUpdate();
                    update.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CompletableFuture<SQLData> getSQLData(String table, String dataname, String where, Object whereValue) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                PreparedStatement statement = connection.
                        prepareStatement("SELECT `"+dataname+"` FROM `"+table+"` WHERE `"+where+"`=?");
                statement.setObject(1, whereValue);
                ResultSet rs = statement.executeQuery();
                SQLData data=null;
                if (rs.next()) {
                    data=new SQLData(rs.getString(dataname));
                }
                rs.close();
                return data;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public SQLStorage getMethod() {
        return null;
    }
}
