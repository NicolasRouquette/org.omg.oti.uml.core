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
import org.omg.oti.uml.read.operations.UMLLinkActionOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * LinkAction is an abstract class for all Actions that identify the links to be acted on using LinkEndData.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLinkAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLLinkActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      linkAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLLinkAction
    *
    * <!-- Start of user code doc for linkAction_metaAttributes -->
    * <!-- End of user code doc for linkAction_metaAttributes -->
    */
  def linkAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     action_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    linkAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLLinkAction
    *
    * <!-- Start of user code doc for linkAction_compositeMetaProperties -->
    * <!-- End of user code doc for linkAction_compositeMetaProperties -->
    */
  def linkAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](LinkAction_endData,
      	LinkAction_inputValue))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    linkAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLLinkAction
    *
    * <!-- Start of user code doc for linkAction_referenceMetaProperties -->
    * <!-- End of user code doc for linkAction_referenceMetaProperties -->
    */
  def linkAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    linkAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLLinkAction
    *
    * <!-- Start of user code doc for linkAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for linkAction_forwardReferencesFromMetamodelAssociations -->
    */
  def linkAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLLinkAction
