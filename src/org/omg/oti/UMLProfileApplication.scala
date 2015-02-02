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

trait UMLProfileApplication[Uml <: UML] extends UMLDirectedRelationship[Uml] {
  
  import ops._
  
  def isStrict: Boolean = false
  
  def applyingPackage: Option[UMLPackage[Uml]] = (sources.selectByKindOf { case p: UMLPackage[Uml] => p } toIterable).headOption
  def appliedProfile: Option[UMLProfile[Uml]] = (targets.selectByKindOf { case p: UMLProfile[Uml] => p } toIterable).headOption
  
  /**
   * Fig 12.12 (complete)
   */
  override def metaAttributes: MetaAttributeFunctions =
    profileApplication_metaAttributes
    
  def profileApplication_metaAttributes: MetaAttributeFunctions =
    directedRelationship_metaAttributes
    
  override def forwardReferencesFromMetamodelAssociations =
    profileApplication_forwardReferencesFromMetamodelAssociations
    
  def profileApplication_forwardReferencesFromMetamodelAssociations =
    directedRelationship_forwardReferencesFromMetamodelAssociations ++
    appliedProfile
    
  override def compositeMetaProperties: MetaPropertyFunctions =
    profileApplication_compositeMetaProperties
    
  def profileApplication_compositeMetaProperties =
    directedRelationship_compositeMetaProperties
    
  override def referenceMetaProperties: MetaPropertyFunctions =
    profileApplication_referenceMetaProperties
        
  def profileApplication_referenceMetaProperties =
    directedRelationship_referenceMetaProperties ++
    Seq( MetaPropertyReference[UMLProfileApplication[Uml], UMLProfile[Uml]]( "appliedProfile", _.appliedProfile ) )
    
}