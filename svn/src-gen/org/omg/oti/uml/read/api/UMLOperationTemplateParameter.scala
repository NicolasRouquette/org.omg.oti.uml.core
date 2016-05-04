/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLOperationTemplateParameterOps

import scala.Boolean
import scala.Option
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An OperationTemplateParameter exposes an Operation as a formal parameter for a template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLOperationTemplateParameter[Uml <: UML]
  extends UMLTemplateParameter[Uml]
  with UMLOperationTemplateParameterOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Operation exposed by this OperationTemplateParameter.
    *
    * <!-- Start of user code doc for parameteredElement -->
    * <!-- End of user code doc for parameteredElement -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.templateParameter
    */
  override def parameteredElement: Option[UMLOperation[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      operationTemplateParameter_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLOperationTemplateParameter
    *
    * <!-- Start of user code doc for operationTemplateParameter_metaAttributes -->
    * <!-- End of user code doc for operationTemplateParameter_metaAttributes -->
    */
  def operationTemplateParameter_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     templateParameter_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    operationTemplateParameter_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLOperationTemplateParameter
    *
    * <!-- Start of user code doc for operationTemplateParameter_compositeMetaProperties -->
    * <!-- End of user code doc for operationTemplateParameter_compositeMetaProperties -->
    */
  def operationTemplateParameter_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      templateParameter_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    operationTemplateParameter_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLOperationTemplateParameter
    *
    * <!-- Start of user code doc for operationTemplateParameter_referenceMetaProperties -->
    * <!-- End of user code doc for operationTemplateParameter_referenceMetaProperties -->
    */
  def operationTemplateParameter_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      templateParameter_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](OperationTemplateParameter_parameteredElement))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    operationTemplateParameter_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLOperationTemplateParameter
    *
    * <!-- Start of user code doc for operationTemplateParameter_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for operationTemplateParameter_forwardReferencesFromMetamodelAssociations -->
    */
  def operationTemplateParameter_forwardReferencesFromMetamodelAssociations: Elements =
    templateParameter_forwardReferencesFromMetamodelAssociations ++
    parameteredElement

  // Start of user code for additional features
  // End of user code
} //UMLOperationTemplateParameter