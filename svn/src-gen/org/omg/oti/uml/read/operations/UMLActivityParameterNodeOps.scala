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
import scala.Boolean
import scala.{None,Some}
// End of user code

/**
  * An ActivityParameterNode is an ObjectNode for accepting values from the input Parameters or providing values to the output Parameters of an Activity.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActivityParameterNodeOps[Uml <: UML] { self: UMLActivityParameterNode[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The parameter of an ActivityParameterNode must be from the containing Activity.
    *
    * <!-- Start of user code doc for validate_has_parameters -->
    * <!-- End of user code doc for validate_has_parameters -->
    *
    * {{{
    * OCL Body activity.ownedParameter->includes(parameter)
    * }}}
    */
  def validate_has_parameters: Boolean = {
    // Start of user code for "has_parameters"
    activity match {
      case Some(a) => a.ownedParameter.contains(parameter)
      case None => false
    }
    // End of user code
  }

  /**
    * An ActivityParameterNode may have all incoming ActivityEdges or all outgoing ActivityEdges, but it must not have both incoming and outgoing ActivityEdges.
    *
    * <!-- Start of user code doc for validate_no_edges -->
    * <!-- End of user code doc for validate_no_edges -->
    *
    * {{{
    * OCL Body incoming->isEmpty() or outgoing->isEmpty()
    * }}}
    */
  def validate_no_edges: Boolean = {
    // Start of user code for "no_edges"
    incoming.isEmpty || outgoing.isEmpty
    // End of user code
  }

  /**
    * An ActivityParameterNode with no incoming ActivityEdges and one or more outgoing ActivityEdges must have a parameter with direction in or inout.
    *
    * <!-- Start of user code doc for validate_no_incoming_edges -->
    * <!-- End of user code doc for validate_no_incoming_edges -->
    *
    * {{{
    * OCL Body (outgoing->notEmpty() and incoming->isEmpty()) implies 
    * 	(parameter.direction = ParameterDirectionKind::_'in' or 
    * 	 parameter.direction = ParameterDirectionKind::inout)
    * }}}
    */
  def validate_no_incoming_edges: Boolean = {
    // Start of user code for "no_incoming_edges"
    if (!outgoing.isEmpty && incoming.isEmpty)
      parameter match {
        case Some(p) => p.direction == UMLParameterDirectionKind.in || p.direction == UMLParameterDirectionKind.inout
        case None => false
      }
    else true
    // End of user code
  }

  /**
    * An ActivityParameterNode with no outgoing ActivityEdges and one or more incoming ActivityEdges must have a parameter with direction out, inout, or return.
    *
    * <!-- Start of user code doc for validate_no_outgoing_edges -->
    * <!-- End of user code doc for validate_no_outgoing_edges -->
    *
    * {{{
    * OCL Body (incoming->notEmpty() and outgoing->isEmpty()) implies 
    * 	(parameter.direction = ParameterDirectionKind::out or 
    * 	 parameter.direction = ParameterDirectionKind::inout or 
    * 	 parameter.direction = ParameterDirectionKind::return)
    * }}}
    */
  def validate_no_outgoing_edges: Boolean = {
    // Start of user code for "no_outgoing_edges"
    if (!incoming.isEmpty && outgoing.isEmpty) {
        parameter match {
          case Some(p) => 
            p.direction == UMLParameterDirectionKind.out ||
            p.direction == UMLParameterDirectionKind.inout ||
            p.direction == UMLParameterDirectionKind._return
          case None => false
        }
      } else true
    // End of user code
  }

  /**
    * The type of an ActivityParameterNode is the same as the type of its parameter.
    *
    * <!-- Start of user code doc for validate_same_type -->
    * <!-- End of user code doc for validate_same_type -->
    *
    * {{{
    * OCL Body type = parameter.type
    * }}}
    */
  def validate_same_type: Boolean = {
    // Start of user code for "same_type"
    parameter match {
      case Some(p) => self._type == p._type
      case None => false
    }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLActivityParameterNodeOps