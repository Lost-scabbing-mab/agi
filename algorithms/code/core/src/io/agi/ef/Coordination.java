package io.agi.ef;

/**
 * Created by dave on 16/02/16.
 */
public interface Coordination {

    void doUpdate(String entityName);

    void onUpdated(String entityName);

}