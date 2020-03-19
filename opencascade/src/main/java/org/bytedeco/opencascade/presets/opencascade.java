/*
 * Copyright (C) Laurens Van Houtven
 *
 * Licensed either under the Apache License, Version 2.0, or (at your option)
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation (subject to the "Classpath" exception),
 * either version 2, or any later version (collectively, the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     http://www.gnu.org/licenses/
 *     http://www.gnu.org/software/classpath/license.html
 *
 * or as provided in the LICENSE.txt file that accompanied this code.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bytedeco.opencascade.presets;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

import org.bytedeco.opencascade.presets.frameworks.Foundation;

/**
 *
 * @author Laurens Van Houtven
 */
@Properties(
    inherit = {Foundation.class},
    target = "org.bytedeco.opencascade", 
    global = "org.bytedeco.opencascade.global.opencascade"
)

public class opencascade implements InfoMapper {
    static {
        Loader.checkVersion("org.bytedeco", "opencascade");
    }

    public void map(final InfoMap infoMap) {
        infoMap.put(new Info("DEFINE_STANDARD_ALLOC", "DEFINE_STANDARD_ALLOC_ARRAY", "DEFINE_STANDARD_ALLOC_PLACEMENT",
                "DEFINE_NCOLLECTION_ALLOC", "STANDARD_ALIGNED", "WORKAROUND_SUNPRO_NEW_PLACEMENT", "Standard_EXPORT")
                        .cppTypes().annotations());
        infoMap.put(new Info("__QNX__").define(false));
        infoMap.put(new Info("defined (__alpha) || defined(DECOSF1)").define(false));
        infoMap.put(new Info("HLRBRep_InternalAlgo").skip());
        infoMap.put(new Info("HLRBRep_PolyAlgo").skip());
        infoMap.put(new Info("TARGET_OS_IPHONE").define(false));
        infoMap.put(new Info("__OBJC__").define(false));
        infoMap.put(new Info("opencascade::handle").pointerTypes("Handle"));
        infoMap.put(new Info("NCollection_Haft").skip());
    }
}
