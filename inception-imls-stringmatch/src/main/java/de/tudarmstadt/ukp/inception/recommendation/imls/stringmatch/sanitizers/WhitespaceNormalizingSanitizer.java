/*
 * Copyright 2019
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.tudarmstadt.ukp.inception.recommendation.imls.stringmatch.sanitizers;

import de.tudarmstadt.ukp.inception.recommendation.imls.stringmatch.Trie.KeySanitizer;
import de.tudarmstadt.ukp.inception.recommendation.imls.stringmatch.Trie.KeySanitizerFactory;

public class WhitespaceNormalizingSanitizer
    implements KeySanitizer
{
    private boolean lastWasWhitespace = true;

    @Override
    public char map(char aChar)
    {
        boolean currentIsWhitespace = Character.isWhitespace(aChar);

        if (lastWasWhitespace && currentIsWhitespace) {
            return SKIP_CHAR;
        }

        char result = currentIsWhitespace && aChar != ' ' ? ' ' : aChar;
        lastWasWhitespace = currentIsWhitespace;

        return result;
    }
    
    public static KeySanitizerFactory factory()
    {
        return () -> new WhitespaceNormalizingSanitizer();
    }
}
