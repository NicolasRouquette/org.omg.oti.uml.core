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
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
import scala.Predef.???

// End of user code

/**
  * WriteVariableAction is an abstract class for VariableActions that change Variable values.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLWriteVariableActionOps[Uml <: UML] { self: UMLWriteVariableAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The InputPin that gives the value to be added or removed from the Variable.
    *
    * <!-- Start of user code doc for value -->
    * <!-- End of user code doc for value -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.value_writeVariableAction
    */
  def value: Option[UMLInputPin[Uml]] = input headOption

  /**
    * The multiplicity of the value InputPin is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity -->
    * <!-- End of user code doc for validate_multiplicity -->
    *
    * {{{
    * OCL Body value<>null implies value.is(1,1)
    * }}}
    */
  def validate_multiplicity: Boolean = {
    // Start of user code for "multiplicity"
    ???
    // End of user code
  }

  /**
    * The type of the value InputPin must conform to the type of the variable.
    *
    * <!-- Start of user code doc for validate_value_type -->
    * <!-- End of user code doc for validate_value_type -->
    *
    * {{{
    * OCL Body value <> null implies value.type.conformsTo(variable.type)
    * }}}
    */
  def validate_value_type: Boolean = {
    // Start of user code for "value_type"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLWriteVariableActionOps