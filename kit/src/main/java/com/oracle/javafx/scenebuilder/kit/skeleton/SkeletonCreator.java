/*
 * Copyright (c) 2023, Oliver Loeffler.
 * Copyright (c) 2022, Gluon and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.oracle.javafx.scenebuilder.kit.skeleton;

import com.oracle.javafx.scenebuilder.kit.skeleton.SkeletonSettings.LANGUAGE;

/**
 * Implement this interface to integrate new languages where Scene Builder shall
 * create controller class templates for.
 * 
 * Classes which implement this interface may then get registered in
 * {@link LANGUAGE} type. If the new {@link SkeletonCreator} is known to
 * {@link LANGUAGE}, it will be immediately available in Scene Builder GUI.
 * 
 */
public interface SkeletonCreator {
    
    /**
     * Consumes a given {@link SkeletonContext} and converts it into a source code
     * template for a particular language.
     * 
     * @param context {@link SkeletonContext} for the given Scene
     * @return String template source code for a certain language
     */
    String createFrom(SkeletonContext context);
    
    /**
     * Provides the typical file name extension for a language, e.g. {@code .java}
     * or {@code .scala}. This will be used to create file name filters in GUI and
     * to create file name proposals.
     */
    String fileExtension();
    
    /**
     * Provides the language name such as Java, Kotlin or Scala. This name will
     * appear in application GUI.
     */
    String languageName();
}