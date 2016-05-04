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
import org.omg.oti.uml.read.operations.UMLTemplateSignatureOps

import scala.collection.immutable.Seq
// End of user code


/**
  * A Template Signature bundles the set of formal TemplateParameters for a template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTemplateSignature[Uml <: UML]
  extends UMLElement[Uml]
  with UMLTemplateSignatureOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The formal parameters that are owned by this TemplateSignature.
    *
    * <!-- Start of user code doc for ownedParameter -->
    * <!-- End of user code doc for ownedParameter -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateParameter.signature
    */
  def ownedParameter: Seq[UMLTemplateParameter[Uml]]

  /**
    * The ordered set of all formal TemplateParameters for this TemplateSignature.
    *
    * <!-- Start of user code doc for parameter -->
    * <!-- End of user code doc for parameter -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateParameter.parameter_templateSignature
    */
  def parameter: Seq[UMLTemplateParameter[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      templateSignature_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLTemplateSignature
    *
    * <!-- Start of user code doc for templateSignature_metaAttributes -->
    * <!-- End of user code doc for templateSignature_metaAttributes -->
    */
  def templateSignature_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     element_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    templateSignature_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLTemplateSignature
    *
    * <!-- Start of user code doc for templateSignature_compositeMetaProperties -->
    * <!-- End of user code doc for templateSignature_compositeMetaProperties -->
    */
  def templateSignature_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](TemplateSignature_ownedParameter))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    templateSignature_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLTemplateSignature
    *
    * <!-- Start of user code doc for templateSignature_referenceMetaProperties -->
    * <!-- End of user code doc for templateSignature_referenceMetaProperties -->
    */
  def templateSignature_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](TemplateSignature_parameter))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    templateSignature_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLTemplateSignature
    *
    * <!-- Start of user code doc for templateSignature_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for templateSignature_forwardReferencesFromMetamodelAssociations -->
    */
  def templateSignature_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    parameter

  // Start of user code for additional features
  // End of user code
} //UMLTemplateSignature