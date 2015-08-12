/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
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
import org.omg.oti._
import org.omg.oti.uml.read.operations.UMLQualifierValueOps

// End of user code

/**
 * A QualifierValue is an Element that is used as part of LinkEndData to provide the value for a single qualifier of the end given by the LinkEndData.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLQualifierValue[Uml <: UML]
  extends UMLElement[Uml]
  with UMLQualifierValueOps[Uml] {

  import ops._

  /**
   * The qualifier Property for which the value is to be specified.
   *
   * <!-- Start of user code doc for qualifier -->
   * <!-- End of user code doc for qualifier -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
   * @opposite org.omg.oti.api.UMLProperty.qualifier_qualifierValue
   */
  def qualifier: Option[UMLProperty[Uml]]

  /**
   * The InputPin from which the specified value for the qualifier is taken.
   *
   * <!-- Start of user code doc for value -->
   * <!-- End of user code doc for value -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
   * @opposite org.omg.oti.api.UMLInputPin.value_qualifierValue
   */
  def value: Option[UMLInputPin[Uml]]

  /**
   * The XMI meta-attributes relevant to this object
   *
   * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
   */
  override def metaAttributes: MetaAttributeFunctions =
    qualifierValue_metaAttributes

  /**
   * The XMI meta-attributes relevant to class UMLQualifierValue
   *
   * <!-- Start of user code doc for qualifierValue_metaAttributes -->
   * <!-- End of user code doc for qualifierValue_metaAttributes -->
   */
  def qualifierValue_metaAttributes: MetaAttributeFunctions =
    appendUnique(
      element_metaAttributes,
      Seq ())

  /**
   * The XMI composite meta-properties relevant to this object
   *
   * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
   */
  override def compositeMetaProperties: MetaPropertyFunctions =
    qualifierValue_compositeMetaProperties

  /**
   * The XMI composite meta-properties relevant to class UMLQualifierValue
   *
   * <!-- Start of user code doc for qualifierValue_compositeMetaProperties -->
   * <!-- End of user code doc for qualifierValue_compositeMetaProperties -->
   */
  def qualifierValue_compositeMetaProperties: MetaPropertyFunctions =
    appendUnique(
      element_compositeMetaProperties,
      Seq ())

  /**
   * The XMI reference meta-properties relevant to this object
   *
   * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
   */
  override def referenceMetaProperties: MetaPropertyFunctions =
    qualifierValue_referenceMetaProperties

  /**
   * The XMI reference meta-properties relevant to class UMLQualifierValue
   *
   * <!-- Start of user code doc for qualifierValue_referenceMetaProperties -->
   * <!-- End of user code doc for qualifierValue_referenceMetaProperties -->
   */
  def qualifierValue_referenceMetaProperties: MetaPropertyFunctions =
    appendUnique(
      element_referenceMetaProperties,
      Seq (QualifierValue_qualifier,
        QualifierValue_value))

  /**
   * The XMI forward references from metamodel associations relevant to this object
   *
   * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
   */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    qualifierValue_forwardReferencesFromMetamodelAssociations

  /**
   * The XMI forward references from metamodel associations relevant to class UMLQualifierValue
   *
   * <!-- Start of user code doc for qualifierValue_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for qualifierValue_forwardReferencesFromMetamodelAssociations -->
   */
  def qualifierValue_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    qualifier ++
    value

  // Start of user code for additional features
  // End of user code
} //UMLQualifierValue
