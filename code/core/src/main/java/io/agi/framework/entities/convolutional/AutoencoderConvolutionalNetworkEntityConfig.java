/*
 * Copyright (c) 2017.
 *
 * This file is part of Project AGI. <http://agi.io>
 *
 * Project AGI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Project AGI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Project AGI.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.agi.framework.entities.convolutional;

import io.agi.framework.EntityConfig;

/**
 * Created by dave on 12/08/17.
 */
public class AutoencoderConvolutionalNetworkEntityConfig extends ConvolutionalNetworkEntityConfig {

    public int batchSize = 0;

    public float learningRate = 0;
    public float momentum = 0;
    public float weightsStdDev = 0;

    public String layerSparsity = "";
    public String layerSparsityLifetime = "";
    public String layerSparsityOutput = "";

}
