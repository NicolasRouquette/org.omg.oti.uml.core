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

import org.omg.oti.uml.UMLError
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.xmi.IDGenerator
import scala.language.postfixOps
import scala.Boolean
import scala.{Option,None,Some}
import scala.Predef.String
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
import scalaz._, Scalaz._
// End of user code

/**
  * A package merge defines how the contents of one package are extended by the contents of another package.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPackageMergeOps[Uml <: UML] { self: UMLPackageMerge[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * References the Package that is to be merged with the receiving package of the PackageMerge.
    *
    * <!-- Start of user code doc for mergedPackage -->
    * <!-- End of user code doc for mergedPackage -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackage.mergedPackage_packageMerge
    */
  def mergedPackage: Option[UMLPackage[Uml]] = target.selectByKindOf { case x: UMLPackage[Uml] => x } headOption

  /**
    * References the Package that is being extended with the contents of the merged package of the PackageMerge.
    *
    * <!-- Start of user code doc for receivingPackage -->
    * <!-- End of user code doc for receivingPackage -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackage.packageMerge
    */
  def receivingPackage: Option[UMLPackage[Uml]] = owner.selectByKindOf { case x: UMLPackage[Uml] => x }

  // Start of user code for additional features

  override def xmiOrderingKey()(implicit idg: IDGenerator[Uml])
  : Set[java.lang.Throwable] \/ String
  = for {
	key <- element_xmiOrderingKey
	i <- mergedPackage.fold[Set[java.lang.Throwable] \/ String]("_".right){ mp =>
		mp.xmiOrderingKey.map("_" + _)
	}
  } yield key + i

  // End of user code
} //UMLPackageMergeOps