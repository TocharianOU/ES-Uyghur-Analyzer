## Dictionary Explanation

### Features of Modern Uyghur Language
Modern Uyghur language exhibits rich morphological variations, especially in suffix changes. Characteristics of this language include vowel harmony, suffix chains, and word form changes in different contexts. Text processing in Uyghur needs to consider these morphological features to achieve effective word segmentation and semantic understanding.

### Dictionary Principles
Both dictionaries aim to support precise morphological analysis and processing of Uyghur text, but each has its own focus:

#### Original Dictionary (`ug_mor_original.txt`):

- **Principle**: This dictionary is based on the morphological principles of the Uyghur language, reconstructing words to their form before vowel weakening occurred. This means it attempts to restore each word to its most basic, historical linguistic form.
- **Example Analysis**:
  - Original Text: "يېزىلاردىكى ئېشىنچا ئەمگەكچىلەرنى"
  - Tokenization Result:
    - "يېزا" - Restored to the original root form
    - "لار" - Indicates plural
    - "دىكى" - Genitive suffix
    - "ئېشىنچا" - Independent word
    - "ئەمگەكچى" - Base form
    - "لەر" - Indicates plural
    - "نى" - Accusative suffix

#### Split Dictionary (`ug_mor_split.txt`):

- **Principle**: This dictionary also focuses on morphological analysis but retains the actual usage form of words in the current context, without deep linguistic restoration. It is more focused on modern text processing, ensuring semantic accuracy and text fluency.
- **Example Analysis**:
  - Original Text: "يېزىلاردىكى ئېشىنچا ئەمگەكچىلەرنى"
  - Tokenization Result:
    - "يېزى" - Maintains the modern written form
    - "لار" - Indicates plural
    - "دىكى" - Genitive suffix
    - "ئېشىنچا" - Independent word
    - "ئەمگەكچى" - Base form
    - "لەر" - Indicates plural
    - "نى" - Accusative suffix

By using these two dictionaries, users can choose the appropriate dictionary for text analysis based on their application scenarios. The Original Dictionary is suitable for historical or linguistic research, while the Split Dictionary is more suitable for everyday modern text processing and search engine optimization tasks.
