/*
 * Copyright 2018 Esri, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.esri.geoportal.commons.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PdfUtils {
    private static final Logger LOG = LoggerFactory.getLogger(PdfUtils.class);

    public static final String PROP_TITLE = "title";
    public static final String PROP_SUBJECT = "description";

    public static Properties readMetadata(InputStream rawBytes) throws IOException {
        Properties ret = new Properties();

        // Attempt to read in the PDF file
        try (PDDocument document = PDDocument.load(rawBytes)) {

            // See if we can read the PDF
            if (!document.isEncrypted()) {
                // Get the metadata
                PDDocumentCatalog catalog = document.getDocumentCatalog();
                PDMetadata metadata = catalog.getMetadata();

                if (metadata != null) {
                    // Get document metadata
                    PDDocumentInformation info = document.getDocumentInformation();

                    if (info.getTitle() != null) {
                        ret.put(PROP_TITLE, info.getTitle());
                    }
                    if (info.getSubject() != null) {
                        ret.put(PROP_SUBJECT, info.getSubject());
                    }
                } else {
                    LOG.warn("Got null metadata for PDF file");
                    return null;
                }

            } else {
                LOG.warn("Cannot read encrypted PDF file");
                return null;
            }

        } catch (IOException ex) {
            LOG.error("Exception reading PDF", ex);
            throw ex;
        }

        return ret;
    }
}