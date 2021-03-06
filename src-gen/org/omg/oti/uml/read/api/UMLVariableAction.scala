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
import org.omg.oti.uml.read.operations.UMLVariableActionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * VariableAction is an abstract class for Actions that operate on a specified Variable.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLVariableAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLVariableActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Variable to be read or written.
    *
    * <!-- Start of user code doc for variable -->
    * <!-- End of user code doc for variable -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLVariable.variable_variableAction
    */
  def variable: Option[UMLVariable[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      variableAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLVariableAction
    *
    * <!-- Start of user code doc for variableAction_metaAttributes -->
    * <!-- End of user code doc for variableAction_metaAttributes -->
    */
  def variableAction_metaAttributes: MetaAttributeFunctions = 
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
    variableAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLVariableAction
    *
    * <!-- Start of user code doc for variableAction_compositeMetaProperties -->
    * <!-- End of user code doc for variableAction_compositeMetaProperties -->
    */
  def variableAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    variableAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLVariableAction
    *
    * <!-- Start of user code doc for variableAction_referenceMetaProperties -->
    * <!-- End of user code doc for variableAction_referenceMetaProperties -->
    */
  def variableAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](VariableAction_variable))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    variableAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLVariableAction
    *
    * <!-- Start of user code doc for variableAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for variableAction_forwardReferencesFromMetamodelAssociations -->
    */
  def variableAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    variable

  // Start of user code for additional features
  // End of user code
} //UMLVariableAction
