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
package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code

/**
  * A Trigger specifies a specific point  at which an Event occurrence may trigger an effect in a Behavior. A Trigger may be qualified by the Port on which the Event occurred.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTriggerOps[Uml <: UML] { self: UMLTrigger[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for deferrableTrigger_state -->
    * <!-- End of user code doc for deferrableTrigger_state -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLState.deferrableTrigger
    */
  def deferrableTrigger_state: Option[UMLState[Uml]] = owner.selectByKindOf { case x: UMLState[Uml] => x }

  /**
    * <!-- Start of user code doc for trigger_acceptEventAction -->
    * <!-- End of user code doc for trigger_acceptEventAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAcceptEventAction.trigger
    */
  def trigger_acceptEventAction: Option[UMLAcceptEventAction[Uml]] = owner.selectByKindOf { case x: UMLAcceptEventAction[Uml] => x }

  /**
    * <!-- Start of user code doc for trigger_transition -->
    * <!-- End of user code doc for trigger_transition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTransition.trigger
    */
  def trigger_transition: Option[UMLTransition[Uml]] = owner.selectByKindOf { case x: UMLTransition[Uml] => x }

  /**
    * If a Trigger specifies one or more ports, the event of the Trigger must be a MessageEvent.
    *
    * <!-- Start of user code doc for validate_trigger_with_ports -->
    * <!-- End of user code doc for validate_trigger_with_ports -->
    *
    * {{{
    * OCL Body port->notEmpty() implies event.oclIsKindOf(MessageEvent)
    * }}}
    */
  def validate_trigger_with_ports: Boolean = {
    // Start of user code for "trigger_with_ports"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLTriggerOps