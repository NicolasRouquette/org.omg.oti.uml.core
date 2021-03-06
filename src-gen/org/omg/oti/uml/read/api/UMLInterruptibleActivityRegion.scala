/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLInterruptibleActivityRegionOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An InterruptibleActivityRegion is an ActivityGroup that supports the termination of tokens flowing in the portions of an activity within it.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInterruptibleActivityRegion[Uml <: UML]
  extends UMLActivityGroup[Uml]
  with UMLInterruptibleActivityRegionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The ActivityEdges leaving the InterruptibleActivityRegion on which a traversing token will result in the termination of other tokens flowing in the InterruptibleActivityRegion.
    *
    * <!-- Start of user code doc for interruptingEdge -->
    * <!-- End of user code doc for interruptingEdge -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityEdge.interrupts
    */
  def interruptingEdge: Set[UMLActivityEdge[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      interruptibleActivityRegion_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLInterruptibleActivityRegion
    *
    * <!-- Start of user code doc for interruptibleActivityRegion_metaAttributes -->
    * <!-- End of user code doc for interruptibleActivityRegion_metaAttributes -->
    */
  def interruptibleActivityRegion_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     activityGroup_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    interruptibleActivityRegion_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLInterruptibleActivityRegion
    *
    * <!-- Start of user code doc for interruptibleActivityRegion_compositeMetaProperties -->
    * <!-- End of user code doc for interruptibleActivityRegion_compositeMetaProperties -->
    */
  def interruptibleActivityRegion_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      activityGroup_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    interruptibleActivityRegion_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLInterruptibleActivityRegion
    *
    * <!-- Start of user code doc for interruptibleActivityRegion_referenceMetaProperties -->
    * <!-- End of user code doc for interruptibleActivityRegion_referenceMetaProperties -->
    */
  def interruptibleActivityRegion_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      activityGroup_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](InterruptibleActivityRegion_interruptingEdge,
      	InterruptibleActivityRegion_node))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    interruptibleActivityRegion_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLInterruptibleActivityRegion
    *
    * <!-- Start of user code doc for interruptibleActivityRegion_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for interruptibleActivityRegion_forwardReferencesFromMetamodelAssociations -->
    */
  def interruptibleActivityRegion_forwardReferencesFromMetamodelAssociations: Elements =
    activityGroup_forwardReferencesFromMetamodelAssociations ++
    interruptingEdge ++
    node

  // Start of user code for additional features
  // End of user code
} //UMLInterruptibleActivityRegion
