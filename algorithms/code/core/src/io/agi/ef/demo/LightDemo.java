package io.agi.ef.demo;

import io.agi.core.orm.Keys;
import io.agi.core.orm.NamedObject;
import io.agi.core.orm.ObjectMap;
import io.agi.ef.*;
import io.agi.ef.http.HttpCoordination;
import io.agi.ef.serialization.JsonData;
import io.agi.ef.serialization.JsonEntity;
import io.agi.ef.sql.JdbcPersistence;

/**
 * Created by dave on 18/02/16.
 */
public class LightDemo {

    public static void main( String[] args ) {

        // Provide classes for entities
        LightEntityFactory ef = new LightEntityFactory();

        // Create a Node
        Main m = new Main();
        m.setup( args[0], null, ef );

        // Create custom entities
        createEntities( m._n );

        // Start the system
        m.run();
    }

    public static void createEntities( Node n ) {

        // Define some entities
        String lightSourceName = "myLight";
        String lightControlName = "mySwitch";

        JsonEntity lightControl = new JsonEntity( lightControlName, LightControl.ENTITY_TYPE, n.getName(), null );
        JsonEntity lightSource = new JsonEntity( lightSourceName, LightSource.ENTITY_TYPE, n.getName(), lightControlName );

        Persistence p = n.getPersistence();
        p.setEntity( lightSource );
        p.setEntity( lightControl );

        // Connect the entities
        Entity.SetInputReference( p, lightSourceName, LightSource.CONTROL_INPUT, lightControlName, LightControl.CONTROL_OUTPUT );
    }
}