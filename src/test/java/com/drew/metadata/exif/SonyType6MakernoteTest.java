/*
 * Copyright 2002-2012 Drew Noakes
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 * More information about this project is available at:
 *
 *    http://drewnoakes.com/code/exif/
 *    http://code.google.com/p/metadata-extractor/
 */

package com.drew.metadata.exif;

import com.drew.lang.TestHelper;
import com.drew.metadata.Metadata;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/** @author Drew Noakes http://drewnoakes.com */
public class SonyType6MakernoteTest
{
    @Test public void testSonyType6Makernote() throws ClassNotFoundException, IOException
    {
        Metadata metadata = TestHelper.readJpegMetadataFile("src/test/java/com/drew/metadata/exif/sonyType6.metadata");

        SonyType6MakernoteDirectory directory = metadata.getDirectory(SonyType6MakernoteDirectory.class);

        Assert.assertNotNull(directory);
        Assert.assertFalse(directory.hasErrors());

        SonyType6MakernoteDescriptor descriptor = new SonyType6MakernoteDescriptor(directory);

        Assert.assertEquals("2.00", descriptor.getMakerNoteThumbVersionDescription());
    }
}
