package io.agi.framework.factories;

import io.agi.core.orm.ObjectMap;
import io.agi.framework.Entity;
import io.agi.framework.EntityConfig;
import io.agi.framework.EntityFactory;
import io.agi.framework.Node;
import io.agi.framework.entities.*;
import io.agi.framework.persistence.models.ModelEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Base class for entity factories, that creates all the default types.
 *
 * Created by dave on 12/03/16.
 */
public class CommonEntityFactory implements EntityFactory {

    private static final Logger logger = LogManager.getLogger();

    protected Node _n;

    public CommonEntityFactory() {

    }

    public void setNode( Node n ) {
        _n = n;
    }

    public Entity create( ObjectMap om, ModelEntity me ) {

        String entityName = me.name;
        String entityType = me.type;

        if ( entityType.equals( RandomVectorEntity.ENTITY_TYPE ) ) {
            return new RandomVectorEntity( entityName, om, RandomVectorEntity.ENTITY_TYPE, _n );
        }

        if ( entityType.equals( DiscreteRandomEntity.ENTITY_TYPE ) ) {
            return new DiscreteRandomEntity( entityName, om, DiscreteRandomEntity.ENTITY_TYPE, _n );
        }

        if ( entityType.equals( DynamicSelfOrganizingMapEntity.ENTITY_TYPE ) ) {
            return new DynamicSelfOrganizingMapEntity( entityName, om, DynamicSelfOrganizingMapEntity.ENTITY_TYPE, _n );
        }

        if ( entityType.equals( GrowingNeuralGasEntity.ENTITY_TYPE ) ) {
            return new GrowingNeuralGasEntity( entityName, om, GrowingNeuralGasEntity.ENTITY_TYPE, _n );
        }

        if ( entityType.equals( ImageSensorEntity.ENTITY_TYPE ) ) {
            return new ImageSensorEntity( entityName, om, ImageSensorEntity.ENTITY_TYPE, _n );
        }

        if( entityType.equals( RegionEntity.ENTITY_TYPE ) ) {
            return new RegionEntity( entityName, om, RegionEntity.ENTITY_TYPE, _n );
        }

        if( entityType.equals( ConstantMatrixEntity.ENTITY_TYPE ) ) {
            return new ConstantMatrixEntity( entityName, om, ConstantMatrixEntity.ENTITY_TYPE, _n );
        }

        if ( entityType.equals( EncoderEntity.ENTITY_TYPE ) ) {
            return new EncoderEntity(entityName, om, EncoderEntity.ENTITY_TYPE, _n );
        }

        logger.error( "Could not create an entity for " + entityName + " of type " + entityType );

        return null;
    }

}