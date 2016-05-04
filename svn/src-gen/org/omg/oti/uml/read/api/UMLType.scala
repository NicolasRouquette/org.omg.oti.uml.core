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
import org.omg.oti.uml.read.operations.UMLTypeOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Type constrains the values represented by a TypedElement.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLType[Uml <: UML]
  extends UMLPackageableElement[Uml]
  with UMLTypeOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * Specifies the owning Package of this Type, if any.
    *
    * <!-- Start of user code doc for _package -->
    * <!-- End of user code doc for _package -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackage.ownedType
    */
  def _package: Option[UMLPackage[Uml]]

  /**
    * <!-- Start of user code doc for raisedException_behavioralFeature -->
    * <!-- End of user code doc for raisedException_behavioralFeature -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavioralFeature.raisedException
    */
  def raisedException_behavioralFeature: Set[UMLBehavioralFeature[Uml]]

  /**
    * <!-- Start of user code doc for type_operation -->
    * <!-- End of user code doc for type_operation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation._type
    */
  def type_operation: Set[UMLOperation[Uml]]

  /**
    * <!-- Start of user code doc for type_typedElement -->
    * <!-- End of user code doc for type_typedElement -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTypedElement._type
    */
  def type_typedElement: Set[UMLTypedElement[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      type_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLType
    *
    * <!-- Start of user code doc for type_metaAttributes -->
    * <!-- End of user code doc for type_metaAttributes -->
    */
  def type_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     packageableElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    type_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLType
    *
    * <!-- Start of user code doc for type_compositeMetaProperties -->
    * <!-- End of user code doc for type_compositeMetaProperties -->
    */
  def type_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      packageableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    type_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLType
    *
    * <!-- Start of user code doc for type_referenceMetaProperties -->
    * <!-- End of user code doc for type_referenceMetaProperties -->
    */
  def type_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      packageableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    type_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLType
    *
    * <!-- Start of user code doc for type_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for type_forwardReferencesFromMetamodelAssociations -->
    */
  def type_forwardReferencesFromMetamodelAssociations: Elements =
    packageableElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLType