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
package org.omg.oti

import scala.language.postfixOps

trait UMLNamespace[Uml <: UML] extends UMLNamedElement[Uml] with UMLNamespaceOps[Uml] { 

  import ops._

  def members: Set[UMLNamedElement[Uml]]
  def ownedMembers: Set[UMLNamedElement[Uml]] = 
    members & ( ownedElements.selectByKindOf { case ne: UMLNamedElement[Uml] => ne } )

  def elementImports: Set[UMLElementImport[Uml]] = 
    directedRelationships_source.selectByKindOf { case ei: UMLElementImport[Uml] => ei }

  def packageImports: Set[UMLPackageImport[Uml]] = 
    directedRelationships_source.selectByKindOf { case pi: UMLPackageImport[Uml] => pi }

  def ownedRules: Set[UMLConstraint[Uml]] = 
    ownedMembers.selectByKindOf { case c: UMLConstraint[Uml] => c }

  /**
   * Fig 7.5 (complete)
   */
  def namespace_metaAttributes: MetaAttributeFunctions =
    namedElement_metaAttributes

  def namespace_forwardReferencesFromMetamodelAssociations: Set[UMLElement[Uml]] =
    namedElement_forwardReferencesFromMetamodelAssociations

  def namespace_compositeMetaProperties: MetaPropertyFunctions =
    namedElement_compositeMetaProperties ++
      Seq(
        MetaPropertyCollection[UMLNamespace[Uml], UMLElementImport[Uml]]( "elementImport", _.elementImports ),
        MetaPropertyCollection[UMLNamespace[Uml], UMLConstraint[Uml]]( "ownedRule", _.ownedRules ),
        MetaPropertyCollection[UMLNamespace[Uml], UMLPackageImport[Uml]]( "packageImport", _.packageImports ) )

  def namespace_referenceMetaProperties: MetaPropertyFunctions =
    namedElement_referenceMetaProperties

}