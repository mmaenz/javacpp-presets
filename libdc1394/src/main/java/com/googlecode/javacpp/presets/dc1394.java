/*
 * Copyright (C) 2013 Samuel Audet
 *
 * This file is part of JavaCPP.
 *
 * JavaCPP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version (subject to the "Classpath" exception
 * as provided in the LICENSE.txt file that accompanied this code).
 *
 * JavaCPP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JavaCPP.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.googlecode.javacpp.presets;

import com.googlecode.javacpp.Parser;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.Properties;

/**
 *
 * @author Samuel Audet
 */
@Properties(target="com.googlecode.javacpp.dc1394", value={
    @Platform(include={"<dc1394/dc1394.h>", "<dc1394/types.h>", "<dc1394/log.h>", "<dc1394/camera.h>",
        "<dc1394/control.h>", "<dc1394/capture.h>", "<dc1394/conversions.h>", "<dc1394/format7.h>",
        "<dc1394/iso.h>", "<dc1394/register.h>", "<dc1394/video.h>", "<dc1394/utils.h>"}, link="dc1394@.22") })
public class dc1394 implements Parser.InfoMapper {
    public void map(Parser.InfoMap infoMap) {
        infoMap.put(new Parser.Info("restrict").genericArgs())
               .put(new Parser.Info("YUV2RGB", "RGB2YUV").genericArgs("void", "int", "int", "int", "@ByRef int[]", "@ByRef int[]", "@ByRef int[]"));
    }
}
