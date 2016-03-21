package io.agi.framework.entities;

import io.agi.core.data.Data;
import io.agi.core.data.DataSize;
import io.agi.core.orm.ObjectMap;
import io.agi.framework.Entity;
import io.agi.framework.Node;

import java.util.Collection;
import java.util.Random;

/**
 * Randomly produces points on a discrete grid.
 * Makes for a good test of unsupervised learning methods.
 *
 * Created by dave on 13/03/16.
 */
public class DiscreteRandomEntity extends Entity {

    public static final String ENTITY_TYPE = "discrete-random";

    public static final String ELEMENTS = "elements";
    public static final String LEVELS = "levels";
    public static final String MIN = "min";
    public static final String MAX = "max";

    public static final String OUTPUT = "output";

    public DiscreteRandomEntity(String entityName, ObjectMap om, String type, Node n) {
        super( entityName, om, type, n );
    }

    public void getInputKeys(Collection<String> keys) {
    }

    public void getOutputKeys(Collection<String> keys) {
        keys.add( OUTPUT );
    }

    protected void doUpdateSelf() {

        // Get all the parameters:
        float min = getPropertyFloat(MIN, 0.0f);
        float max = getPropertyFloat(MAX, 1.0f);
        int elements = getPropertyInt(ELEMENTS, 1);
        int levels = getPropertyInt(LEVELS, 5);

        Data output = getDataLazyResize(OUTPUT, DataSize.create(elements));
        Random r = getRandom();

        // range = 1
        // intervals = 5
        // _1_2_3_4_5_   = 6 gaps.
        // _|_|_|_|_|_   = 6 gaps.
        // min        max

        float perLevel = 1.f / (float)( levels +1 );
        float range = max - min;

        for( int i = 0; i < elements; ++i ) {

            int n = r.nextInt( levels ) +1; // so will be 0 -> n-1
            float x = (float)n * perLevel;
            x = x * range;
            x += min;
            //System.out.println(  "random: " + x );
            output._values[ i ]  = x;
        }

        setData( OUTPUT, output );
    }
}