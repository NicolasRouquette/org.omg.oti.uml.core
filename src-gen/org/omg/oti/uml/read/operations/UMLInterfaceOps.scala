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
  * Interfaces declare coherent services that are implemented by BehavioredClassifiers that implement the Interfaces via InterfaceRealizations.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInterfaceOps[Uml <: UML] { self: UMLInterface[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Receptions that objects providing this Interface are willing to accept.
    *
    * <!-- Start of user code doc for ownedReception -->
    * <!-- End of user code doc for ownedReception -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReception.ownedReception_interface
    */
  def ownedReception: Set[UMLReception[Uml]] = feature.selectByKindOf { case x: UMLReception[Uml] => x }

  /**
    * References a ProtocolStateMachine specifying the legal sequences of the invocation of the BehavioralFeatures described in the Interface.
    *
    * <!-- Start of user code doc for protocol -->
    * <!-- End of user code doc for protocol -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProtocolStateMachine.protocol_interface
    */
  def protocol: Option[UMLProtocolStateMachine[Uml]] = ownedMember.selectByKindOf { case x: UMLProtocolStateMachine[Uml] => x } headOption

  /**
    * The visibility of all Features owned by an Interface must be public.
    *
    * <!-- Start of user code doc for validate_visibility -->
    * <!-- End of user code doc for validate_visibility -->
    *
    * {{{
    * OCL Body feature->forAll(visibility = VisibilityKind::public)
    * }}}
    */
  def validate_visibility: Boolean = {
    // Start of user code for "visibility"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLInterfaceOps
