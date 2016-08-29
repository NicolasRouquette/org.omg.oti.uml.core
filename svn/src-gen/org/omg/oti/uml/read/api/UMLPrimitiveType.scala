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
import org.omg.oti.uml.read.operations.UMLPrimitiveTypeOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A PrimitiveType defines a predefined DataType, without any substructure. A PrimitiveType may have an algebra and operations defined outside of UML, for example, mathematically.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPrimitiveType[Uml <: UML]
  extends UMLDataType[Uml]
  with UMLPrimitiveTypeOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      primitiveType_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLPrimitiveType
    *
    * <!-- Start of user code doc for primitiveType_metaAttributes -->
    * <!-- End of user code doc for primitiveType_metaAttributes -->
    */
  def primitiveType_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     dataType_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    primitiveType_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLPrimitiveType
    *
    * <!-- Start of user code doc for primitiveType_compositeMetaProperties -->
    * <!-- End of user code doc for primitiveType_compositeMetaProperties -->
    */
  def primitiveType_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      dataType_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    primitiveType_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLPrimitiveType
    *
    * <!-- Start of user code doc for primitiveType_referenceMetaProperties -->
    * <!-- End of user code doc for primitiveType_referenceMetaProperties -->
    */
  def primitiveType_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      dataType_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    primitiveType_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLPrimitiveType
    *
    * <!-- Start of user code doc for primitiveType_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for primitiveType_forwardReferencesFromMetamodelAssociations -->
    */
  def primitiveType_forwardReferencesFromMetamodelAssociations: Elements =
    dataType_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLPrimitiveType
