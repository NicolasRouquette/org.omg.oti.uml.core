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
import org.omg.oti.uml.read.operations.UMLExecutableNodeOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An ExecutableNode is an abstract class for ActivityNodes whose execution may be controlled using ControlFlows and to which ExceptionHandlers may be attached.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExecutableNode[Uml <: UML]
  extends UMLActivityNode[Uml]
  with UMLExecutableNodeOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * <!-- Start of user code doc for bodyPart_loopNode -->
    * <!-- End of user code doc for bodyPart_loopNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLoopNode.bodyPart
    */
  def bodyPart_loopNode: Option[UMLLoopNode[Uml]]

  /**
    * <!-- Start of user code doc for body_clause -->
    * <!-- End of user code doc for body_clause -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClause.body
    */
  def body_clause: Option[UMLClause[Uml]]

  /**
    * <!-- Start of user code doc for handlerBody_exceptionHandler -->
    * <!-- End of user code doc for handlerBody_exceptionHandler -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExceptionHandler.handlerBody
    */
  def handlerBody_exceptionHandler: Set[UMLExceptionHandler[Uml]]

  /**
    * <!-- Start of user code doc for setupPart_loopNode -->
    * <!-- End of user code doc for setupPart_loopNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLoopNode.setupPart
    */
  def setupPart_loopNode: Option[UMLLoopNode[Uml]]

  /**
    * <!-- Start of user code doc for test_clause -->
    * <!-- End of user code doc for test_clause -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClause.test
    */
  def test_clause: Option[UMLClause[Uml]]

  /**
    * <!-- Start of user code doc for test_loopNode -->
    * <!-- End of user code doc for test_loopNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLoopNode.test
    */
  def test_loopNode: Option[UMLLoopNode[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      executableNode_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLExecutableNode
    *
    * <!-- Start of user code doc for executableNode_metaAttributes -->
    * <!-- End of user code doc for executableNode_metaAttributes -->
    */
  def executableNode_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     activityNode_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    executableNode_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLExecutableNode
    *
    * <!-- Start of user code doc for executableNode_compositeMetaProperties -->
    * <!-- End of user code doc for executableNode_compositeMetaProperties -->
    */
  def executableNode_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      activityNode_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ExecutableNode_handler))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    executableNode_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLExecutableNode
    *
    * <!-- Start of user code doc for executableNode_referenceMetaProperties -->
    * <!-- End of user code doc for executableNode_referenceMetaProperties -->
    */
  def executableNode_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      activityNode_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    executableNode_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLExecutableNode
    *
    * <!-- Start of user code doc for executableNode_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for executableNode_forwardReferencesFromMetamodelAssociations -->
    */
  def executableNode_forwardReferencesFromMetamodelAssociations: Elements =
    activityNode_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLExecutableNode