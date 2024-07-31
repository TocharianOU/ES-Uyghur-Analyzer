/*
 * Licensed to Tocharian under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Tocharian licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.tocharian;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

import java.io.IOException;
import java.util.Map;

public class UyghurWordTokenFilter extends TokenFilter {
    private final CharTermAttribute termAttr = addAttribute(CharTermAttribute.class);
    private final OffsetAttribute offsetAttr = addAttribute(OffsetAttribute.class);
    private final Map<String, String[]> dictionary;
    private String[] currentParts;
    private int currentPartIndex;
    private int currentStartOffset;
    private int currentEndOffset;

    protected UyghurWordTokenFilter(TokenStream input, Map<String, String[]> dictionary) {
        super(input);
        this.dictionary = dictionary;
    }

    @Override
    public final boolean incrementToken() throws IOException {
        if (currentParts != null && currentPartIndex < currentParts.length) {
            clearAttributes();
            termAttr.append(currentParts[currentPartIndex]);
            int length = currentParts[currentPartIndex].length();
            offsetAttr.setOffset(currentStartOffset, currentStartOffset + length);
            currentStartOffset += length + 1; // +1 to account for the space or punctuation
            currentPartIndex++;
            return true;
        }

        if (input.incrementToken()) {
            String token = termAttr.toString();
            if (dictionary.containsKey(token)) {
                currentParts = dictionary.get(token);
                currentPartIndex = 0;
                currentStartOffset = offsetAttr.startOffset();
                currentEndOffset = offsetAttr.endOffset();
                return incrementToken();
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
