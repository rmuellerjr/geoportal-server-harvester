/*
 * Copyright 2016 Esri, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.esri.geoportal.harvester.engine;

import com.esri.geoportal.harvester.api.BrokerDefinition;
import java.util.UUID;

/**
 * Brokers information.
 */
public final class BrokerInfo {
  private final UUID uuid;
  private final Category category;
  private final BrokerDefinition brokerDefinition;

  /**
   * Creates instance of the broker info.
   * @param uuid broker uuid.
   * @param category broker category
   * @param brokerDefinition broker definition
   */
  public BrokerInfo(UUID uuid, Category category, BrokerDefinition brokerDefinition) {
    this.uuid = uuid;
    this.category = category;
    this.brokerDefinition = brokerDefinition;
  }

  /**
   * Gets broker uuid.
   * @return broker uuid
   */
  public UUID getUuid() {
    return uuid;
  }

  /**
   * Gets broker category.
   * @return broker category
   */
  public Category getCategory() {
    return category;
  }

  /**
   * Gets broker definition.
   * @return broker definition
   */
  public BrokerDefinition getBrokerDefinition() {
    return brokerDefinition;
  }
  
  /**
   * Broker category.
   */
  public static enum Category {
    /** inbound broker */
    INBOUND, 
    /** outbound broker */
    OUTBOUND
  }
}
