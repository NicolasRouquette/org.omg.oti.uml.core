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
import org.omg.oti.uml.read.operations.UMLBroadcastSignalActionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A BroadcastSignalAction is an InvocationAction that transmits a Signal instance to all the potential target objects in the system. Values from the argument InputPins are used to provide values for the attributes of the Signal. The requestor continues execution immediately after the Signal instances are sent out and cannot receive reply values.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLBroadcastSignalAction[Uml <: UML]
  extends UMLInvocationAction[Uml]
  with UMLBroadcastSignalActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Signal whose instances are to be sent.
    *
    * <!-- Start of user code doc for signal -->
    * <!-- End of user code doc for signal -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSignal.signal_broadcastSignalAction
    */
  def signal: Option[UMLSignal[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      broadcastSignalAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLBroadcastSignalAction
    *
    * <!-- Start of user code doc for broadcastSignalAction_metaAttributes -->
    * <!-- End of user code doc for broadcastSignalAction_metaAttributes -->
    */
  def broadcastSignalAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     invocationAction_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    broadcastSignalAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLBroadcastSignalAction
    *
    * <!-- Start of user code doc for broadcastSignalAction_compositeMetaProperties -->
    * <!-- End of user code doc for broadcastSignalAction_compositeMetaProperties -->
    */
  def broadcastSignalAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      invocationAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    broadcastSignalAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLBroadcastSignalAction
    *
    * <!-- Start of user code doc for broadcastSignalAction_referenceMetaProperties -->
    * <!-- End of user code doc for broadcastSignalAction_referenceMetaProperties -->
    */
  def broadcastSignalAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      invocationAction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](BroadcastSignalAction_signal))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    broadcastSignalAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLBroadcastSignalAction
    *
    * <!-- Start of user code doc for broadcastSignalAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for broadcastSignalAction_forwardReferencesFromMetamodelAssociations -->
    */
  def broadcastSignalAction_forwardReferencesFromMetamodelAssociations: Elements =
    invocationAction_forwardReferencesFromMetamodelAssociations ++
    signal

  // Start of user code for additional features
  // End of user code
} //UMLBroadcastSignalAction
