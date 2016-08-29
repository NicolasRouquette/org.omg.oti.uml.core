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
import org.omg.oti.uml.read.operations.UMLActivityFinalNodeOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An ActivityFinalNode is a FinalNode that terminates the execution of its owning Activity or StructuredActivityNode.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActivityFinalNode[Uml <: UML]
  extends UMLFinalNode[Uml]
  with UMLActivityFinalNodeOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      activityFinalNode_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLActivityFinalNode
    *
    * <!-- Start of user code doc for activityFinalNode_metaAttributes -->
    * <!-- End of user code doc for activityFinalNode_metaAttributes -->
    */
  def activityFinalNode_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     finalNode_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    activityFinalNode_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLActivityFinalNode
    *
    * <!-- Start of user code doc for activityFinalNode_compositeMetaProperties -->
    * <!-- End of user code doc for activityFinalNode_compositeMetaProperties -->
    */
  def activityFinalNode_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      finalNode_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    activityFinalNode_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLActivityFinalNode
    *
    * <!-- Start of user code doc for activityFinalNode_referenceMetaProperties -->
    * <!-- End of user code doc for activityFinalNode_referenceMetaProperties -->
    */
  def activityFinalNode_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      finalNode_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    activityFinalNode_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLActivityFinalNode
    *
    * <!-- Start of user code doc for activityFinalNode_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for activityFinalNode_forwardReferencesFromMetamodelAssociations -->
    */
  def activityFinalNode_forwardReferencesFromMetamodelAssociations: Elements =
    finalNode_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLActivityFinalNode
