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
import org.omg.oti.uml.read.operations.UMLLiteralSpecificationOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A LiteralSpecification identifies a literal constant being modeled.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLiteralSpecification[Uml <: UML]
  extends UMLValueSpecification[Uml]
  with UMLLiteralSpecificationOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      literalSpecification_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLLiteralSpecification
    *
    * <!-- Start of user code doc for literalSpecification_metaAttributes -->
    * <!-- End of user code doc for literalSpecification_metaAttributes -->
    */
  def literalSpecification_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     valueSpecification_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    literalSpecification_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLLiteralSpecification
    *
    * <!-- Start of user code doc for literalSpecification_compositeMetaProperties -->
    * <!-- End of user code doc for literalSpecification_compositeMetaProperties -->
    */
  def literalSpecification_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      valueSpecification_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    literalSpecification_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLLiteralSpecification
    *
    * <!-- Start of user code doc for literalSpecification_referenceMetaProperties -->
    * <!-- End of user code doc for literalSpecification_referenceMetaProperties -->
    */
  def literalSpecification_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      valueSpecification_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    literalSpecification_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLLiteralSpecification
    *
    * <!-- Start of user code doc for literalSpecification_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for literalSpecification_forwardReferencesFromMetamodelAssociations -->
    */
  def literalSpecification_forwardReferencesFromMetamodelAssociations: Elements =
    valueSpecification_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLLiteralSpecification
